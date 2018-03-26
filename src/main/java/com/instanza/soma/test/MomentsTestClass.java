package com.instanza.soma.test;

import com.instanza.soma.Business.Moments;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;
//import org.junit.Test;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by trista on 2017/4/11.
 */
@Listeners({ScreenShotListener.class})
public class MomentsTestClass extends TestCase {
    public static String[] PhoneNumber = new String[]{"8319752253", "9034620252"};
    //    public static String[] logonPhoneNumber = new String[]{"3094120964","8564320100"};
    public int driverNumber = 0;
    public AppiumDriver driver;

    public MomentsTestClass(String name) {
        super(name);
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
//        driver = DriverInit.driverlist_All.get(driverNumber);
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
    }
    @Test
    public void test1_SentMomentFromAllEntry() {
        Moments.getInstance().SentMomentFromAllEntry(driver);
    }
    @Test
    public void test2_SentMomentAllKindOfPhotoNumber() {
        Moments.getInstance().SentMomentAllKindOfPhotoNumber(driver);
    }
    @Test
    public void test3_SentMomentAttachAll() {
        Moments.getInstance().SentMomentAttachAll(driver);}
    @Test
    public void test4_MyMomentComments() {
        Moments.getInstance().MyMomentComments(driver);
    }
    /*@Test
    public void test5_Momentcomments() {
        Moments.getInstance().Momentcomments(driver);
    }
    */
    @Test
    public void test6_MomentcoverUpdate() {
        Moments.getInstance().MomentcoverUpdateByselectPhoto(driver);
        Moments.getInstance().MomentcoverUpdateBytakePhoto(driver);
    }

}

