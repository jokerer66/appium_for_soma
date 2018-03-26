package com.instanza.soma.debug;


import com.instanza.soma.resources.E00_01_AgreeAndActivate;
import com.instanza.soma.resources.E00_02_ActivatePhoneVerification;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Please read about Page Object design pattern here:
 * https://code.google.com/p/selenium/wiki/PageObjects
 */
public class iOSDemoTest {

//    private IOSDriver iosDriver;
    private RemoteWebDriver driver;


    @Before
    public void setUp() throws Exception {
//        File appDir = new File("/Users/catty/Downloads/sample-code-master/sample-code/apps/TestApp/build/release-iphonesimulator");
//        File app = new File(appDir, "TestApp.app");
        File app = new File("/Users/catty/Documents/dev/IdeaWorkspace/TestJar", "SOMA.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("autolaunch", false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 plus");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
//        capabilities.setCapability("bundleId", "io.cattywei.TestApp");
        capabilities.setCapability("bundleid", "com.instanza.BaBa");
        capabilities.setCapability(MobileCapabilityType.UDID, "b8048dbe4cb9a1af3ffc898eb8f1e8ba829277d9");//run on real device
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        capabilities.setCapability(MobileCapabilityType.APP, this.getClass().getResource("/BaBa.ipa").getPath());
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        System.out.println("App launched");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * Test login
     */
    @Test
    public void login() {
        driver.findElementById(E00_01_AgreeAndActivate.AgreeAndActivate).click();
        driver.findElementById(E00_02_ActivatePhoneVerification.edittext_phone).sendKeys("13712345678");
        driver.findElementById(E00_02_ActivatePhoneVerification.NextButton);

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("test");
    }

}
