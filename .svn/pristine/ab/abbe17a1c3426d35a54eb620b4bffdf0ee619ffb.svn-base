package com.instanza.soma.Service.Contacts;

import com.instanza.soma.resources.*;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 2017/4/27.
 */
public class ContactsService {
    private AppOperation appOperation;

    private static ContactsService contactsService;
    public static ContactsService getInstance(){
        if(contactsService == null){
            synchronized (ContactsService.class){
                if(contactsService == null){
                    contactsService = new ContactsService();
                }
            }
        }
        return contactsService;
    }

    public ContactsService() {
        appOperation = AppOperationImp.getInstance();
    }

    /**
     *通过add按钮new contact 添加好友
     * @param driver
     * @param contactname
     * @param phoneNumber
     */
    public void addContactsFromAddIcon(AppiumDriver driver,String contactname,String phoneNumber){
        appOperation.sleep(1500);
        appOperation.click(driver, E07_Add.ImageButton);
        appOperation.click(driver, E07_Add.NewContact);
        appOperation.sendkey(driver,E07_Add.EDIT_TEXT,contactname,0);
        appOperation.sendkey(driver,E07_Add.EDIT_TEXT,phoneNumber,2);
        appOperation.sleep(2000);
        appOperation.click(driver,E07_Add.saveInSystemContact);
        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
        appOperation.sleep(8000);
        appOperation.click(driver,E00_Main.chats_ll);
        String str = appOperation.getElement(driver, E02_ChatsSessions.firstChatsessionText).getText();
        assertTrue(str.contains("joined SOMA"));
        Reporter.log("添加好友成功,通过add按钮new contact");
        System.out.println("添加好友成功,通过add按钮new contact");

    }

    public void findJoinSOMAMsg(){}


    /**
     * 从通讯录中删除联系人
     * @param driver
     * @param phoneNumber 要删除的phonenumber 用户名亦可
     */
    public void deleteContact(AppiumDriver driver,String phoneNumber){
        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
        appOperation.click(driver, E00_00_DeviceHomePage.Contacts);
        appOperation.sendkey(driver,E00_00_DeviceHomePage.SystemContactSearch,phoneNumber);
        if(appOperation.getElementCount(driver,E00_00_DeviceHomePage.SystemContactSearchResultList)>1){
            Reporter.log("系统通讯录存在搜索的指定手机号码");
            System.out.println("系统通讯录存在搜索的指定手机号码");
            appOperation.longpress(driver,E00_00_DeviceHomePage.SystemContactSearchResult,3000);
            appOperation.click(driver,E00_00_DeviceHomePage.SystemContactDeleteButton);
            appOperation.click(driver,E00_00_DeviceHomePage.SystemContactDeleteText);
        }else{
            Reporter.log("系统通讯录未搜索到指定的手机号码");
            System.out.println("系统通讯录未搜索到指定的手机号码");
        }

        driver.launchApp();
    }

    /**
     * 从chats页面删除相应的session
     * @param driver
     * @param contactname
     */
    public void deleteContactSession(AppiumDriver driver,String contactname){
        Boolean hasDeleteFlag = false,DeleteSuccessFlag = true;
        appOperation.click(driver,E00_Main.chats_ll);
        for(WebElement webElement:appOperation.getElements(driver,E05_04_Chats.usernameTextView)){
            if(webElement.getText().equals(contactname)){
                appOperation.longpress(driver,webElement,3000);
                appOperation.click(driver,E05_04_Chats.DeleteChat);
                appOperation.click(driver,E05_04_Chats.Delete);
                hasDeleteFlag = true;
                break;
            }
        }
        appOperation.sleep(1000);
        if(hasDeleteFlag == true){
            for(WebElement webElement:appOperation.getElements(driver,E05_04_Chats.usernameTextView)) {
                if (webElement.getText().equals(contactname)) {
                    DeleteSuccessFlag = false;
                    break;
                }
            }
            if(DeleteSuccessFlag == true){
                Reporter.log("chats页面删除session成功");
            }else{
                Reporter.log("chats页面删除失败");
            }
        }else{
            Reporter.log("chats页面不存在指定要删除的session");
        }
    }

}
