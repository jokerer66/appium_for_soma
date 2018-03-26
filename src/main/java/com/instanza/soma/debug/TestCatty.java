package com.instanza.soma.debug;

import com.instanza.soma.Service.Setting.*;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestSuite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;

import java.net.URL;

@Listeners({ScreenShotListener.class})
public class TestCatty extends TestSuite {

    public AppOperation appOperation;
    private AppiumDriver<WebElement> driver, driver2;
    private AndroidDriver<AndroidElement> driverAnd;
    private AppiumDriver<MobileElement> iosDriver2;
//    appOperation = AppOperationImp.getInstance();

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        File app = new File("/Users/catty/Desktop", "soma.apk");
//        capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("app", this.getClass().getResource("/soma.apk").getPath());
        capabilities.setCapability("app", "/Users/catty/Desktop/soma.apk");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "X2P0215714003528");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.1");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4d00b01b33583065");
        capabilities.setCapability("noReset", true);//为true不需要重新安装
        capabilities.setCapability("autolaunch", false);
        capabilities.setCapability("appPackage", "com.instanza.baba");
        capabilities.setCapability("appActivity", ".activity.CocoVoice");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//        capabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        capabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
//        capabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        capabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
//        capabilities2.setCapability(MobileCapabilityType.UDID, "8dbf13a9fd894edfcc537cfc89399b8f03754182");
//        capabilities2.setCapability("bundleid", "com.instanza.BaBa");//run on real device
//        capabilities2.setCapability(MobileCapabilityType.APP, "/Users/apple/Desktop/soma.ipa");
//        capabilities2.setCapability("noReset", true);
//        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities2);
        appOperation = AppOperationImp.getInstance();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * 以下为profile部分,更换头像(拍照，相册)，修改status
     */
    @Test(priority = 1)
    //点击settings展开后点击profile前的小图标，到profile页面
    public void avatarToProfileTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().avatarIconToProfile(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 2)
    //点击settings展开后点击profile，到profile页面,替换头像--Gallery方式
    public void editProfilePhotoGalleryTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().profileToProfile(driver);
        ProfilePage.getInstance().editProfilePhotoGallery(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 3)
    //点击settings展开后点击profile，到profile页面,替换头像--Camera方式
    public void changeProfilePhotoByCamera() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().profileToProfile(driver);
        ProfilePage.getInstance().editProfilePhotoCamera(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 4)
    //点击settings展开后点击profile，到profile页面,编辑名称
    public void editProfileNameTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().profileToProfile(driver);
        ProfilePage.getInstance().editProfileName(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 5)//need to do ==eating
    //点击settings展开后点击status，手动编辑status
    public void editStautsByAddTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().profileToProfile(driver);
        ProfilePage.getInstance().editStautsByAdd(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 6)//need to do ==eating
    //点击settings展开后点击status，选择第一屏的一个状态语
    public void editStautsBySelectTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().profileToProfile(driver);
        ProfilePage.getInstance().editStautsBySelect(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 7)//need to do ==eating
    //点击settings展开后点击status，上滑屏幕到底部，选择状态语，后返回main页面
    public void editStautsBySelectUpTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().profileToProfile(driver);
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
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 10)
    //校验My Coins页的标题的文案以及获取coins数量
    public void myCoinsTitleDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToCoins(driver);
        MyCoinsPage.getInstance().myCoinsTitleDesc(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 11)
    //校验My Coins页的items定价
    public void myCoinsDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToCoins(driver);
        MyCoinsPage.getInstance().myCoinsDesc(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 12)
    //点击my coin页的records到该页面后返回
    public void myCoinsRecordsTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToCoins(driver);
        MyCoinsPage.getInstance().myCoinsRecords(driver);
    }

    @Test(priority = 13)//??????返回少一个
    //点击my coin页的payment problem到该页面后填写一些信息，未发送，返回到mycoins，再返回到main页面
    public void payProblemsTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToCoins(driver);
        MyCoinsPage.getInstance().payProblems(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回main页面
    }

    /**
     * 以下为Account部分，删除账号在注册登录部分测试，此处不再复测
     */
    @Test(priority = 15)
    //点击settings展开后点击Account
    public void settingsToAccountTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAccount(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 16)
    //点击settings展开后点击Account,Account页面的文案校验
    public void accountContentTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().accountContent(driver);
    }

    @Test(priority = 17)
    //点击Account的privacy，校验privacy-lastseen的说明内容是否正确
    public void privacyLastseenDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().privacyLastseenDesc(driver);

    }

    @Test(priority = 18)
    //点击Account的privacy，修改lastseen的值
    public void privacyPagePersonalTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().privacyPagePersonal(driver);

    }

    @Test(priority = 19)
    //点击Account的privacy，校验privacy-messaging的说明内容是否正确
    public void privacyMessagingDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().privacyMessagingDesc(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 20)//返回到account页面
    //点击Account的privacy，校验privacy-block contacts新增联系人
    public void addBlockContactsTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().addBlockContacts(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 21)//返回到account页面
    //点击Account的privacy，校验privacy-block contacts移除联系人
    public void removeBlockedContactsTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().removeBlockedContacts(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 22)
    //点击Account的privacy，校验privacy-readStatus的说明内容是否正确
    public void readStatusDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().readStatusDesc(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 23)//??????没正常返回
    //点击Account的privacy，校验privacy-readStatus的修改校验
    public void readStatusTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAccount(driver);
        AccountPage.getInstance().readStatus(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到Main页面
    }

    /**
     * 以下为Chats部分
     */
    @Test(priority = 24)
    //点击settings展开后点击Chats
    public void settingsToChatsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToChats(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 25)
    //点击settings展开后点击Chats到Chats页面,Chats页面文案部分校验
    public void chatsPageDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().chatsPageDesc(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 26)
    //点击settings展开后点击Chats到Chats页面,Chats页面auto-save勾选框
    public void autoSaveCheckBoxTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().autoSaveCheckBox(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 27)
    //点击settings展开后点击Chats--背景这里有坑 啊
    public void chooseBackgroundTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().chooseBackground(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

//    @Test(priority = 28)
//    //点击settings展开后点击Chats--背景这里需要完善
//    public void chooseBackground1Test() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
//    }

//    @Test(priority = 29)
//    //点击settings展开后点击Chats--背景这里需要完善
//    public void chooseBackground2Test() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
//    }

    @Test(priority = 30)
    //Chats页面点击auto-download，修改Photos的下载方式
    public void downloadPhotosTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadPhotos(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 31)
    //Chats页面点击auto-download，修改FullImage的下载方式
    public void downloadFullImageTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadFullImage(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 32)
    //Chats页面点击auto-download，修改GIF的下载方式
    public void downloadGifTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadGif(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 33)
    //Chats页面点击auto-download，修改Videos的下载方式
    public void downloadVideosTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadVideos(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 34)//??????未返回
    //Chats页面点击auto-download，重置下载方式成为默认方式
    public void downloadResetTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToChats(driver);
        ChatsSetting.getInstance().downloadReset(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到main页面
    }


    /**
     * 以下为Notifications部分
     */
    @Test(priority = 35)
    //点击settings展开后点击Notifications,校验是否成功进入Notifications页面
    public void settingsToNotificationsTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToNotifications(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 36)
    //点击settings展开后到Notifications，点击Alert单选框
    public void clickAlertTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().clickAlert(driver);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 37)
    //点击settings展开后到Notifications，点击In-App Vibrate单选框
    public void clickInAppVibrateTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().clickInAppVibrate(driver);
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 38)
    //点击settings展开后到Notifications，修改铃声
    public void soundChangeTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().soundChange(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 39)
    //点击settings展开后到Notifications，点击Preview单选框
    public void clickPreviewTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().clickPreview(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 40)
    //点击settings展开后到Notifications，校验Preview的文字说明是否存在
    public void previewDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToNotifications(driver);
        NotificationsPage.getInstance().previewDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }


    /**
     * 以下为Storage-->Usage部分
     */
    @Test(priority = 41)
    //点击settings展开后点击Storage到storage页面，校验该页是否含有Usage和Clear Cache项
    public void settingsToUsageTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToStorage(driver);
    }

    @Test(priority = 42)
    //点击Storage->Usage到usage页，点击左上角返回按钮返回storage页
    public void setUsageBackTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().setUsageBack(driver);
    }

    @Test(priority = 43)
    //点击Storage->Usage到该页面后，页面第一屏文案校验
    public void setUsageDesc1Test() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().setUsageDesc1(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 44)
    //点击Storage->Usage到该页面后，页面第二屏文案校验，返回到storage页
    public void setUsageDesc2Test() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().setUsageDesc2(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 45)
    //点击Storage->Usage到该页面后，页面第三屏文案校验，返回到storage页
    public void setUsageDesc3Test() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().setUsageDesc3(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 46)
    //点击Storage->Usage到该页面后，点击Reset按钮，校验浮层内容，返回到storage页
    public void resetUsageCoverDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().resetUsageCoverDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 47)
    //点击Storage->Usage到该页面后，点击Reset按钮，点击浮层Cancel按钮，返回到storage页
    public void resetUsageCoverCancelTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().resetUsageCoverCancel(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 48)
    //点击Storage->Usage到该页面后，点击Reset按钮，点击浮层Reset按钮，返回到storage页
    public void resetUsageCoverResetTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().resetUsageCoverReset(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * 以下为Storage-->Clear Cache部分,清除全部缓存
     */
    @Test(priority = 49)
    //点击Storage页的clear cache按钮，非empty则清除，否则不操作，返回到main页面
    public void clearCacheStorageTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().clearCacheStorage(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * 以下为Storage-->Clear Cache部分,清除全部缓存
     */
    @Test(priority = 50)
    //点击Storage页的clear cache文案说明内容的校验
    public void clearCacheDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToStorage(driver);
        StoragePage.getInstance().clearCacheDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }


    /**
     * 以下为About部分
     */
    @Test(priority = 51)
    //点击settings展开后点击About，检验是否成功进入about页面
    public void settingsToAboutTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        SettingsPage.getInstance().settingsToAbout(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 52)
    //About页面校验是否含有Version和SOMA Messenger
    public void somaVersionTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAbout(driver);
        AboutPage.getInstance().somaVersion(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 53)
    //About页面校验是否含有FAQ和Contact Us
    public void faqAndContactTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAbout(driver);
        AboutPage.getInstance().faqAndContact(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 54)
    //About页面点击Contact Us到Contact Us页面校验内容，返回到about页面
    public void clickContactUsTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAbout(driver);
        AboutPage.getInstance().clickContactUs(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 55)
    //About页面点击Contact Us到Contact Us页面校验内容
    public void clickFAQTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        SettingsPage.getInstance().settingsToAbout(driver);
        AboutPage.getInstance().clickFAQ(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回main页面
    }


    /**
     * 以下为Share部分
     */
    @Test(priority = 56)
    //点击settings展开后点击Share，校验浮层已经弹出，不关闭该浮层
    public void settingsToShareTest() {
        SettingsPage.getInstance().openSettingPage(driver);
        appOperation.swipeToUp(driver, 1000);//上滑
        SettingsPage.getInstance().settingsToShare(driver);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(priority = 57)
    //点击settings展开后点击Share,校验浮层内容
    public void shareCoverDescTest() {
//        SettingsPage.getInstance().openSettingPage(driver);
//        appOperation.swipeToUp(driver, 1000);//上滑
        SharePage.getInstance().shareCoverDesc(driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }



//    @Test
//    public void takeSnapShotTest() {
//        Boolean isExist = appOperation.waitForEle_Bool(driver, E05_Setting.Item);
//
//        List<WebElement> FieldsList = driver.findElementsByClassName(E05_Setting.ItemParentClass);
//        for (int i = 0; i < FieldsList.size(); i++) {
//            do {//先执行再判断
//                appOperation.click(driver, E00_Main.AddButton, 1);
//                appOperation.sleep(1);
//            } while (isExist = false);
//            appOperation.sleep(2);
//            FieldsList.get(i).click();
//            String filename = "这是第" + i + "个图标";
//            appOperation.sleep(2);
//            AppOperationImp.getInstance().snapshot(driver);
//            driver.runAppInBackground(3);
//        }
////        FieldsList.get(5).click();//my moments，5，6
////        FieldsList.get(10).click();//Accounts8,9,10
////        FieldsList.get(15).click();//usage,14,15,16
////        FieldsList.get(0).click();//my coins，0，1，2，7，
////        FieldsList.get(3).click();//Profile栏,3,4,5,6
////        FieldsList.get(11).click();//Notifications,11,12,13
//        appOperation.sleep(500);
//    }


//    public static String[] receiverPhoneNumber = new String[]{"13012345555","13738140814"};
//    public int driverNumber = 0;
//    @Test
//    //发消息
//    public void testSentMessages() {
//        //所有的发消息入口都发送一遍消息
//        SentMessage.getInstance().SentMessageFromAllEntrance(driver,"13012345555");
//        //发一条消息，退出到主页面，再继续发消息，直到各种类型的消息都发送一遍
//        SentMessage.getInstance().SentAllKindsMessageEnterAndBack(driver,"13012345555");
//        //对一个人发各种消息，发完后再退到主界面
//        SentMessage.getInstance().SentMessage(driver,2,"13012345555");
//    }


//    @Test
//    public void test() {
//        for (int i = 1; i < 15; i++) {
////        driver.pressKeyCode(AndroidKeyCode.HOME);
//            driver.runAppInBackground(2);//把当前应用放到后台5s
//            System.out.println("这是第" + i + "次切换");
//        }
//    }



//    @DataProvider(name = "testData")
//    public Object[][] providerMethod() {
//        Object[][] result = null;
//        result = new Object[][]{new Object[]{3}};
//        return result;
//    }

}

