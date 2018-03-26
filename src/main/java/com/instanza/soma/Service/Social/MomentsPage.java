package com.instanza.soma.Service.Social;

import com.instanza.soma.Service.Tools.GalleryPage;
import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E05_02_MyMoments;
import com.instanza.soma.resources.E06_01_Gallery;
import help.AppOperation;
import help.AppOperationImp;
import com.instanza.soma.resources.E06_moments;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

//import static com.mysql.fabric.jdbc.FabricMySQLDataSource.driver;
//import static org.junit.Assert.assertEquals;

/**
 * Created by trista on 2017/3/1.
 */
public class MomentsPage {
    private String ActivateType;

   

    public enum MomentEntry {Moments, MyMoments}

    public AppOperation appOperation;
    private static MomentsPage _momentsPage1;

    public static MomentsPage getInstance() {
        if (_momentsPage1 == null) {
            synchronized (MomentsPage.class) {
                if (_momentsPage1 == null) {
                    _momentsPage1 = new MomentsPage();
                }
            }
        }
        return _momentsPage1;
    }

    public MomentsPage() {
        appOperation = AppOperationImp.getInstance();
    }

    public void SentMoment(AppiumDriver driver, MomentEntry mEntry, GalleryPage.PhotoEntry pEntry) {
        SentMomentEntry(driver, mEntry);
        GalleryPage.getInstance().GetPhoto(driver, pEntry, GalleryPage.PhotoAction.select, 1);
        SentMomentTail(driver);


    }

    public void SentMomentEntry(AppiumDriver driver, MomentEntry mEntry) {
        if (mEntry == MomentEntry.Moments) {
            appOperation.click(driver, E00_Main.Social);//从Main page点击Social
            appOperation.click(driver, E06_moments.Moments);//从social Page点击moments
            appOperation.click(driver, E06_moments.camera);//从Moments Page点击相机图标
        } else if (mEntry == MomentEntry.MyMoments) {
            appOperation.click(driver, E00_Main.Settings);//从Main page点击Social
            appOperation.click(driver, E05_02_MyMoments.MyMoments);//Setting Page，点击My Moments
            appOperation.click(driver, E05_02_MyMoments.camera);//MyMoment Page, 点击大相机图标
        }

    }

    public void SentMomentTail(AppiumDriver driver) {
        appOperation.click(driver, E06_moments.Post);//发送Moments
        appOperation.sleep(3000);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);//Moments Page页面，返回到Main Page
        appOperation.sleep(1000);
    }

    public void AttachText(AppiumDriver driver) {
        appOperation.sendkey(driver, E06_moments.sns_edit, "i love you");
        //driver.hideKeyboard();
    }

    public void AttachLocation(AppiumDriver driver) {
        appOperation.click(driver, E06_moments.location_item);//点击location
        appOperation.click(driver, E06_moments.map_name);//点击第一个地址
    }

    public void AttachShare(AppiumDriver driver) {
        appOperation.click(driver, E06_moments.tv_selected);//点击share with
        appOperation.click(driver, E06_moments.share_exclude);//点击don't share
//        appOperation.click(driver, E06_moments.search_box);//点击输入框
//        appOperation.click(driver, E06_moments.search_box);
        appOperation.click(driver, E06_moments.contact_name);//点击搜索内容
        //appOperation.click(driver,E06_moments.function_button,E06_moments.Finished);
        appOperation.click(driver, E06_moments.function_button);//点击确认按钮
        //NeedToDo，为什么两个手机显示不一样，是bug?
        //181 Note3显示Done, 208 S6显示Done
        //点击完成按钮
        if (appOperation.waitForEle_Bool(driver, E06_moments.Finished))
            appOperation.click(driver, E06_moments.Finished);
        else if (appOperation.waitForEle_Bool(driver, E06_moments.Done))
            appOperation.click(driver, E06_moments.Done);
    }

    public void AttachPlus(AppiumDriver driver) {
        appOperation.click(driver, "xpath///android.widget.RelativeLayout[contains(@resource-id,'com.instanza.baba:id/image_frame')]/android.widget.ImageView[last()]");
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.ChoosePhoto, GalleryPage.PhotoAction.select, 1);
        appOperation.click(driver, "xpath///android.widget.RelativeLayout[contains(@resource-id,'com.instanza.baba:id/image_frame')]/android.widget.ImageView[last()]");
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.ChoosePhoto, GalleryPage.PhotoAction.select, 1);
    }

    public void MomentcoverUpdateByselectPhoto(AppiumDriver driver) {
//        NeedToDo需要考虑横屏和竖屏拍照模式
        //appOperation.click(driver, E00_Main.Social);//从Main tab点击Social
        //appOperation.click(driver, E06_moments.Moments);//从social Page点击moments
        //选择照片更换背景图
        appOperation.click(driver, E06_moments.momentsCover);
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.ChoosePhoto, GalleryPage.PhotoAction.cut, 1);
        appOperation.sleep(4000);
        //NeedToDo
