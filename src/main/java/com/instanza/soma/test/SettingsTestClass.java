package com.instanza.soma.test;

import com.instanza.soma.Service.Setting.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.TestCase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by catty on 2017/7/7.
 */
@Listeners({ScreenShotListener.class})
public class SettingsTestClass extends TestCase {
    public int driverNumber = 0;
    public AppiumDriver driver;

    public SettingsTestClass(String name) {
        super(name);
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
    }

    /**
     * 以下为profile部分,更换头像(拍照，相册)，修改status
     */
    @Test(priority = 1)
    //点击settings展开后点击profile前的小图标，到profile页面
    public void avatarToProfileTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().avatarIconToProfile(driver);
    }

    @Test(priority = 2)
    //点击settings展开后点击profile，到profile页面,替换头像--Gallery方式
    public void editProfilePhotoGalleryTest() {
        ProfilePage.getInstance().editProfilePhotoGallery(driver);
    }

    @Test(priority = 3)
    //点击settings展开后点击profile，到profile页面,替换头像--Camera方式
    public void changeProfilePhotoByCamera() {
        ProfilePage.getInstance().editProfilePhotoCamera(driver);
    }

    @Test(priority = 4)
    //点击settings展开后点击profile，到profile页面,编辑名称
    public void editProfileNameTest() {
        ProfilePage.getInstance().editProfileName(driver);
    }

    @Test(priority = 5)//need to do ==eating
    //点击settings展开后点击status，手动编辑status
    public void editStautsByAddTest() {
        ProfilePage.getInstance().editStautsByAdd(driver);
    }

    @Test(priority = 6)//need to do ==eating
    //点击settings展开后点击status，选择第一屏的一个状态语
    public void editStautsBySelectTest() {
        ProfilePage.getInstance().editStautsBySelect(driver);
    }

    @Test(priority = 7)//need to do ==eating
    //点击settings展开后点击status，上滑屏幕到底部，选择状态语，后返回main页面
    public void editStautsBySelectUpTest() {
        ProfilePage.getInstance().editStautsBySelectUp(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * 以下为My Moments部分，moments部分覆盖，此处不再复测
     */
    @Test(priority = 8)
    //点击settings展开后点击My Moments
    public void settingsToMomentsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToMoments(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * 以下为My Coins部分
     */
    @Test(priority = 9)
    //点击settings展开后点击My Coins
    public void settingsToCoinsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToCoins(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * 以下为Account部分，删除账号在注册登录部分测试，此处不再复测
     */
    @Test(priority = 15)
    //点击settings展开后点击Account
    public void settingsToAccountTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 16)
    //点击settings展开后点击Account,Account页面的文案校验
    public void accountContentTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().accountContent(driver);
    }

    @Test(priority = 17)
    //点击Account的privacy，校验privacy-lastseen的说明内容是否正确
    public void privacyLastseenDescTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().privacyLastseenDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 18)
    //点击Account的privacy，修改lastseen的值
    public void privacyPagePersonalTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().privacyPagePersonal(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 19)
    //点击Account的privacy，校验privacy-messaging的说明内容是否正确
    public void privacyMessagingDescTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().privacyMessagingDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 20)
    //点击Account的privacy，校验privacy-block contacts新增联系人
    public void addBlockContactsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().addBlockContacts(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 21)
    //点击Account的privacy，校验privacy-block contacts移除联系人
    public void removeBlockedContactsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().removeBlockedContacts(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 22)
    //点击Account的privacy，校验privacy-readStatus的说明内容是否正确
    public void readStatusDescTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().readStatusDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 23)
    //点击Account的privacy，校验privacy-readStatus的修改校验
    public void readStatusTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().readStatus(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * 以下为Chats部分
     */
    @Test(priority = 24)
    //点击settings展开后点击Chats
    public void settingsToChatsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 25)
    //点击settings展开后点击Chats到Chats页面,Chats页面文案部分校验
    public void chatsPageDescTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().chatsPageDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 26)
    //点击settings展开后点击Chats到Chats页面,Chats页面auto-save勾选框
    public void autoSaveCheckBoxTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().autoSaveCheckBox(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 27)
    //点击settings展开后点击Chats--背景这里有坑 啊
    public void chooseBackgroundTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().chooseBackground(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 28)
    //点击settings展开后点击Chats--背景这里需要完善
    public void chooseBackground1Test() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 29)
    //点击settings展开后点击Chats--背景这里需要完善
    public void chooseBackground2Test() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 30)
    //Chats页面点击auto-download，修改Photos的下载方式
    public void downloadPhotosTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadPhotos(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 31)
    //Chats页面点击auto-download，修改FullImage的下载方式
    public void downloadFullImageTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadFullImage(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 32)
    //Chats页面点击auto-download，修改GIF的下载方式
    public void downloadGifTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadGif(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 33)
    //Chats页面点击auto-download，修改Videos的下载方式
    public void downloadVideosTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadVideos(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 34)
    //Chats页面点击auto-download，重置下载方式成为默认方式
    public void downloadResetTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadReset(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }


    /**
     * 以下为Notifications部分
     */
    @Test(priority = 35)
    //点击settings展开后点击Notifications
    public void settingsToNotificationsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToNotifications(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 36)
    //点击settings展开后到Notifications，点击Alert单选框
    public void clickAlertTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().clickAlert(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 37)
    //点击settings展开后到Notifications，点击In-App Vibrate单选框
    public void clickInAppVibrateTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().clickInAppVibrate(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 38)
    //点击settings展开后到Notifications，修改铃声
    public void soundChangeTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().soundChange(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 39)
    //点击settings展开后到Notifications，点击Preview单选框
    public void clickPreviewTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().clickPreview(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 40)
    //点击settings展开后到Notifications，校验Preview的文字说明是否存在
    public void previewDescTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().previewDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }



}
