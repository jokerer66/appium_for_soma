package com.instanza.soma.Service;

import com.instanza.soma.Business.SentMessage;
import com.instanza.soma.resources.*;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;
import java.util.Random;

/**
 * Created by sam on 2017/3/5.
 */
public class AddPageService {
    public AppOperation appOperation;

    private static AddPageService AddObj;
    public static AddPageService getInstance() {
        if (AddObj == null) {
            synchronized (AddPageService.class) {
                if (AddObj == null) {
                    AddObj = new AddPageService();
                }
            }
        }
        return AddObj;
    }
    public AddPageService(){
        appOperation = AppOperationImp.getInstance();
    }

    public void ScanByAddButton(AppiumDriver driver) {
        //Main Page 点击Add button
        appOperation.click(driver,E00_Main.AddButton,0);
        //Add button 点击后的弹框
        appOperation.click(driver,E07_Add.SCAN_QR_CODE);//点击SCAN QR CODE
        appOperation.sleep(2000);
        ((AndroidDriver)driver).pressKeyCode(4);
        //NeedToDo, 扫描二维码如何自动化测试
        //NeedToDo
//        driver.pressKeyCode(4);//退出聊天页面返回上一级页面
    }
    public void AddContactByAddButton(AppiumDriver driver, String PhoneNumber) {
        //Main Page 点击Add button
        appOperation.click(driver,E00_Main.AddButton,0);
        //Add button 点击后的弹框
        appOperation.click(driver, E07_Add.NEWCONTACT);
        //System Contact Add Contact Page
//        appOperation.click(driver, E04_02_SystemContact.Name);
//        appOperation.sendkey(driver, E04_02_SystemContact.Name,String.valueOf(new Random().nextInt(10000)));
        appOperation.sendkey(driver, E04_02_SystemContact.Name,PhoneNumber);
//        appOperation.click(driver, E04_02_SystemContact.Phonenumber);
        PhoneNumber="+"+PhoneNumber;
        appOperation.sendkey(driver, E04_02_SystemContact.Phonenumber,PhoneNumber);
//        appOperation.click(driver, E04_02_SystemContact.SaveContactButton);
        ((AndroidDriver)driver).findElementByAndroidUIAutomator("text(\"Save\")").click();
        //NeedToDo
        appOperation.sleep(1000);
        ((AndroidDriver)driver).pressKeyCode(4);//退出系统Contact显示页面返回上一级页面
    }

    //为什么单聊建立完成后进Chatting，群聊建立后进Session, 产品设计的有问题
    public void EnterGroupChattingByAddButton(AppiumDriver driver, String Member1, String Member2) {
        //Main Page 点击Add button
        appOperation.click(driver,E00_Main.AddButton,0);
        //Add button 点击后的弹框
        appOperation.click(driver, E07_Add.NEWGROUPCHAT);
        //Select Contact Page
        appOperation.sendkey(driver, E04_01_SelectContact.search_box,Member1);
        appOperation.click(driver,E04_01_SelectContact.contact_name);
        appOperation.sendkey(driver,E04_01_SelectContact.search_box,Member2);
        appOperation.click(driver,E04_01_SelectContact.contact_name);
        appOperation.click(driver, E04_01_SelectContact.SelectContact_right_button);//点击完成按钮

        ChatsPageService.getInstance().LastSessionClick(driver);//点击最近的一个Session从Chats进入Chatting
        ((AndroidDriver)driver).pressKeyCode(4);
    }
    //Create SingleTalk session, and stay in chatting page
    public void EnterSingleChattingByAddButton(AppiumDriver driver, String receiverPhoneNumber) {
        //Main Page 点击Add button
        appOperation.click(driver,E00_Main.AddButton,0);
        //Add button 点击后的弹框
        appOperation.click(driver,E07_Add.NEWMESSAGE);
        //Select Contact Page
        appOperation.sendkey(driver,E04_01_SelectContact.search_box,receiverPhoneNumber);
        appOperation.click(driver,E04_01_SelectContact.contact_name);


    }


}