//        driver.pressKeyCode(4);//返回到social页面
    }

    public void MomentcoverUpdateBytakePhoto(AppiumDriver driver) {
//        NeedToDo需要考虑横屏和竖屏拍照模式
        //appOperation.click(driver, E00_Main.Social);//从Main tab点击Social
        //appOperation.click(driver, E06_moments.Moments);//从social Page点击moments
        //拍照更换背景图
        appOperation.click(driver, E06_moments.momentsCover);
        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.TakePhoto, GalleryPage.PhotoAction.select, 1);
        appOperation.click(driver, E06_01_Gallery.Use);
        appOperation.sleep(3000);
        //NeedToDo
//        driver.pressKeyCode(4);//返回到social页面
    }

    public void MomentcoverUpdateByChoosePhoto(AppiumDriver driver) {
        //选照片更换背景图
    }

    public void MyMomentComments(AppiumDriver driver) {
        //appOperation.click(driver, E00_Main.Social);//从Main tab点击Social
        //appOperation.click(driver, E06_moments.Moments);//从social Page点击moments
        appOperation.click(driver, E06_moments.contact_avatar_ff);
        appOperation.sleep(3000);
        appOperation.click(driver, E06_moments.moment_item_thumb_1);

        appOperation.click(driver, E06_moments.view_btn_cancel);//点赞
        appOperation.click(driver, E06_moments.view_btn_comment);//
        appOperation.click(driver, E06_moments.sns_edit);//
        appOperation.sendkey(driver, E06_moments.sns_edit, "love");
        appOperation.click(driver, E06_moments.Send);//发送评论
        appOperation.click(driver, E06_moments.count_layout);
        appOperation.click(driver, E06_moments.friend_circle_menu);//
        appOperation.click(driver, E06_moments.Cancel);//取消点赞
        appOperation.click(driver, E06_moments.friend_circle_menu);//
        appOperation.click(driver, E06_moments.comment_text);//评论
        appOperation.click(driver, E06_moments.textMsgEditText);//
        appOperation.sendkey(driver, E06_moments.textMsgEditText, "soma");//输入评论
        appOperation.click(driver, E06_moments.sendTextBtn);//发送评论
        ((AndroidDriver) driver).pressKeyCode(4);
        appOperation.click(driver, E06_moments.Forward);
        appOperation.click(driver, E06_moments.Forward1);
        appOperation.click(driver, E06_moments.contacts);
        appOperation.click(driver, E06_moments.search_box_view);
        appOperation.sendkey(driver, E06_moments.search_box_view, "4429");//输入评论
        appOperation.click(driver, E06_moments.contact_layout);
        appOperation.click(driver, E06_moments.OK);
        appOperation.click(driver, E06_moments.Forward);
        appOperation.click(driver, E06_moments.Save_to_Phone);
        appOperation.click(driver, E06_moments.Forward);
        appOperation.click(driver, E06_moments.Delete);
        appOperation.click(driver, E06_moments.Yes);
        ((AndroidDriver) driver).pressKeyCode(4);
        appOperation.sleep(1000);
        ((AndroidDriver) driver).pressKeyCode(4);
    }

    public void Momentcomments(AppiumDriver driver) {
        appOperation.click(driver, E00_Main.Social);//从Main tab点击Social
        appOperation.click(driver, E06_moments.Moments);//从social Page点击moments
        appOperation.click(driver,E06_moments.imageView0);
        ((AndroidDriver) driver).pressKeyCode(4);
        appOperation.click(driver, E06_moments.friend_circle_menu);//
        appOperation.click(driver, E06_moments.like_text);//点赞
        appOperation.click(driver, E06_moments.friend_circle_menu);
        appOperation.click(driver, E06_moments.comment_text);//评论
        appOperation.sendkey(driver, E06_moments.textMsgEditText, "testtest");//输入评论
        appOperation.click(driver,E06_moments.sendTextBtn);



        appOperation.click(driver, E06_moments.friend_circle_menu);//
        appOperation.click(driver, E06_moments.Cancel);//取消点赞
        appOperation.click(driver, E06_moments.item_name);
        appOperation.click(driver, E06_moments.Delete);
        appOperation.click(driver, E06_moments.Yes);
        appOperation.click(driver, E06_moments.Delete);//删除朋友圈
        appOperation.click(driver, E06_moments.Yes);
        ((AndroidDriver) driver).pressKeyCode(4);//返回到social页面
    }

    public void contactinfoMoment(AppiumDriver driver) {
        appOperation.click(driver, E00_Main.maintab_chats);


    }

    public void SentMoment9(AppiumDriver driver, int photo_amount) {
        //appOperation.click(driver, E00_Main.Social);
        //appOperation.click(driver, E06_moments.Moments);//点击moments
        appOperation.click(driver, E06_moments.camera);
        appOperation.click(driver, E06_moments.ChoosePhoto);
        appOperation.click(driver, E06_moments.folderlist_img);
        //appOperation.click(driver, E06_moments.grid_avatar);
        if (photo_amount <= 9) {
            while (photo_amount != 0) {
                ((WebElement) driver.findElementsById(E06_01_Gallery.select_on).get(photo_amount)).click();
                photo_amount--;
            }
        } else {
            for (int i = 0; i <= 10; i++) {
                ((WebElement) driver.findElementsById(E06_01_Gallery.select_on).get(photo_amount--)).click();
            }
        }
        appOperation.click(driver, E06_moments.send_text);
        appOperation.click(driver, E06_moments.Post);
        ((AndroidDriver) driver).pressKeyCode(4);//返回到social页面
    }

    public void SentMoment4(AppiumDriver driver) {
        appOperation.click(driver, E00_Main.Social);
        appOperation.click(driver, E06_moments.Moments);//点击moments
       
        appOperation.click(driver, E06_moments.camera);
        appOperation.click(driver, E06_moments.ChoosePhoto);
        appOperation.click(driver, E06_moments.folderlist_img);
        appOperation.click(driver, E06_moments.grid_avatar);
        appOperation.click(driver, E06_moments.full_size);
        appOperation.click(driver, E06_moments.send_text);
//选择照片发送
        appOperation.click(driver, E06_moments.image_frame);
        appOperation.click(driver, E06_moments.ChoosePhoto);
        appOperation.click(driver, E06_moments.folderlist_img);
        appOperation.click(driver, E06_moments.grid_avatar);
        appOperation.click(driver, E06_moments.send_text);
//点击+号选择照片
        appOperation.click(driver, E06_moments.image_frame1);
        appOperation.click(driver, E06_moments.TakePhoto);
        appOperation.click(driver, E06_moments.Shutter);
        appOperation.click(driver, E06_moments.okay);
//点击+号拍照添加照片
        appOperation.click(driver, E06_moments.image_frame2);
        appOperation.click(driver, E06_moments.ChoosePhoto);
        appOperation.click(driver, E06_moments.folderlist_img);
        appOperation.click(driver, E06_moments.grid_avatar);
        appOperation.click(driver, E06_moments.send_text);
        appOperation.click(driver, E06_moments.Post);
    }
}