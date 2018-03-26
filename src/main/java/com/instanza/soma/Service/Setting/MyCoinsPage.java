package com.instanza.soma.Service.Setting;

import com.instanza.soma.Service.Tools.GalleryPage;
import com.instanza.soma.resources.E05_09_MyCoins;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.Assert;

import java.util.List;

/**
 * Created by catty on 2017/7/26.
 */
public class MyCoinsPage {
    private static MyCoinsPage myCoinsPage;
    public AppOperation appOperation;

    public MyCoinsPage() {
        appOperation = AppOperationImp.getInstance();
    }

    public static MyCoinsPage getInstance() {
        if (myCoinsPage == null) {
            synchronized (MyCoinsPage.class) {
                if (myCoinsPage == null) {
                    myCoinsPage = new MyCoinsPage();
                }
            }
        }
        return myCoinsPage;
    }


    /**
     * 在My Coins页面校验页面的顶部文案，以及coins数量
     *
     * @param driver
     */
    public void myCoinsTitleDesc(AppiumDriver driver) {
        String records = appOperation.getElement(driver, E05_09_MyCoins.records).getText();
        Assert.assertTrue(records.contains("Records"));//校验Records
        String myCoins = appOperation.getElement(driver, E05_09_MyCoins.myCoins).getText();
        Assert.assertTrue(myCoins.contains("My Coins"));//校验My Coins
        String accountBalance = appOperation.getElement(driver,E05_09_MyCoins.accountBalance).getText();
        Assert.assertTrue(accountBalance.contains("Account Balance"));//校验accountBalance
        String coin_total = appOperation.getElement(driver,E05_09_MyCoins.coin_total).getText();
        if (coin_total.equals("0")){
            System.out.println("这个人太穷了，币数为0");
        }else{
            System.out.println("土豪我们做朋友吧，土豪共有coins："+coin_total);
        }
    }

    /**
     * 在My Coins页面内校验页面的多条item的数值是否正确，数量+赠品+定价
     *
     * @param driver
     */
    public void myCoinsDesc(AppiumDriver driver) {
        List<AndroidElement> items = driver.findElementsById(E05_09_MyCoins.coin_item);//左侧数量
        List<AndroidElement> costs = driver.findElementsById(E05_09_MyCoins.coin_cost);//右侧价格
        List<AndroidElement> itemsDesc = driver.findElementsById(E05_09_MyCoins.coin_item_desc);//左侧赠送数量

        Assert.assertEquals(items.get(0).getText(), "50");
        Assert.assertEquals(costs.get(0).getText(), "US$ 0.99");

        Assert.assertEquals(items.get(1).getText(), "100");
        Assert.assertEquals(costs.get(1).getText(), "US$ 1.99");

        Assert.assertEquals(items.get(2).getText(), "150");
        Assert.assertEquals(costs.get(2).getText(), "US$ 2.99");

        Assert.assertEquals(items.get(3).getText(), "220");
        Assert.assertEquals(costs.get(3).getText(), "US$ 3.99");

        Assert.assertEquals(items.get(4).getText(), "500");
        Assert.assertEquals(itemsDesc.get(0).getText(), "(+100)");
        System.out.println("500的赠送数值=" + itemsDesc.get(0).getText());
        Assert.assertEquals(costs.get(4).getText(), "US$ 7.99");

        Assert.assertEquals(items.get(5).getText(), "800");
        Assert.assertEquals(itemsDesc.get(1).getText(), "(+200)");
        System.out.println("800的赠送数值=" + itemsDesc.get(1).getText());
        Assert.assertEquals(costs.get(5).getText(), "US$ 11.99");

        appOperation.swipeToUp(driver, 300);//滑动后第一个数值没有计算在内所以index发生了变化

        String item1 = appOperation.getElement(driver, E05_09_MyCoins.coin_item, 5).getText();
        String cost1 = appOperation.getElement(driver, E05_09_MyCoins.coin_cost, 5).getText();
        String itemsDesc1 = appOperation.getElement(driver, E05_09_MyCoins.coin_item_desc, 2).getText();
        Assert.assertEquals(item1, "1600");
        Assert.assertEquals(cost1, "US$ 22.99");
        Assert.assertEquals(itemsDesc1, "(+400)");
        System.out.println("1600的赠送数值=" + itemsDesc1);

        String item2 = appOperation.getElement(driver, E05_09_MyCoins.coin_item, 6).getText();
        String cost2 = appOperation.getElement(driver, E05_09_MyCoins.coin_cost, 6).getText();
        String itemsDesc2 = appOperation.getElement(driver, E05_09_MyCoins.coin_item_desc, 3).getText();
        Assert.assertEquals(item2, "3300");
        Assert.assertEquals(cost2, "US$ 46.99");
        Assert.assertEquals(itemsDesc2, "(+900)");
        System.out.println("3300的赠送数值=" + itemsDesc2);
    }

    /**
     * 在My Coins页面点击Records到该页面校验一些文案后直接返回到my coins页
     *
     * @param driver
     */
    public void myCoinsRecords(AppiumDriver driver) {
        appOperation.click(driver, E05_09_MyCoins.records);
        String VIP = appOperation.getElement(driver, E05_09_MyCoins.item_name).getText();
        Assert.assertTrue(VIP.contains("VIP"));
        String Purchased = appOperation.getElement(driver, E05_09_MyCoins.item_type_text).getText();
        Assert.assertTrue(Purchased.contains("Purchased"));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * 在My Coins页面滑动到屏幕底部，校验pay problem----需要给P8配置邮箱，可惜失败了
     *
     * @param driver
     */
    public void payProblems(AppiumDriver driver) {
        appOperation.swipeToUp(driver, 300);//滑动后第一个数值没有计算在内所以index发生了变化
        appOperation.click(driver, E05_09_MyCoins.payment_problem);
        appOperation.sendkey(driver, E05_09_MyCoins.problem_et, SettingsTools.getRandomString(10));//输入框输入任意字符
//        appOperation.click(driver, E05_09_MyCoins.iv_image1);
//        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.Gallery, GalleryPage.PhotoAction.cut, 10);
//        appOperation.click(driver, E05_09_MyCoins.iv_image2);
//        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.Gallery, GalleryPage.PhotoAction.cut, 10);
//        appOperation.click(driver, E05_09_MyCoins.iv_image3);
//        GalleryPage.getInstance().GetPhoto(driver, GalleryPage.PhotoEntry.Gallery, GalleryPage.PhotoAction.cut, 10);
        appOperation.sleep(5000);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//点击返回键盘收起
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//点击返回键盘收起
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);//点击返回到My coins页面
    }

}
