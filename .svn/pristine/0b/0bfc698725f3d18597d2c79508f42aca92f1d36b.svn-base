package com.instanza.soma.debug;

import com.instanza.soma.resources.E00_01_AgreeAndActivate;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class AndroidDemoTest {
    private AndroidDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        File app = new File("/Users/catty/Documents/dev/IdeaWorkspace/TestJar", "SOMA.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "X2P0215714003528");
//        capabilities.setCapability("app", this.getClass().getResource("/soma.apk").getPath());
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autolaunch", false);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.instanza.baba");
        capabilities.setCapability("appActivity", ".activity.CocoVoice");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void login() {
        WebElement el = driver.findElement(By.id(E00_01_AgreeAndActivate.AgreeAndActivate));
        el.click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        driver.findElementById("com.instanza.baba:id/edittext_phone").clear();
        driver.findElementById("com.instanza.baba:id/select_country_text").click();
        driver.findElementById("com.instanza.baba:id/search_box").click();
        driver.findElementById("com.instanza.baba:id/search_box").sendKeys("canada");
        driver.findElementById("com.instanza.baba:id/listview_item_country_name_i18n").click();
        driver.findElementById("com.instanza.baba:id/edittext_phone").sendKeys("3134378912");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        driver.findElementById("com.instanza.baba:id/next").click();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        driver.findElementById("android:id/button1").click();
        //driver.findElementByName("Approve");
        driver.findElementById("com.instanza.baba:id/welcome_continue").click();
        driver.findElementById("android:id/button1").click();


    }

}