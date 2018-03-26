package com.instanza.soma.Service.Setting;

import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E05_03_03_DeleteAccount;
import com.instanza.soma.resources.E05_03_Account;
import com.instanza.soma.resources.E05_Setting;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by sam on 2017/3/6.
 */
public class AccountPage {
    public AppOperation appOperation;

    public enum AccountCase {MyNumber, Privacy, AccountDelete;}

    private static AccountPage deleteAccountObj;

    public static AccountPage getInstance() {
        if (deleteAccountObj == null) {
            synchronized (AccountPage.class) {
                if (deleteAccountObj == null) {
                    deleteAccountObj = new AccountPage();
                }
            }
        }
        return deleteAccountObj;
    }

    public AccountPage(){
        appOperation = AppOperationImp.getInstance();
    }


    /**
     * 点击settings展开后点击Account,校验该页面的三项文案内容
     *
     * @param driver
     */
    public void accountContent(AppiumDriver driver) {
        String myNumber = appOperation.getElement(driver, E05_03_Account.row_MyNumber_text1).getText();
        Assert.assertEquals(myNumber, E05_03_Account.my_number);
        String privacy = appOperation.getElement(driver, E05_03_Account.row_privacy_text1).getText();
        Assert.assertEquals(privacy, E05_03_Account.privacy);
        String Delete = appOperation.getElement(driver, E05_03_Account.row_deleteaccount_text1).getText();
        Assert.assertEquals(Delete, E05_03_Account.delete_my_account);
//        appOperation.click(driver, E05_03_Account.returnBack, 0);//左上角返回按钮
    }

    /**
     * Account的privacy页，校验privacy页面messaging部分所有文案
     *
     * @param driver
     */
    public void privacyLastseenDesc(AppiumDriver driver) {
        accountToPrivacy(driver);//到privacy页
        String whocansee = appOperation.getElement(driver, E05_03_Account.row_lastseen_label).getText();
        Assert.assertTrue(whocansee.contains(E05_03_Account.row_lastseen_info));
        String lastseen = appOperation.getElement(driver, E05_03_Account.row_lastseen_text1).getText();
        Assert.assertTrue(lastseen.equals(E05_03_Account.last_seen));
        String lastseenDesc = appOperation.getElement(driver, E05_03_Account.row_lastseen_comment).getText();
        Assert.assertTrue(lastseenDesc.contains(E05_03_Account.comment));
        appOperation.click(driver, E05_03_Account.returnBack, 0);//左上角返回按钮
    }

    /**
     * 点击Account的privacy，修改lastseen的选项
     *
     * @param driver
     */
    public void privacyPagePersonal(AppiumDriver driver) {
        accountToPrivacy(driver);//到privacy页
        String lastseenBefore = appOperation.getElement(driver, E05_03_Account.row_lastseen_text2).getText();
        appOperation.click(driver, E05_03_Account.row_lastseen);//点击lastseen选项
        if (lastseenBefore.equals(E05_03_Account.everyone)) {
            appOperation.click(driver, E05_03_Account.everyone_id, 1);//mycontacts
        } else if (lastseenBefore.equals(E05_03_Account.mycontacts)) {
            appOperation.click(driver, E05_03_Account.everyone_id, 2);//Nobody
        } else {
            appOperation.click(driver, E05_03_Account.everyone_id, 0);//everyone
        }
        appOperation.sleep(10);
        String lastseenAfter = appOperation.getElement(driver, E05_03_Account.row_lastseen_text2).getText();
        System.out.println("lastseenBefore=" + lastseenBefore);
        System.out.println("lastseenAfter=" + lastseenAfter);
        Assert.assertNotEquals(lastseenBefore, lastseenAfter);
        appOperation.click(driver, E05_03_Account.returnBack, 0);//左上角返回按钮到Account
    }

    /**
     * 点击Account的privacy，校验privacy页面lastseen的文案内容
     *
     * @param driver
     */
    public void privacyMessagingDesc(AppiumDriver driver) {
        accountToPrivacy(driver);//到privacy页
        String messaging = appOperation.getElement(driver, E05_03_Account.row_blocked_contacts_label).getText();
        Assert.assertTrue(messaging.contains(E05_03_Account.messaging));
        String blockContacts = appOperation.getElement(driver, E05_03_Account.row_blocked_contacts_text1).getText();
        Assert.assertTrue(blockContacts.contains(E05_03_Account.Blocked));
        String messagingDesc = appOperation.getElement(driver, E05_03_Account.row_blocked_contacts_comment).getText();
        Assert.assertTrue(messagingDesc.contains(E05_03_Account.blocked_contacts_comment));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回Account页面
    }

    /**
     * 点击Account的privacy，校验privacy页面addBlockedContacts的操作
     *
     * @param driver
     */
    public void addBlockContacts(AppiumDriver driver) {
        accountToPrivacy(driver);//到privacy页
        String beforeBlock = appOperation.getElement(driver, E05_03_Account.row_blocked_contacts_text1).getText();
        System.out.println("beforeBlock=" + beforeBlock);
        appOperation.click(driver, E05_03_Account.row_blocked_contacts);//跳转到block contacts页面
        addBlockedContact(driver);//右上角+人按钮添加联系人
        appOperation.sleep(100);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回Privacy页面
        String afterBlock = appOperation.getElement(driver, E05_03_Account.row_blocked_contacts_text1).getText();
        System.out.println("afterBlock="+afterBlock);
        Assert.assertNotEquals(beforeBlock, afterBlock);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回Account页面
        appOperation.sleep(1000);
    }

