package com.instanza.soma.debug;

import com.instanza.soma.Service.ChattingPageService;
import com.instanza.soma.resources.E04_02_SystemContact;
import com.instanza.soma.resources.E04_03_SingChattingPage;
import help.AppOperation;
import help.AppOperationImp;
import utils.MyData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.MyData;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by apple on 2017/3/7.
 */
public class twodevice {
    private AppiumDriver<AndroidElement> driver, driver2;
    private IOSDriver iosDriver;
    public AppOperation appOperation;
    private Object syncObj = new Object();
    final Timer timer = new Timer();
    final Timer timer2 = new Timer();

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "SM-N9200");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("app", "/Users/apple/Desktop/soma.apk");
        capabilities.setCapability("appPackage", "com.instanza.baba");
        capabilities.setCapability("appActivity", ".activity.CocoVoice");
        capabilities.setCapability("noReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//        DesiredCapabilities capabilities2 = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "X2P0215714003528");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", "/Users/apple/Desktop/soma.apk");
        capabilities.setCapability("appPackage", "com.instanza.baba");
        capabilities.setCapability("appActivity", ".activity.CocoVoice");
        capabilities.setCapability("noReset", true);

        driver2 = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);

//        DesiredCapabilities capabilities2 = new DesiredCapabilities();
//        capabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        capabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
//        capabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        capabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
//        capabilities2.setCapability(MobileCapabilityType.UDID, "8dbf13a9fd894edfcc537cfc89399b8f03754182");
//        capabilities2.setCapability("bundleid", "com.instanza.BaBa");//run on real device
//        capabilities2.setCapability(MobileCapabilityType.APP, "/Users/apple/Desktop/soma.ipa");
//        capabilities2.setCapability("noReset", true);
//        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities2);


        appOperation = AppOperationImp.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        driver2.quit();
    }

    @Test
    public void testtemp() {
        driver.findElementById("contacts_ll").click();
        appOperation.sleep(500);
//        appOperation.swipeUntilFind(driver,"4438666fff",0);
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("text(\"4438666fff\")").click();
        appOperation.sleep(500);
        appOperation.sendkey(driver, "com.instanza.baba:id/textMsgEditText", "8888888888");
        driver.findElementById("com.instanza.baba:id/sendTextBtn").click();
        appOperation.sleep(5000);
        iosDriver.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[3]")
                .click();
        appOperation.sleep(1000);
        iosDriver.findElementByName("3959").click();
        appOperation.sleep(5000);
//        iosDriver.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextView[1]")
//                .sendKeys("test back for sendmsg");
//        .click();
        iosDriver.findElementByClassName("TextView").sendKeys("test");
        appOperation.sleep(2000);
//        iosDriver.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
//                .click();
        iosDriver.findElementByName("Send").click();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }

    @Test
    public void test_backmsg() {


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-------do run timer:backSameMsg--------");
                receiveAndSendMsg(driver, MyData.backSameMsg);

            }
        }, 1000 * 3, 1000 * 10);
        appOperation.click(driver2, "com.instanza.baba:id/chats_ll");
        appOperation.click(driver2, "text/text(\"3959\")");
//        ChattingPageService.getInstance().SentMessageTextEmoj(driver2, "test msg");
//        if(((AndroidDriver)driver2).isKeyboardShown()){
//            driver2.hideKeyboard();
//        }
        ChattingPageService.getInstance().SentMessageVoice(driver2);
        ((AndroidDriver) driver2).pressKeyCode(AndroidKeyCode.BACK);
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-------do run timer:backNewMsg--------");
                receiveAndSendMsg(driver2, MyData.backNewMsg);

            }
        }, 1000 * 3, 1000 * 10);


//        ChattingPageService.getInstance().SentMessageVoice(driver2);appOperation.sleep(40000);
//        ChattingPageService.getInstance().SentMessagePhoto(driver2,1);appOperation.sleep(40000);
//        ChattingPageService.getInstance().SentMessageVideo(driver2);appOperation.sleep(40000);
////        ChattingPageService.getInstance().SentMessageNameCard(driver2);appOperation.sleep(10000);
//        appOperation.click(driver2, E04_03_SingChattingPage.chat_camera_btn);
//        appOperation.click(driver2, E04_03_SingChattingPage.Contact);
//        appOperation.sendkey(driver2, E04_02_SystemContact.search_src_text, "4429");
//        appOperation.click(driver2, "xpath///android.widget.TextView[contains(@text,'+8615967164429')]");
//        appOperation.click(driver2, E04_03_SingChattingPage.contactcard_send);


//        appOperation.sleep(10000);
//        synchronized (syncObj) {
//            syncObj.notifyAll();
////            timer.cancel();
//        }

