package com.instanza.soma.debug;

import com.instanza.soma.Business.LoginBusiness;
import com.instanza.soma.Service.Contacts.ContactsService;
import com.instanza.soma.Service.Login.LoginService;
import com.instanza.soma.resources.E00_01_AgreeAndActivate;
import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.PrepareData;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.NoSuchContextException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestSuite;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

//import junit.sampling.*;
public class rugaltestsuite extends TestSuite{

    private AppiumDriver<WebElement> driver,driver2;
    public AppOperation appOperation;
    @BeforeClass
    public void setUp() throws Exception {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName","SM-N9200");
//        capabilities.setCapability("platformVersion", "7.0");
//        capabilities.setCapability("app", "/Users/apple/Desktop/soma.apk");
//        capabilities.setCapability("appPackage", "com.instanza.baba");
//        capabilities.setCapability("appActivity", ".activity.CocoVoice");
//
//        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
//
////        capabilities.setCapability("app", "/Users/apple/Desktop/bing.apk");
////        capabilities.setCapability("appPackage", "com.microsoft.bing");
////        capabilities.setCapability("appActivity", "com.microsoft.clients.bing.app.MainActivity");
//
//        capabilities.setCapability("noReset", true);
//
//        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        DesiredCapabilities capabilities2 = new DesiredCapabilities();
        capabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        capabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        capabilities2.setCapability(MobileCapabilityType.UDID, "8dbf13a9fd894edfcc537cfc89399b8f03754182");//5s
        capabilities2.setCapability("bundleid", "com.instanza.BaBa");//run on real device com.tencent.xin
//        capabilities2.setCapability("bundleid", "com.tencent.xin");//run on real device
        capabilities2.setCapability(MobileCapabilityType.APP, "/Users/apple/Desktop/soma.ipa");
//        capabilities2.setCapability(MobileCapabilityType.APP, "/Users/apple/Desktop/wechat6.5.5.ipa");
        capabilities2.setCapability("noReset", true);
        capabilities2.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities2);


        appOperation = AppOperationImp.getInstance();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
    String temp_phonenumber = "1317893";
    @Test
    public void test(){
        appOperation.click(driver,"name = 'Chats' and type = 'Button'");
        appOperation.click(driver,"name = '2959'");appOperation.sleep(500);
//        WebElement temp ;
        int x1,x2,x3,y1,y2,y3;
//        temp = appOperation.getElement(driver,"xpath///*[@name=\"SOMA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]");
//        temp.click();
//        x1 = temp.getLocation().getX();
//        y1 = temp.getLocation().getY();
//        appOperation.sleep(500);
//
//        temp = appOperation.getElement(driver,"xpath///*[@name=\"SOMA\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeButton[1]");
//        temp.click();
//        x2 = temp.getLocation().getX();
//        y2 = temp.getLocation().getY();
//        appOperation.sleep(500);
//
//        temp = appOperation.getElement(driver,"name like 'Send to Chat*'");
//        temp.click();
//        x3 = temp.getLocation().getX();
//        y3 = temp.getLocation().getY();
//        appOperation.sleep(500);


        x1 = 30;y1 = 540;
        x2 = 50;y2 = 130;
        x3 = 160;y3 = 290;
        System.out.println("x1 = "+x1+"\ny1 = "+y1+"\nx2 = "+x2+"\ny2 = "+y2+"\nx3 = "+x3+"\ny3 = "+y3);
        for(int i=0;i<1000;i++){
            System.out.println("i = "+i+"\n");
            driver.swipe(x1,y1,x1,y1,500);
            driver.swipe(x2,y2,x2,y2,500);
            driver.swipe(x3,y3,x3,y3,500);

        }


    }



    @Test(dataProvider="testData")
    public void testtet(int tempint) {
//        LoginBusiness.getInstance().DeleteAccount(driver,"firsttime");
//        ContactsService.getInstance().addContactsFromAddIcon(driver,"testnick2","+19013004438");
//        ContactsService.getInstance().deleteContact(driver,"44");
//        driver.scrollToExact();
//        ((AndroidDriver) driver).findElementByAndroidUIAutomator("textContains(\"Agree\")").click();
    }



    @DataProvider(name = "testData")
    public Object[][] providerMethod(){
        Object[][] result = null;

            result = new Object[][]{new Object[]{3}};
        return result;
    }

}
