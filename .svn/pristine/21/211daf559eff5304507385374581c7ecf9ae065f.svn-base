package com.instanza.soma.Business;

import com.instanza.soma.Service.AddPageService;
import com.instanza.soma.Service.SearchPageService;
import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E04_Contacts;
import com.instanza.soma.resources.E07_Add;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by catty on 2017/3/8.
 */
public class ContactBusiness {
    public AppOperation appOperation;

    private static ContactBusiness contactBussinessObj;

    public static ContactBusiness getInstance() {
        if (contactBussinessObj == null) {
            synchronized (ContactBusiness.class) {
                if (contactBussinessObj == null) {
                    contactBussinessObj = new ContactBusiness();
                }
            }
        }
        return contactBussinessObj;
    }
    public ContactBusiness() {
        appOperation = AppOperationImp.getInstance();
    }




//    AppOperationImp api = new AppOperationImp();

    //Need baba_1.6.6ForAutomation version to test
    public void addContactsService(AndroidDriver driver, String PhoneNumber) {


    }
    public void addContactService(AppiumDriver driver, String contactName){
        driver.findElementByAccessibilityId("Search").click();//点击搜索按钮
        Boolean isExist=SearchPageService.getInstance().IsContactExist(driver,contactName);
//        (WebElement) ((AppiumDriver) driver).findElementsByClassName("android.widget.ImageButton").get(0);
//            WebElement backE=(driver.findElementsByClassName("android.widget.ImageButton")).get(0);
        appOperation.click(driver,"classname/android.widget.ImageButton",0);
        //NeedToDo，对方未激活，没有chats，但是系统通讯录中已存在
        if(!isExist)
            AddPageService.getInstance().AddContactByAddButton(driver,contactName);
        Reporter.log("addContactService 执行完成",1,true);//如果true，并且日志级别1，那么显示日志信息
    }
}
