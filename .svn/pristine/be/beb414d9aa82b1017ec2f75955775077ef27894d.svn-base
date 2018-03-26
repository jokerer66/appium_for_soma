package com.instanza.soma.test;

import com.instanza.soma.Business.DeleteAccount;
import com.instanza.soma.Business.LoginBusiness;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.testlisten.ScreenShotListener;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by sam on 2017/3/15.
 */
@Listeners({ScreenShotListener.class})
public class CleanTestClass extends TestCase {
    public static String[] PhoneNumber = new String[]{"8319752253","9034620252"};
//    public static String[] logonPhoneNumber = new String[]{"3094120964","8564320100"};
    public int driverNumber = 0;
    public AppiumDriver driver;
    public CleanTestClass(String name) {
        super(name);
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
//        driver = DriverInit.driverlist_All.get(driverNumber);
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
    }
    //CleanTest
//    priority from 10000 to 10099
    @Test (priority = 10000)
    //删账号
    public void DeleteAccount() {
        DeleteAccount.getInstance().DeleteAccount(driver, PhoneNumber[driverNumber]);//删除账号
    }

    @Test(priority = 10099)
    //删账号
    public void ActiveUer() {
        LoginBusiness.getInstance().Login(driver, "New", PhoneNumber[driverNumber], "united states", "Name",false);
    }
    //NeedToDo 对方已经deleteaccount了，自己还想发消息给对方
    //NeedToDo 中间一旦失败后，需要Login再delete account，不能自动恢复为delete account状态
    //NeedToDo TestCase执行的顺序是随机的，test02和test17的顺序经常互换
    //Add buttong中点击4个action时经常卡住不动
    //注册
//    public void test17_NewUserActivate() {
////        List<String> stringList = new ArrayList<String>();
////        stringList.add("8319752253");
////        stringList.add("9034620252");
//        LoginBusiness.getInstance().Login(driver, "New", activatePhoneNumber[driverNumber], "united states", "Name");
//    }
}
