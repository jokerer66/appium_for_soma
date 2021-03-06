package com.instanza.soma.test;

import com.instanza.soma.Business.Moments;
import com.instanza.soma.Business.SentMessage;
import com.instanza.soma.Service.Setting.StoragePage;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;

import static help.startup.SuiteTestThread.appiumServer;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileCapabilityType;
//import junit.framework.TestSuite;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.openqa.selenium.remote.CapabilityType;
//import java.io.InputStreamReader;
//import java.io.LineNumberReader;
@Listeners({ScreenShotListener.class})
public class MainTestClass extends TestCase {
    //    List<AppiumDriver> driverList = new ArrayList<AppiumDriver>();
    //    public static int[]  index = new int[500];
//    public static List<String> phoneNumber;
//    public static List<String> receiverPhoneNumber;
//    String[] str = new String[]{"","","","",""};
    public static String[] activatePhoneNumber = new String[]{"8319752253","9034620252"};
    public static String[] receiverPhoneNumber = new String[]{"13094120964","18564320100"};
    public static String[] logonPhoneNumber = new String[]{"3094120964","8564320100"};
    public int driverNumber = 0;
    public AppiumDriver driver;

    public MainTestClass(String name) {
        super(name);
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
//        driver = DriverInit.driverlist_All.get(driverNumber);
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
//        driver.findElementsById("com.instanza.baba:id/login_welcome");//验证driver是否可用
//        phoneNumber = new ArrayList<String>();
//        phoneNumber.add("8319752253");
//        phoneNumber.add("9034620252");
//        receiverPhoneNumber = new ArrayList<String>();
//        receiverPhoneNumber.add("9034620252");
//        receiverPhoneNumber.add("8319752253");
    }

    //    public void setUp() throws Exception {
//    会在每个test的函数开始之前执行1次
//        System.out.println("setUp");
//    }
//    public  void tearDown() throws Exception {
//    会在每个test的函数结束之后执行1次
//        System.out.println("tearDown");
//    }

    //NeedToDo杀进程重启如何实现
    //MainTest priority from 100 to 9999
    @Test
    //升级
    public void est04_Upgrade() {
        //NeedToDo
    }

//    @Test
//    //加好友
//    public void est05_AddFriends() {
//        //NeedToDo
//        ContactBusiness.getInstance().addContactService(driver,receiverPhoneNumber[driverNumber]);
//    }

//    public void est06_TellFriends() {
////        T01_01_Login.getInstance().Login(driver, "Old", "6267681852", "united states", "Name");//老用户登录
//    }

    @Test
    //发消息
    public void testSentMessages() {
        //所有的发消息入口都发送一遍消息
        SentMessage.getInstance().SentMessageFromAllEntrance(driver,receiverPhoneNumber[driverNumber]);
        //发一条消息，退出到主页面，再继续发消息，直到各种类型的消息都发送一遍
        SentMessage.getInstance().SentAllKindsMessageEnterAndBack(driver,receiverPhoneNumber[driverNumber]);
        //对一个人发各种消息，发完后再退到主界面
        SentMessage.getInstance().SentMessage(driver,2,receiverPhoneNumber[driverNumber]);
    }

    @Test
    //收消息
    public void est08_ReceiveMessage() {
        //NeedToDo
    }

    @Test
    //打电话
    public void est09_Call() {
        //NeedToDo
    }

    @Test
    //接电话
    public void est09_AcceptCall() {
        //NeedToDo
    }

    @Test
    //朋友圈
    public void testMomentsTestList() {
        Moments.getInstance().SentMomentFromAllEntry(driver);
        Moments.getInstance().SentMomentAllKindOfPhotoNumber(driver);
        Moments.getInstance().SentMomentAttachAll(driver);

        //LoginBusiness.getInstance().Login(driver, "Old", "xxxx", "united states", "Name");//老用户登录
        //MomentsPage.getInstance().SentMoment(driver);
        //MomentsPage.getInstance().SentMomentbyMyMoments(driver);
//        MomentsPage.getInstance().Momentcover(driver);
        //MomentsPage.getInstance(). Momentcomments(driver);
        //MomentsPage.getInstance().SentMoment9(driver, 10);
        //MomentsPage.getInstance().SentMoment9(driver, 9);
        //MomentsPage.getInstance(). SentMoment4(driver);
        //MomentsPage.getInstance(). MyMomentComments(driver);
    }


//    @Test
//    //profile 头像、姓名、status设置
//    public void testProfileTestList() {
//        ProfilePage.getInstance().ProfileUpdate(driver, ProfilePage.ProfileCase.ProfilePhoto);
//        ProfilePage.getInstance().ProfileUpdate(driver, ProfilePage.ProfileCase.ProfileName);
//        ProfilePage.getInstance().ProfileUpdate(driver, ProfilePage.ProfileCase.Stauts);
//    }
//
//    @Test
//    //ChatsSettings设置
//    public void testChatsSettingList() {
//        ChatsSetting.getInstance().ChatsettingUpdate(driver, ChatsSetting.ChatSettingCase.changebackground);
//        ChatsSetting.getInstance().ChatsettingUpdate(driver, ChatsSetting.ChatSettingCase.AutoDownloadmode);
//        ChatsSetting.getInstance().ChatsettingUpdate(driver, ChatsSetting.ChatSettingCase.save);
//    }

    @Test
    //usage设置
    public void testUsageSettingList() {
        StoragePage.getInstance().setUsageBack(driver);
    }

    @Test
    //发送地图
    public void est15_SendLocationMessage() {
//NeedtoDo
//        SentMessage.getInstance().SentMessage(driver, SentMessage.Entrance.Search, SentMessage.Type.Location,"sdfsafd", SentMessage.BackType.Element);
        //SentMessage.getInstance().SentMessage(driver, SentMessage.Entrance.Search, SentMessage.Type.Photo,"sdfaskjdf", SentMessage.BackType.Element);
    }

}