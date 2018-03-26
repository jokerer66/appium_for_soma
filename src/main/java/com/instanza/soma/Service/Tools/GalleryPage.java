package com.instanza.soma.Service.Tools;

import com.instanza.soma.resources.E06_01_Gallery;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sam on 2017/3/16.
 */
public class GalleryPage {
    public enum PhotoEntry {ChoosePhoto, TakePhoto, Gallery, Camera}
    public enum PhotoAction {select, cut}

    public AppOperation appOperation;
    private static GalleryPage galleryObj;
    public static GalleryPage getInstance() {
        if (galleryObj == null) {
            synchronized (GalleryPage.class) {
                if (galleryObj == null) {
                    galleryObj = new GalleryPage();
                }
            }
        }
        return galleryObj;
    }
    public GalleryPage() {
        appOperation = AppOperationImp.getInstance();
    }

    public void GetPhoto(AppiumDriver driver, PhotoEntry pEntry, PhotoAction pAction, int photoNumber) {
        switch (pEntry){
            case ChoosePhoto:
                appOperation.click(driver, E06_01_Gallery.ChoosePhoto);//拍照或照片选择框,点击相册
                break;
            case Gallery:
                appOperation.click(driver, E06_01_Gallery.Gallery);//拍照或照片选择框,点击相册
                break;
            case TakePhoto:
                appOperation.click(driver, E06_01_Gallery.TakePhoto);//通过MyMoments拍照发送朋友圈
                break;
            case Camera:
                appOperation.click(driver, E06_01_Gallery.Camera);//通过MyMoments拍照发送朋友圈
                break;
        }
        if(pEntry== PhotoEntry.ChoosePhoto||pEntry==PhotoEntry.Gallery){
            if(pAction==PhotoAction.select)
                SelectedPhoto(driver,photoNumber);
            if(pAction==PhotoAction.cut)
                CutPhoto(driver);
        }else if(pEntry== PhotoEntry.TakePhoto||pEntry==PhotoEntry.Camera){
            TakePhoto(driver);
        }
    }

    public void SelectedPhoto(AppiumDriver driver, int number) {
        SelectPhoto(driver, number);
        appOperation.sleep(1000);
        appOperation.click(driver, E06_01_Gallery.send);//照片确认页，点击发送
    }

    public void CutPhoto(AppiumDriver driver) {
        SelectPhoto(driver, 1);
        appOperation.click(driver, E06_01_Gallery.Use);
    }

    public void SelectPhoto(AppiumDriver driver, int number) {
        appOperation.click(driver, E06_01_Gallery.folderlist);//照片集选择页面,点击第一组照片栏
        if (number == 1) {
            appOperation.click(driver, E06_01_Gallery.grid_avatar);//照片集页面，点击第一张照片
        }
        else if (number <= 9) {
            while (number != 0) {
                List<WebElement> eList=driver.findElementsById(E06_01_Gallery.select_on);
                if(number>eList.size())
                    number=eList.size();
                eList.get(number-1).click();
                number--;
            }
        }
        //NeedToDo
//        else if (number >= 10) {
//            for (int i = 0; i <= 10; i++) {
//                ((WebElement) driver.findElementsById(E06_01_Gallery.select_on).get(number--)).click();
//            }
//        }
    }
    //在单个相册集页面，Preview按钮后再下一步
//    switch (image_type) {
//        case Image:
//            appOperation.click(driver, E06_01_Gallery.send_text);
//            break;
//        case FullImage:
//            appOperation.click(driver, E06_01_Gallery.preview);
//            appOperation.click(driver, E06_01_Gallery.full_image);
//            appOperation.click(driver, E06_01_Gallery.send_text);
//            break;
//
//        default:
//            break;
//    }
    public void TakePhoto(AppiumDriver driver){
        //NeedToDo 181 Note3, 031 S4 Shutter元素抓不到
        //appOperation.click(driver, E06_01_Gallery.Shutter);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
//        appOperation.click(driver, E06_01_Gallery.shutter_button);
//        appOperation.click(driver, E06_01_Gallery.btn_done);
        appOperation.click(driver, E06_01_Gallery.kanvas_icon);//拍摄页面相机图标
        appOperation.click(driver, E06_01_Gallery.kanvas_send_icon);//拍摄页面V图标
        appOperation.click(driver, E06_01_Gallery.Use);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
//        ((AndroidDriver) driver).wait_activity("com.test.camera",2);
    }
}
