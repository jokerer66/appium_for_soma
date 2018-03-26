package com.instanza.soma.Service.Setting;

import com.instanza.soma.resources.*;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

/**
 * Created by catty on 2017/7/7.
 * For Setting page Operation
 */
public class SettingsPage {

    private static SettingsPage settingsPage;
    public AppOperation appOperation;

    public SettingsPage() {
        appOperation = AppOperationImp.getInstance();
    }

    public static SettingsPage getInstance() {
        if (settingsPage == null) {
            synchronized (ProfilePage.class) {
                if (settingsPage == null) {
                    settingsPage = new SettingsPage();
                }
            }
        }
        return settingsPage;
    }

    /**
     * openSettingPage打开settings页面
     * 点击左上角的三个横图标打开settings页面
     *
     * @param driver
     */
    public void openSettingPage(AppiumDriver driver) {
//        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_Setting.Item);
        appOperation.click(driver, E00_Main.AddButton, 1);
        appOperation.sleep(5);
    }

    /**
     * Settings页面打开后--needDo--未实现
     * 跳转Profile页方法1：点击Settings页面的头像直接跳转到Profile页面
     *
     * @param driver
     */
    public void avatarToProfile(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.ItemParentClass, 1);
    }

    /**
     * Settings页面打开后
     * 跳转Profile页方法2：点击Settings页面的profile前面的黑色小人图标直接跳转到Profile页面
     *
     * @param driver
     */
    public void avatarIconToProfile(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.avatar, 0);
        Boolean eleExist = appOperation.waitForEle_Bool(driver, E05_01_Profile.editprofile_avatar);
        Assert.assertTrue(eleExist);
    }

    /**
     * Settings页面打开后
     * 跳转Profile页方法3：点击Settings页面的profile直接跳转到Profile页面
     *
     * @param driver
     */
    public void profileToProfile(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.Profile);
        Boolean eleExist = appOperation.waitForEle_Bool(driver, E05_01_Profile.editprofile_avatar);
        Assert.assertTrue(eleExist);
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的My Moments直接跳转到My Moments页面
     *
     * @param driver
     */
    public void settingsToMoments(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.MyMoments);//settings展开页点击My moments
        appOperation.sleep(10);
        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_02_MyMoments.camera);//相机按钮
        Assert.assertTrue(isExist);
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的My Coins直接跳转到My Coins页面
     *
     * @param driver
     */
    public void settingsToCoins(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.MyCoins);//settings展开页点击My Coins到mycoins页面
        appOperation.sleep(1000);
        Boolean records = appOperation.waitForEle_Bool(driver, E05_09_MyCoins.records);
        Assert.assertTrue(records);//校验Records
        Boolean myCoins = appOperation.waitForEle_Bool(driver, E05_09_MyCoins.myCoins);
        Assert.assertTrue(myCoins);//校验My Coins
        Boolean accountBalance = appOperation.waitForEle_Bool(driver, E05_09_MyCoins.accountBalance);
        Assert.assertTrue(accountBalance);//校验accountBalance
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的My Coins直接跳转到Account页面
     *
     * @param driver
     */
    public void settingsToAccount(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.Account);//settings展开页点击Account
        appOperation.sleep(10);
        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_03_Account.row_MyNumber);//相机按钮
        Assert.assertTrue(isExist);
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的My Coins直接跳转到Chats页面
     *
     * @param driver
     */
    public void settingsToChats(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.Chats);//settings展开页点击Chats
        appOperation.sleep(10);
        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_04_Chats.row_chat_background);//相机按钮
        Assert.assertTrue(isExist);
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的Notifications直接跳转到Notifications页面
     *
     * @param driver
     */
    public void settingsToNotifications(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.Notifications);//settings展开页点Notification
        appOperation.sleep(10);
        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_05_Notifications.Alert_Button);//相机按钮
        Assert.assertTrue(isExist);
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的Storage直接跳转到Storage页面
     *
     * @param driver
     */
    public void settingsToStorage(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.Storage);//settings展开页点击Usage
        appOperation.sleep(10);
        Boolean usage = appOperation.waitForEle_Bool(driver, E05_06_Storage.tv_usage);//Storage页usage项
        Assert.assertTrue(usage);
        Boolean clearCache = appOperation.waitForEle_Bool(driver, E05_06_Storage.ll_clear_cache);//Storage页clear cache项
        Assert.assertTrue(clearCache);
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的My Coins直接跳转到About页面
     *
     * @param driver
     */
    public void settingsToAbout(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.About);//settings展开页点击About
        appOperation.sleep(10);
        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_07_About.contactus);//相机按钮
        Assert.assertTrue(isExist);
    }

    /**
     * Settings页面打开后
     * 跳转My moments页方法：点击Settings页面的Share直接跳转到Share页面
     *
     * @param driver
     */
    public void settingsToShare(AppiumDriver driver) {

        appOperation.click(driver, E05_Setting.Share);//settings展开页点击Share
        appOperation.sleep(10);
        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_08_Share.alertTitle);
        Assert.assertTrue(isExist);
    }


}