    /**
     * 点击Account的privacy，校验privacy页面removeBlockedContacts的操作
     *
     * @param driver
     */
    public void removeBlockedContacts(AppiumDriver driver) {
        accountToPrivacy(driver);//到privacy页
        String beforeBlock = appOperation.getElement(driver, E05_03_Account.row_blocked_contacts_text1).getText();
        appOperation.click(driver, E05_03_Account.row_blocked_contacts);//跳转到block contacts页面
        removeBlockedContact(driver);
        appOperation.sleep(100);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回Privacy页面
        String afterBlock = appOperation.getElement(driver, E05_03_Account.row_blocked_contacts_text1).getText();
        Assert.assertNotEquals(beforeBlock, afterBlock);
        System.out.println("afterBlock=" + afterBlock);
        System.out.println("beforeBlock=" + beforeBlock);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到Account页面
        appOperation.sleep(1000);
    }


    /**
     * 点击Account的privacy，校验privacy页面Read Status
     *
     * @param driver
     */
    public void readStatusDesc(AppiumDriver driver) {
        accountToPrivacy(driver);//到privacy页
        appOperation.swipeToUp(driver,500);
        String readStatusTitle = appOperation.getElement(driver, E05_03_Account.row_readstatus_label).getText();
        Assert.assertTrue(readStatusTitle.contains(E05_03_Account.read_status));
        String readStatus = appOperation.getElement(driver, E05_03_Account.row_readstatus_text1).getText();
        Assert.assertTrue(readStatus.contains(E05_03_Account.read_status));
        String readStatusDesc = appOperation.getElement(driver, E05_03_Account.row_readstatus_comment).getText();
        Assert.assertTrue(readStatusDesc.contains(E05_03_Account.row_readstatus_info));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回Account页面
    }

    /**
     * 点击Account的privacy，校验privacy页面Read Status可修改
     *
     * @param driver
     */
    public void readStatus(AppiumDriver driver) {
        accountToPrivacy(driver);//到privacy页
        Boolean before = appOperation.getElement(driver, E05_03_Account.row_readstatus_switch).isDisplayed();
        appOperation.click(driver, E05_03_Account.row_readstatus);
        appOperation.sleep(10);
        Boolean after = appOperation.getElement(driver, E05_03_Account.row_readstatus_switch).isSelected();
        Assert.assertNotEquals(before, after);
        appOperation.click(driver, E05_03_Account.returnBack, 0);//左上角返回按钮，返回Account页面
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//
    }


    /**
     * 点击Account的privacy到privacy页面，公共方法
     */
    public void accountToPrivacy(AppiumDriver driver) {
        Boolean floatcover = appOperation.waitForEle_Bool(driver, E05_03_Account.alertTitle);
        do {
            appOperation.click(driver, E05_03_Account.row_privacy);
        } while (floatcover = false);
    }

    /**
     * Account->Privacy->Blocked contact,添加联系人，自动返回Blocked Contacts页
     */
    public void addBlockedContact(AppiumDriver driver) {
        appOperation.click(driver, E05_03_Account.avatar_icon);//右上角+到Select Contact页面
        appOperation.click(driver, E05_03_Account.contact_layout);//点击联系人后自动返回Blocked Contacts页
        appOperation.sleep(10);
    }

    /**
     * Account->Privacy->Blocked contact,移除联系人
     */
    public void removeBlockedContact(AppiumDriver driver) {
        appOperation.click(driver, E05_03_Account.contact_layout);//点击联系人弹出浮层
        appOperation.click(driver, E05_03_Account.Cancel_id);//Cancel
        appOperation.click(driver, E05_03_Account.contact_layout);
        appOperation.click(driver, E05_03_Account.Confirm_id);//Confirm
    }


    //以下三个为原来的保存的方法，属于删除账号部分，不做任何修改
    public void AccountDelete(AppiumDriver driver, String Phonenumber) {
        //Account page
        appOperation.click(driver, E05_03_Account.row_deleteaccount);
        //Account Delete Page
        appOperation.sendkey(driver, E05_03_03_DeleteAccount.edittext_phone, Phonenumber);
        appOperation.click(driver, E05_03_03_DeleteAccount.delete_account_button);
        appOperation.click(driver, E05_03_03_DeleteAccount.Delete);
        Reporter.log("AccountDelete 执行完成", 1, true);//如果true，并且日志级别1，那么显示日志信息
    }

    public void AccountEntrance(AppiumDriver driver) {
        appOperation.click(driver, E00_Main.Settings);//Main page
        appOperation.click(driver, E05_Setting.Account);
//        appOperation.SearchParentElementByChildTextIDsParentClass(driver, E05_Setting.AccountItemName, E05_Setting.Item, E05_Setting.ItemParentClass).click();
    }

    public void AccountUpdate(AppiumDriver driver, AccountCase accoutObj, String Phonenumber) {
        AccountEntrance(driver);
        switch (accoutObj) {
            case MyNumber:
                break;
            case Privacy:
                break;
            case AccountDelete:
                AccountDelete(driver, Phonenumber);
                break;
            default:
                break;
        }
    }


}                                                                                        