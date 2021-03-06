package com.instanza.soma.Service.Setting;

import com.instanza.soma.resources.E05_08_Share;
import com.instanza.soma.resources.E05_Setting;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

/**
 * Created by catty on 2017/7/31.
 */
public class SharePage {
    public AppOperation appOperation;

    private static SharePage sharePage;

    public static SharePage getInstance() {
        if (sharePage == null) {
            synchronized (SharePage.class) {
                if (sharePage == null) {
                    sharePage = new SharePage();
                }
            }
        }
        return sharePage;
    }

    public SharePage() {
        appOperation = AppOperationImp.getInstance();
    }

    /**
     * Share页面打开后
     * 校验浮层内的文案内容
     *
     * @param driver
     */
    public void shareCoverDesc(AppiumDriver driver) {
        appOperation.click(driver, E05_Setting.Share);//settings展开页点击Share
        appOperation.sleep(5);
        String title = appOperation.getElement(driver, E05_08_Share.alertTitle).getText();
        System.out.println("title=" + title);
        Assert.assertEquals(title, E05_08_Share.getTitle);
        String facebook = appOperation.getElement(driver, E05_08_Share.text1, 0).getText();
        System.out.println("facebook=" + facebook);
        Assert.assertEquals(facebook, E05_08_Share.facebook);

        String twitter = appOperation.getElement(driver, E05_08_Share.text1, 1).getText();
        System.out.println("twitter=" + twitter);
        Assert.assertEquals(twitter, E05_08_Share.twitter);

        String messaging = appOperation.getElement(driver, E05_08_Share.text1, 2).getText();
        System.out.println("messaging=" + messaging);
        Assert.assertEquals(messaging, E05_08_Share.messaging);

        String messenger = appOperation.getElement(driver, E05_08_Share.text1, 3).getText();
        System.out.println("messenger=" + messenger);
        Assert.assertEquals(messenger, E05_08_Share.messenger);

        String line = appOperation.getElement(driver, E05_08_Share.text1, 4).getText();
        System.out.println("line=" + line);
        Assert.assertEquals(line, E05_08_Share.line);

        String wechat = appOperation.getElement(driver, E05_08_Share.text1, 5).getText();
        System.out.println("wechat=" + wechat);
        Assert.assertEquals(wechat, E05_08_Share.wechat);
    }

}
