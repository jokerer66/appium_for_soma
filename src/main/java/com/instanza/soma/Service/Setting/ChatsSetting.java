package com.instanza.soma.Service.Setting;

import com.instanza.soma.Service.Tools.GalleryPage;
import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E05_04_Chats;
import com.instanza.soma.resources.E05_Setting;
import com.instanza.soma.resources.E08_ChatsSetting;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.Assert;

import java.util.List;

/**
 * Created by daisy on 17/3/7.
 */
public class ChatsSetting {
    public AppOperation appOperation;

    private static ChatsSetting chatsSetting;

    public static ChatsSetting getInstance() {
        if (chatsSetting == null) {
            synchronized (ProfilePage.class) {
                if (chatsSetting == null) {
                    chatsSetting = new ChatsSetting();
                }
            }
        }
        return chatsSetting;
    }

    public ChatsSetting(){
        appOperation = AppOperationImp.getInstance();
    }

    /**
     * settings->chats页面，校验chats页面的文案内容
     * cattyNeedUpdate有空了需要看下该页面的文案问题，目前其他文案获取的都不对
     **/
    public void chatsPageDesc(AppiumDriver driver) {
        String background = appOperation.getElement(driver, E05_04_Chats.row_chat_background_text1).getText();
        System.out.println("background = " + background);
        Assert.assertTrue(background.contains(E05_04_Chats.chat_background_desc));
        String autoDownloadTitle = appOperation.getElement(driver, E05_04_Chats.row_auto_download_text1).getText();
        System.out.println("autoDownloadTitle = " + autoDownloadTitle);// Auto-Download
        Assert.assertTrue(autoDownloadTitle.contains(E05_04_Chats.auto_download_desc));

        String autoDownloadDesc = appOperation.getElement(driver, E05_04_Chats.row_MyNumber_text2).getText();
        System.out.println("autoDownloadDesc = " + autoDownloadDesc);//autodownload的说明文案
        Assert.assertTrue(autoDownloadDesc.contains(E05_04_Chats.row_MyNumber_desc));

        String autoSave = appOperation.getElement(driver, E05_04_Chats.row_auto_save_text1).getText();
        System.out.println("autoSave = " + autoSave);//auto-save
        Assert.assertTrue(autoSave.contains(E05_04_Chats.auto_save_checkTitle));

        String autoSaveDesc = appOperation.getElement(driver, E05_04_Chats.row_auto_save_desc).getText();
        System.out.println("autoSaveDesc = " + autoSaveDesc);//auto-save说明，没有ID感觉意义不大
        Assert.assertTrue(autoSaveDesc.contains(E05_04_Chats.auto_save_desc));
    }

    /**
     * settings->chats页面，校验chats页面的文案内容
     * auto-save勾选框勾选校验
     **/
    public void autoSaveCheckBox(AppiumDriver driver) {
        Boolean before = appOperation.getElement(driver, E05_04_Chats.row_auto_save_switch).isSelected();
        appOperation.click(driver, E05_04_Chats.row_auto_save);
        appOperation.sleep(10);
        Boolean after = appOperation.getElement(driver, E05_04_Chats.row_auto_save_switch).isDisplayed();
        org.junit.Assert.assertNotEquals(before, after);
    }

    /**
     * settings->chats页面，校验chats页面的文案内容
     * Chat Background替换背景--从相册中选择背景
     **/
    public void chooseBackground(AppiumDriver driver) {
        appOperation.click(driver, E08_ChatsSetting.chatbackground);//图片选择页面
        appOperation.click(driver, E08_ChatsSetting.defaultpic);//
        appOperation.click(driver, E08_ChatsSetting.chatbackground);
        appOperation.click(driver, E08_ChatsSetting.photobtn);
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.ChoosePhoto, GalleryPage.PhotoAction.cut,1);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * settings->chats页面，点击Auto-Download后到该页面
     * 点击Photos，修改下载方式
     **/
    public void downloadPhotos(AppiumDriver driver) {
        appOperation.click(driver, E05_04_Chats.row_auto_download);//Chats页点击Auto-Download到该页
        String downloadType = appOperation.getElement(driver, E05_04_Chats.row_photos_text2).getText();
        download(driver, autoDownloadType.Photos, downloadType);
        appOperation.sleep(100);
        String after = appOperation.getElement(driver, E05_04_Chats.row_photos_text2).getText();
        System.out.println("afterChange =" + after);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到chats页面
    }

