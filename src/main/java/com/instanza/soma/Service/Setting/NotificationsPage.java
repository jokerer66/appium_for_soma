package com.instanza.soma.Service.Setting;

import com.instanza.soma.resources.E05_05_Notifications;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

/**
 * Created by daisy on 17/3/7.
 */
public class NotificationsPage {
    public AppOperation appOperation;

    private static NotificationsPage notificationsService;

    public NotificationsPage() {
        appOperation = AppOperationImp.getInstance();

    }

    public static NotificationsPage getInstance() {
        if (notificationsService == null) {
            synchronized (ProfilePage.class) {
                if (notificationsService == null) {
                    notificationsService = new NotificationsPage();
                }
            }
        }
        return notificationsService;
    }

    /**
     * Settings页面打开后
     * 打开Notification--Alert勾选框
     *
     * @param driver
     */
    public void clickAlert(AppiumDriver driver) {
        Boolean before = appOperation.getElement(driver, E05_05_Notifications.row_alert_switch).isSelected();
        appOperation.click(driver, E05_05_Notifications.Alert_Button);
        appOperation.sleep(10);
        Boolean after = appOperation.getElement(driver, E05_05_Notifications.row_alert_switch).isDisplayed();
        Assert.assertNotEquals(before, after);
    }

    /**
     * Settings页面打开后
     * 打开Notification--In-App Vibrate勾选框
     *
     * @param driver
     */
    public void clickInAppVibrate(AppiumDriver driver) {
        Boolean before = appOperation.getElement(driver, E05_05_Notifications.row_vibrate_switch).isSelected();
        appOperation.click(driver, E05_05_Notifications.row_vibrate);
        appOperation.sleep(10);
        Boolean after = appOperation.getElement(driver, E05_05_Notifications.row_vibrate_switch).isDisplayed();
        Assert.assertNotEquals(before, after);
    }

    /**
     * Settings页面打开后
     * 打开Notification--Sound到Select ringtone页面修改声音
     *
     * @param driver
     */
    public void soundChange(AppiumDriver driver) {
        String sound = appOperation.getElement(driver, E05_05_Notifications.row_sound_text1).getText();
        System.out.println("sound=" + sound);
        String changeBefore = appOperation.getElement(driver, E05_05_Notifications.row_sound_text2).getText();
        System.out.println("changeBefore=" + changeBefore);
        appOperation.click(driver, E05_05_Notifications.row_sound);//点击Sound到Select ringtone页
        if (changeBefore.equals("Bongo")) {
            appOperation.click(driver, E05_05_Notifications.Music);//点击music tab
            appOperation.click(driver, E05_05_Notifications.Closer_Tonight);//选择closer tonight
        } else {
            appOperation.click(driver, E05_05_Notifications.Ringtone);//点击Ringtone tab
            appOperation.click(driver, E05_05_Notifications.Bongo);
        }
        appOperation.click(driver, E05_05_Notifications.finish);//点击右上角的V完成
        String changeAfter = appOperation.getElement(driver, E05_05_Notifications.row_sound_text2).getText();
        System.out.println("changeAfter=" + changeAfter);
        Assert.assertNotEquals(changeBefore, changeAfter);
//        appOperation.click(driver, E05_05_Notifications.OK);//9500没有这个按钮
//        appOperation.click(driver, E05_05_Notifications.row_preview);
        appOperation.sleep(2000);
    }

    /**
     * Settings页面打开后
     * 打开Notification--Preview勾选框
     *
     * @param driver
     */
    public void clickPreview(AppiumDriver driver) {
        Boolean before = appOperation.getElement(driver, E05_05_Notifications.row_preview_switch).isSelected();
        appOperation.click(driver, E05_05_Notifications.row_preview);
        appOperation.sleep(10);
        Boolean after = appOperation.getElement(driver, E05_05_Notifications.row_preview_switch).isDisplayed();
        Assert.assertNotEquals(before, after);
    }

    /**
     * Settings页面打开后
     * 打开Notification--Preview说明内容校验
     *
     * @param driver
     */
    public void previewDesc(AppiumDriver driver) {
        String desc = appOperation.getElement(driver, E05_05_Notifications.previewdesc).getText();
        Assert.assertTrue(desc.contains("inside message notifications"));
    }

}
