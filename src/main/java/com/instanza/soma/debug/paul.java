package com.instanza.soma.debug;


import com.instanza.soma.Business.Moments;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by trista on 2017/4/7.
 */
public class paul extends TestSuite {
    private AppiumDriver<AndroidElement> driver, driver2;
    private IOSDriver iosDriver, iosDriver2;
    public AppOperation appOperation;



    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy s6");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("app", "/Users/trista/Desktop/soma.apk");
        capabilities.setCapability("appPackage", "com.instanza.baba");
        capabilities.setCapability("appActivity", ".activity.CocoVoice");
        capabilities.setCapability("noReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        DesiredCapabilities capabilities2 = new DesiredCapabilities();
        appOperation = AppOperationImp.getInstance();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
//        driver2.quit();
    }
    @Test
    public void testtet() {
        //LoginBusiness.getInstance().Login(driver, "Old", "3134378912", "united states", "Name");
        //Moments.getInstance().SentMomentFromAllEntry(driver);
        //Moments.getInstance().SentMomentAllKindOfPhotoNumber(driver);
        //Moments.getInstance().SentMomentAttachAll(driver);
        Moments.getInstance().MyMomentComments(driver);
//        Moments.getInstance().Momentcomments(driver);

    }
}