    /**
     * settings->chats页面，点击Auto-Download后到该页面
     * 点击Full Image，修改下载方式
     **/
    public void downloadFullImage(AppiumDriver driver) {
        appOperation.click(driver, E05_04_Chats.row_auto_download);//Chats页点击Auto-Download
        String downloadType = appOperation.getElement(driver, E05_04_Chats.row_original_photo_text2).getText();
        download(driver, autoDownloadType.Full_Image, downloadType);
        appOperation.sleep(100);
        String after = appOperation.getElement(driver, E05_04_Chats.row_original_photo_text2).getText();
        System.out.println("afterChange =" + after);
        Assert.assertNotEquals(downloadType, after);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到chats页面
    }

    /**
     * settings->chats页面，点击Auto-Download后到该页面
     * 点击Gif，修改下载方式
     **/
    public void downloadGif(AppiumDriver driver) {
        appOperation.click(driver, E05_04_Chats.row_auto_download);//Chats页点击Auto-Download
        String downloadType = appOperation.getElement(driver, E05_04_Chats.row_gif_text2).getText();
        download(driver, autoDownloadType.GIF, downloadType);
        appOperation.sleep(100);
        String after = appOperation.getElement(driver, E05_04_Chats.row_gif_text2).getText();
        System.out.println("afterChange =" + after);
        Assert.assertNotEquals(downloadType, after);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到chats页面
    }

    /**
     * settings->chats页面，点击Auto-Download后到该页面
     * 点击Videos，修改下载方式
     **/
    public void downloadVideos(AppiumDriver driver) {
        appOperation.click(driver, E05_04_Chats.row_auto_download);//Chats页点击Auto-Download
        String downloadType = appOperation.getElement(driver, E05_04_Chats.row_video_text2).getText();
        download(driver, autoDownloadType.Videos, downloadType);
        appOperation.sleep(100);
        String after = appOperation.getElement(driver, E05_04_Chats.row_video_text2).getText();
        System.out.println("afterChange =" + after);
        Assert.assertNotEquals(downloadType, after);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到chats页面
    }

    /**
     * settings->chats页面，点击Auto-Download后到该页面
     * 重置按钮
     **/
    public void downloadReset(AppiumDriver driver) {
        appOperation.click(driver, E05_04_Chats.row_auto_download);//Chats页点击Auto-Download到该页
        Boolean resetSettings = appOperation.waitForEle_Bool(driver, E05_04_Chats.row_blocked_contacts_text1);//Reset Auto-Download Settings按钮是否存在
        System.out.println("resetSettings=" + resetSettings);
        if (resetSettings == true) {
            appOperation.click(driver, E05_04_Chats.row_blocked_contacts_text1);
            appOperation.sleep(10);
            Boolean resetAfter = appOperation.waitForEle_Bool(driver, E05_04_Chats.row_blocked_contacts_text1);
            Assert.assertFalse(resetAfter);
            System.out.println("按钮存在的情况，点了一下已经恢复成默认值啦");
        } else if (resetSettings == false) {
            String photosDownType = appOperation.getElement(driver, E05_04_Chats.row_photos_text2).getText();
            String fullImageDownType = appOperation.getElement(driver, E05_04_Chats.row_original_photo_text2).getText();
            String gifDypeownType = appOperation.getElement(driver, E05_04_Chats.row_gif_text2).getText();
            String videosDypeownType = appOperation.getElement(driver, E05_04_Chats.row_video_text2).getText();
            Assert.assertEquals(photosDownType, E05_04_Chats.wifi_cellular);
            Assert.assertEquals(fullImageDownType, E05_04_Chats.wifi);
            Assert.assertEquals(gifDypeownType, E05_04_Chats.wifi_cellular);
            Assert.assertEquals(videosDypeownType, E05_04_Chats.wifi);
            System.out.println("按钮不存在，已经全部都是默认值");
        }
        appOperation.sleep(200);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到chats页面
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回到main页面
    }


    public enum autoDownloadType {Photos, Full_Image, GIF, Videos;}

