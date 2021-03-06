package com.instanza.soma.Service.Setting;

import com.instanza.soma.resources.E05_07_About;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.Assert;

/**
 * Created by catty on 2017/7/25.
 * For About Page Test
 */
public class AboutPage {
    private static AboutPage aboutPage;
    public AppOperation appOperation;

    public AboutPage() {
        appOperation = AppOperationImp.getInstance();
    }

    public static AboutPage getInstance() {
        if (aboutPage == null) {
            synchronized (ProfilePage.class) {
                if (aboutPage == null) {
                    aboutPage = new AboutPage();
                }
            }
        }
        return aboutPage;
    }

    /**
     * About页面版本文字--Vesion
     * About页面版本文字--SOMA Messenger
     *
     * @param driver
     */
    public void somaVersion(AppiumDriver driver) {
        String version = appOperation.getElement(driver, E05_07_About.version).getText();
        System.out.println("version=" + version);
        Assert.assertTrue(version.contains(E05_07_About.versions));//含有Version
        String somaMessenger = appOperation.getElement(driver, E05_07_About.soma_messenger_class, 1).getText();
        System.out.println("somaMessenger=" + somaMessenger);
        Assert.assertTrue(somaMessenger.contains(E05_07_About.soma_messenger));//含有SOMA Messenger
    }

    /**
     * About页面版本文字--Contact Us
     * About页面版本文字--FAQ
     *
     * @param driver
     */
    public void faqAndContact(AppiumDriver driver) {
        String contactus = appOperation.getElement(driver, E05_07_About.contactus).getText();
        Assert.assertTrue(contactus.contains(E05_07_About.contact_us));//含有Contact Us
        String faq = appOperation.getElement(driver, E05_07_About.faq).getText();
        Assert.assertTrue(faq.contains(E05_07_About.faq_faq));//含有FAQ
    }

    /**
     * 点击Contact Us到Contact页面
     *
     * @param driver
     */
    public void clickContactUs(AppiumDriver driver) {
        appOperation.click(driver, E05_07_About.contactus);
        appOperation.sendkey(driver, E05_07_About.problem_et, SettingsTools.getRandomString(10));//problem Input Page
        Assert.assertNotNull(E05_07_About.problem_et);
        appOperation.sleep(5);
        appOperation.click(driver, E05_07_About.returnBack, 0);//返回到about页面
    }

    /**
     * 点击FAQ到FAQ页面
     *
     * @param driver
     */
    public void clickFAQ(AppiumDriver driver) {
        appOperation.click(driver, E05_07_About.faq);
        appOperation.sleep(10);
        String link = appOperation.getElement(driver, E05_07_About.FAQ_URL).getText();
        System.out.println("link =" + link);
        Assert.assertTrue(link.contains(E05_07_About.url_link));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回About页面
        appOperation.sleep(5);
    }


}
