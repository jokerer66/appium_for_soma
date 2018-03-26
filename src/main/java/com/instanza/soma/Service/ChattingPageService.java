package com.instanza.soma.Service;

import com.instanza.soma.Service.Tools.GalleryPage;
import com.instanza.soma.resources.*;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by sam on 2017/3/5.
 */
public class ChattingPageService {
    public AppOperation appOperation;

    public enum LocationType {DefaultSend, SelectSend, SearchSend;}
    public enum ImageType {Image, FullImage;}
    public enum NameCardType {Defualt, Empty;}

    private static ChattingPageService chattingService;
    public static ChattingPageService getInstance() {
        if (chattingService == null) {
            synchronized (ChattingPageService.class) {
                if (chattingService == null) {
                    chattingService = new ChattingPageService();
                }
            }
        }
        return chattingService;
    }

    public ChattingPageService() {
        appOperation = AppOperationImp.getInstance();
    }

    public void SentMessageTextEmoj(AppiumDriver driver, String Message) {
        //Chatting Page
        //NeedToDo 太长需要点击两次发送如何实现
        appOperation.sendkey(driver, E04_03_SingChattingPage.textMsgEditText, Message);
        appOperation.click(driver, E04_03_SingChattingPage.showEmojiBtn);
        appOperation.click(driver, E04_03_SingChattingPage.emojicon_icon);
        appOperation.click(driver, E04_03_SingChattingPage.sendTextBtn);
    }

    public void SentMessageVoice(AppiumDriver driver) {
        TouchAction action = new TouchAction(driver);
        action.longPress(driver.findElementById(E04_03_SingChattingPage.chat_voice_btn), 10000).release().perform();
    }

    public void SentMessagePhoto(AppiumDriver driver, ImageType image_type,int sent_photo_amount) {
        //chatting page--by Frank
        //发送一张照片、9张照片、10张
        appOperation.click(driver, E04_03_SingChattingPage.Attach);
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.Gallery, GalleryPage.PhotoAction.select,sent_photo_amount);
//        appOperation.click(driver, E04_03_SingChattingPage.Gallery);
//        GalleryPage.getInstance().SelectedPhoto(driver,sent_photo_amount);
//        VerifyCreateGroupChatSucceed(driver);
    }

    public void SentMessageVideo(AppiumDriver driver) {
        //Chatting page
        appOperation.click(driver, E04_03_SingChattingPage.Attach);

        appOperation.click(driver, E04_03_SingChattingPage.Gallery);
        //Gallery Page
        appOperation.click(driver, E06_01_Gallery.video);
        appOperation.click(driver, E06_01_Gallery.folderlist);
        appOperation.click(driver, E06_01_Gallery.grid_avatar);
        appOperation.click(driver, E06_01_Gallery.video_send);
    }

    public void SentMessageCameraPhoto(AppiumDriver driver) {
        //NeedToDo
        driver.findElementById(E04_03_SingChattingPage.Attach).click();
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.Camera, GalleryPage.PhotoAction.select,1);
        //((WebElement) driver.findElementsById("com.instanza.baba:id/title").get(4)).click();
