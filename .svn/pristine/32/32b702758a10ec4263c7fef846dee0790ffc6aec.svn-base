package com.instanza.soma.test;

import com.instanza.soma.Business.ContactBusiness;
import com.instanza.soma.Business.LoginBusiness;
import com.instanza.soma.resources.PrepareData;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by sam on 2017/3/16.
 */
@Listeners({ScreenShotListener.class})
public class BeginTestClass extends TestCase {
    public static String[] receiverPhoneNumber = new String[]{"19034620252","18319752253"};
    public int driverNumber = 0;
    public AppiumDriver driver;
    public BeginTestClass(String name) {
        super(name);
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
    }

    //Begin priority from 0 to 99
    @Test(priority = 1)

    //登录
    public void OldUserLogin() {
        Assert.assertTrue(false,"OldUserLogin false");
//        LoginBusiness.getInstance().Login(driver, "", PrepareData.LoginPhoneNumber[driverNumber], PrepareData.LoginCountry[driverNumber], PrepareData.LoginUsername[driverNumber],false);
    }

    @Test(priority = 99)
    //登录
    public void AddFriend() {
        Assert.assertTrue(false,"AddFriend false");
//        ContactBusiness.getInstance().addContactService(driver,receiverPhoneNumber[driverNumber]);//发消息前先搜索一把对方是否已是好友，如果不是要加好友

    }
}
