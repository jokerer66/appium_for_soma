package com.instanza.soma.test;

import com.instanza.soma.Business.ContactBusiness;
import com.instanza.soma.Business.LoginBusiness;
import com.instanza.soma.resources.PrepareData;
import help.AppOperation;
import help.AppOperationImp;
import help.controller.StartTestMIssionController;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;

import java.util.ArrayList;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by sam on 2017/3/16.
 */

@Listeners({ScreenShotListener.class})
public class LoginTestClass {
    public static String[] receiverPhoneNumber = new String[]{"19034620252","18319752253"};
    public int driverNumber = 0;
    public AppiumDriver driver;
    private String tempPhoneNumber;
    private AppOperation appOperation;
    Boolean ishuawei = false;
    @BeforeClass
    public void getDriver() {
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
        ishuawei = appiumServer.getAppuimDeviceList().get(driverNumber).getIshuawei();
        appOperation = AppOperationImp.getInstance();
    }

//    Begin priority from 0 to 99
    @Test
    //老账号更换设备需要验证码注册,通过数据准备事先在另外的机器上登陆
    public void test1_oldUserLogin() {
        LoginBusiness.getInstance().Login(driver, "firsttime", PrepareData.LoginPhoneNumber[driverNumber], PrepareData.LoginCountry[driverNumber], PrepareData.LoginUsername[driverNumber],ishuawei);
        LoginBusiness.getInstance().DeleteAccount(driver,"firsttime");
    }

    //删除账号,后重新登陆美国账号以及
    //之前注册过，不删除账号：卸载重装,老账号不需要验证码注册
    @Test
    public void test2_DeleteAndReLogin_US() {
        LoginBusiness.getInstance().Login(driver, "", PrepareData.LoginPhoneNumber[driverNumber], PrepareData.LoginCountry[driverNumber], PrepareData.LoginUsername[driverNumber],ishuawei);
        resetapp(driver);
        Reporter.log("卸载重装app");
        LoginBusiness.getInstance().Login(driver, "", PrepareData.LoginPhoneNumber[driverNumber], PrepareData.LoginCountry[driverNumber], PrepareData.LoginUsername[driverNumber],ishuawei);
        LoginBusiness.getInstance().DeleteAccount(driver,"");
    }

    //新账号不需要验证码注册,删除账号,登陆随机生成的中国号码
    @Test
    public void test3_newUserLogin() {
        tempPhoneNumber = PrepareData.getTel();
        LoginBusiness.getInstance().Login(driver, "",tempPhoneNumber , "China", tempPhoneNumber,ishuawei);
        LoginBusiness.getInstance().DeleteAccount(driver,"");
    }

    //删除账号,后重新登陆中国账号以及
    //之前注册过，不删除账号：卸载重装,老账号不需要验证码注册
    @Test
    public void test4_DeleteAndReLogin_Chinese() {
        LoginBusiness.getInstance().Login(driver, "", tempPhoneNumber, "China", tempPhoneNumber,ishuawei);
        resetapp(driver);
        Reporter.log("卸载重装app");
        LoginBusiness.getInstance().Login(driver, "", tempPhoneNumber, "China", tempPhoneNumber,ishuawei);
        LoginBusiness.getInstance().DeleteAccount(driver,"");
    }


    public void resetapp(AppiumDriver driver){
        if(driver.getPlatformName().toLowerCase().equals("android")){
            appOperation.resetapp(driver,"com.instanza.baba");
        }else if(driver.getPlatformName().toLowerCase().equals("ios")){
            appOperation.resetapp(driver,"com.instanza.BaBa");
        }
    }
}
