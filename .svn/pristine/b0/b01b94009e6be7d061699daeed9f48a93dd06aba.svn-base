package com.instanza.soma.test;

import com.instanza.soma.Business.LoginBusiness;
import com.instanza.soma.resources.PrepareData;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by apple on 2017/4/21.
 */
@Listeners({ScreenShotListener.class})
public class ContactsTestClass {
    public static String[] receiverPhoneNumber = new String[]{"19034620252","18319752253"};
    public int driverNumber = 0;
    public AppiumDriver driver;
    private String tempPhoneNumber;
    Boolean ishuawei = false;
    public ContactsTestClass(String name) {
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
        ishuawei = appiumServer.getAppuimDeviceList().get(driverNumber).getIshuawei();
    }

    //Begin priority from 0 to 99
    @Test
    //老账号更换设备需要验证码注册,通过数据准备事先在另外的机器上登陆
    public void test1_oldUserLogin() {
        LoginBusiness.getInstance().Login(driver, "", PrepareData.LoginPhoneNumber[driverNumber], PrepareData.LoginCountry[driverNumber], PrepareData.LoginUsername[driverNumber],ishuawei);
        LoginBusiness.getInstance().DeleteAccount(driver,"");
    }

}