//        appOperation.click(driver, E04_03_SingChattingPage.Camera);
    }

    public void SentMessageCameraVideo(AppiumDriver driver) {
        //NeedToDo
//        driver.findElementById(E04_03_SingChattingPage.Attach).click();
        //((WebElement) driver.findElementsById("com.instanza.baba:id/title").get(4)).click();
//        appOperation.click(driver, E04_03_SingChattingPage.Location);
    }
    //NeedToDo，有的手机不支持Location, 有的手机支持Loaction，自动化的策略是什么？
    public void SentMessageLocation(AppiumDriver driver, LocationType myLocationType) {
        //NeedToDo，特定具备的手机才能实现---Create by Frank 
        switch (myLocationType) {
            case DefaultSend:
                driver.findElementById(E04_03_SingChattingPage.Attach).click();
                //((WebElement) driver.findElementsById("com.instanza.baba:id/title").get(4)).click();
                appOperation.click(driver, E04_03_SingChattingPage.Location);
                driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
                driver.findElementByAccessibilityId(E06_02_Location.send_location).click();
                break;
            case SelectSend:
                driver.findElementById(E04_03_SingChattingPage.Attach).click();
                //((WebElement) driver.findElementsById("com.instanza.baba:id/title").get(4)).click();
                appOperation.click(driver, E04_03_SingChattingPage.Location);
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
                ((WebElement) driver.findElementsById(E06_02_Location.location_list).get(1)).click();
                driver.findElementByAccessibilityId(E06_02_Location.send_location).click();
                System.out.println("test Creat group chat succed");
                break;
            case SearchSend:

                driver.findElementById(E04_03_SingChattingPage.Attach).click();
                //((WebElement) driver.findElementsById("com.instanza.baba:id/title").get(4)).click();
                appOperation.click(driver, E04_03_SingChattingPage.Location);
                driver.findElementById(E06_02_Location.search).click();
                driver.findElementById(E06_02_Location.Search_edit).sendKeys("tong");
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

                ((WebElement) driver.findElementsById(E06_02_Location.search_location_list).get(0)).click();
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
                driver.findElementByAccessibilityId(E06_02_Location.send_location).click();
                break;
            default:
                break;
        }
    }


    public void SentMessageNameCard(AppiumDriver driver,String PhoneNumber,NameCardType name_card_type) {
        switch (name_card_type) {
            case Defualt:
                appOperation.click(driver, E04_03_SingChattingPage.Attach);
                appOperation.click(driver, E04_03_SingChattingPage.Contact);
                appOperation.sendkey(driver, E04_02_SystemContact.search_src_text, "4429");
                appOperation.click(driver, E04_02_SystemContact.cliv_name_textview);
                appOperation.click(driver, E04_03_SingChattingPage.contactcard_send);
            case Empty:
                appOperation.click(driver, E04_03_SingChattingPage.Attach);
                appOperation.click(driver, E04_03_SingChattingPage.Contact);
                appOperation.sendkey(driver, E04_02_SystemContact.search_src_text, "4429");
                appOperation.click(driver, E04_02_SystemContact.cliv_name_textview);
                appOperation.click(driver, E04_02_SystemContact.select_namecard);
                appOperation.click(driver, E04_03_SingChattingPage.contactcard_send);

                break;
            default:
                break;

        }
    }

    public void VerifyCreateGroupChatSucceed(AppiumDriver driver) {
        //--by Frank

        WebElement we = (WebElement) driver.findElementsById("com.instanza.baba:id/max_toast");
        boolean flag = we.getText().contains("Maximum 9 photos please!") ? true : false;
        if (flag = true) {
            System.out.println("Maximum 9 photos please! " + flag);

        }else{
                System.out.println("Failed ");
            }

    }

    public void hasPhoneNumber(AppiumDriver driver,String phone_number) {
        //--判断手机中有没有存要操作的手机号码，如果已经存了，不处理；如果没有存，则将要操作的手机号存在系统通讯录中by Frank

        driver.findElementByAccessibilityId("Search").click();//点击搜索按钮
        driver.findElementById(E00_Main01_Search.search_src_text).sendKeys(phone_number);//输入phone_number

            WebElement we = (WebElement) driver.findElementsById("com.instanza.baba:id/listview_with_index_item_alpha").get(0);
            boolean flag = we.getText().contains("Contacts") ? true : false;
            if (flag==true){

                return;
            }else{
                WebElement a=(WebElement)driver.findElementsByClassName("android.widget.ImageButton").get(0);
                a.click();//点击返回键返回主页面
                AddPageService.getInstance().AddContactByAddButton(driver,phone_number);//添加手机号码
                return;
            }





    }

}