    public void download(AppiumDriver driver, autoDownloadType autoDownloadType, String downloadType) {
        switch (autoDownloadType) {
            case Photos:
                downloadType = appOperation.getElement(driver, E05_04_Chats.row_photos_text2).getText();
                System.out.println("photosType beforeChanged=" + downloadType);
                appOperation.click(driver, E05_04_Chats.row_photos);//click Photos
                break;
            case Full_Image:
                downloadType = appOperation.getElement(driver, E05_04_Chats.row_original_photo_text2).getText();
                System.out.println("imageType beforeChanged=" + downloadType);
                appOperation.click(driver, E05_04_Chats.row_original_photo);//FullImage
                break;
            case GIF:
                downloadType = appOperation.getElement(driver, E05_04_Chats.row_gif_text2).getText();
                System.out.println("gifType beforeChanged=" + downloadType);
                appOperation.click(driver, E05_04_Chats.row_gif);//GIF
                break;
            case Videos:
                downloadType = appOperation.getElement(driver, E05_04_Chats.row_video_text2).getText();
                System.out.println("videsType beforeChanged=" + downloadType);
                appOperation.click(driver, E05_04_Chats.row_video);//Videos
                break;
        }
        if (downloadType.equals(E05_04_Chats.never)) {
            appOperation.click(driver, E05_04_Chats.wifi_text);//是never就点击wifi
        } else if (downloadType.equals(E05_04_Chats.wifi)) {
            appOperation.click(driver, E05_04_Chats.wifi_cellular_text);//wifi and cellular
        } else {
            appOperation.click(driver, E05_04_Chats.never_text);//never
        }
    }

    //选择自动下载方式
    public void autoDownload(AppiumDriver driver) {
        appOperation.click(driver,E08_ChatsSetting.autodownload);//点击auto-download
        appOperation.click(driver,E08_ChatsSetting.photos);//点击photos
        appOperation.click(driver,E08_ChatsSetting.wifi);//选择WiFi下载模式
        appOperation.click(driver,E08_ChatsSetting.fullimg);//点击Full Image
        appOperation.click(driver,E08_ChatsSetting.never);//选择never模式
        appOperation.click(driver,E08_ChatsSetting.videochoose);//点击Videos
        appOperation.click(driver,E08_ChatsSetting.wifi_cellular);//选择WiFi和cellular下载模式
        //appOperation.click(driver,E08_ChatsSetting.Chatsetting);//返回上一级chats
        appOperation.sleep(1000);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    //选择自动存储
    public void autoSave(AppiumDriver driver) {
        List<AndroidElement> FieldsList = driver.findElementsByClassName(E00_Main.Settings_xpath);
        for (int i = 0; i < FieldsList.size(); i++) {
            System.out.println(i + " SearchBack " + FieldsList.get(i).getLocation().toString());
        }
        FieldsList.get(0).click();
//        appOperation.click(driver,"android.widget.ImageButton");
//        appOperation.click(driver,"com.instanza.baba:id/menu_title");
//        appOperation.click(driver, E08_ChatsSetting.autosave);//勾选auto-save
    }

    public void chatSettingEntrance(AppiumDriver driver) {
        appOperation.click(driver, E00_Main.Settings);//Main Page
        appOperation.click(driver,E05_Setting.Chats);
//        appOperation.SearchParentElementByChildTextIDsParentClass(driver, E05_Setting.ChatsItemName, E05_Setting.Item, E05_Setting.ItemParentClass).click();
//        appOperation.click(driver, E05_Setting.ChatsSetting);//Setting Page
    }

//    public enum ChatSettingCase {changebackground, AutoDownloadmode, save;}
//    public void ChatsettingUpdate(AppiumDriver driver, ChatsSetting.ChatSettingCase chatSettingCaseObj){
//        ChatSettingEntrance(driver);
//        switch (chatSettingCaseObj){
//            case changebackground:
//                ChooseBackground(driver);
//                break;
//            case AutoDownloadmode:
//                AutoDownload(driver);
//                break;
//            case save:
//                AutoSave(driver);
//                break;
//            default :
//                break;
//        }
//        appOperation.sleep(2000);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//返回主页面
//    }

}