//        iosDriver.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[3]")
//                .click();appOperation.sleep(1000);
//        iosDriver.findElementByName("3959").click();
//        appOperation.sleep(5000);
//        iosDriver.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextView[1]")
//                .sendKeys("test msg1");
////        iosDriver.findElementByClassName("TextView").sendKeys("test");
//        appOperation.sleep(2000);
////        iosDriver.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
////                .click();
//        iosDriver.findElementByName("Send").click();
//
//


        try {
            synchronized (syncObj) {
                syncObj.wait(1000 * 60 * 1);
            }

            System.out.println("-------package failed--------");
            timer.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到最后一条收到的聊天类型
     *
     * @param driver
     * @return
     */
    public String getLastMsgType(AppiumDriver driver) {
        String lastmsgtype = "error";
        appOperation.sleep(1000);
        if (appOperation.getElementCount(driver, "xpath///android.widget.ListView[contains(@resource-id , 'com.instanza.baba:id/msgListView')]/android.widget.LinearLayout[last()-1]/android.widget.LinearLayout")
                > 0) {
            if (appOperation.getElementCount(driver, "xpath///android.widget.ListView[contains(@resource-id , 'com.instanza.baba:id/msgListView')]/android.widget.LinearLayout[last()-1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout")
                    > 0) {
                //text,voice
                if (appOperation.getElementCount(driver, "xpath///android.widget.ListView[contains(@resource-id , 'com.instanza.baba:id/msgListView')]/android.widget.LinearLayout[last()-1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/*")
                        > 1) {
                    lastmsgtype = MyData.msgtype_voice;
                } else {
                    lastmsgtype = MyData.msgtype_text;
                }
            } else {
                //picture,video,location
                switch (appOperation.getElementCount(driver, "xpath///android.widget.ListView[contains(@resource-id , 'com.instanza.baba:id/msgListView')]/android.widget.LinearLayout[last()-1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/*")) {
                    case 2:
                        lastmsgtype = MyData.msgtype_location;
                        break;
                    case 3:
                        lastmsgtype = MyData.msgtype_picture;
                        break;
//                    case 4:
//                        lastmsgtype = "video";
//                        break;
                    default:
                        lastmsgtype = MyData.msgtype_video;
                        break;
                }
            }
        } else {
            lastmsgtype = "contact";
        }
        return lastmsgtype;
    }

    public void receiveAndSendMsg(AppiumDriver driver, String backtype) {

        int count = appOperation.getElementCount(driver, "xpath///android.widget.ListView[contains(@resource-id , 'com.instanza.baba:id/scroll_listview')]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/*");
        System.out.println(backtype + " count  = " + count);
        //第一个session存在展示未读数的控件
        if (count > 1) {
            String text = appOperation.getElement(driver, "xpath///android.widget.ListView[contains(@resource-id , 'com.instanza.baba:id/scroll_listview')]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
                    .getText();
            System.out.println(backtype + " text = " + text);
            //chats页面的未读数
            int unread_number = Integer.valueOf(text);
            if (unread_number > 0) {
                //第一个session
                appOperation.click(driver, "xpath///android.widget.ListView[contains(@resource-id , 'com.instanza.baba:id/scroll_listview')]/android.widget.RelativeLayout[2]");

//                WebElement msgListView = appOperation.getElement(driver,"com.instanza.baba:id/msgListView");
//                int listsize = appOperation.getElementCount(driver,"com.instanza.baba:id/list_item_container")-1;
                System.out.println(backtype + " last msg type = " + getLastMsgType(driver));
                switch (getLastMsgType(driver)) {
                    case MyData.msgtype_text:
                        if (backtype.equals(MyData.backNewMsg)) {
                            ChattingPageService.getInstance().SentMessageVoice(driver);
                        } else if (backtype.equals(MyData.backSameMsg)) {
                            ChattingPageService.getInstance().SentMessageTextEmoj(driver, "test msg");
                        }
                        break;
                    case MyData.msgtype_picture:
                        if (backtype.equals(MyData.backNewMsg)) {
                            ChattingPageService.getInstance().SentMessageVideo(driver);
                        } else if (backtype.equals(MyData.backSameMsg)) {
//                            ChattingPageService.getInstance().SentMessagePhoto(driver,1);
                        }
                        break;
                    case MyData.msgtype_video:
                        if (backtype.equals(MyData.backNewMsg)) {
//                            appOperation.click(driver2, E04_03_SingChattingPage.);
                            appOperation.click(driver2, E04_03_SingChattingPage.Contact);
                            appOperation.sendkey(driver2, E04_02_SystemContact.search_src_text, "4429");
                            appOperation.click(driver2, "xpath///android.widget.TextView[contains(@text,'+8615967164429')]");
                            appOperation.click(driver2, E04_03_SingChattingPage.contactcard_send);
                        } else if (backtype.equals(MyData.backSameMsg)) {
                            ChattingPageService.getInstance().SentMessageVideo(driver);
                        }
                        break;

                    case MyData.msgtype_contact:
                        if (backtype.equals(MyData.backNewMsg)) {
                            synchronized (syncObj) {
                                syncObj.notifyAll();
                            }
                            timer.cancel();
                            timer2.cancel();
                            driver.closeApp();
                        } else if (backtype.equals(MyData.backSameMsg)) {
//                            ChattingPageService.getInstance().SentMessageNameCard(driver);
                        }
                        break;
                    case MyData.msgtype_voice:
                        if (backtype.equals(MyData.backNewMsg)) {
//                            ChattingPageService.getInstance().SentMessagePhoto(driver,1);
                            System.out.println("got voice");
                            synchronized (syncObj) {
                                syncObj.notifyAll();
                            }
                            timer.cancel();
                            timer2.cancel();
                            driver.closeApp();
                        } else if (backtype.equals(MyData.backSameMsg)) {
                            ChattingPageService.getInstance().SentMessageVoice(driver);
                        }
                        break;
                    case MyData.msgtype_location:
                        if (backtype.equals(MyData.backNewMsg)) {

                        } else if (backtype.equals(MyData.backSameMsg)) {

                        }
                        break;
                    default:
                        break;
                }
                if (((AndroidDriver) driver).isKeyboardShown()) {
                    driver.hideKeyboard();
                }
                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
//                appOperation.sendkey(driver,"com.instanza.baba:id/textMsgEditText","receive a msg with type :"+getLastMsgType(driver));
//                appOperation.click(driver,"com.instanza.baba:id/sendTextBtn");
//
//                        appOperation.sleep(5000);
//                        synchronized (syncObj) {
//                            syncObj.notify();
//                            timer.cancel();
//                        }

            }
        }
    }
}