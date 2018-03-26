package help;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Connection;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * Created by apple on 2017/3/2.
 */
public interface AppOperation {
    /**
     * This Method create for take screenshot
     * @author Catty
     * @param driver
     * @param screenShot
     * @param filename
     */
    void snapshot(AppiumDriver driver, TakesScreenshot screenShot, String filename);

    void snapshot(AppiumDriver driver, String filename) throws IOException;

    void snapshot(AppiumDriver driver);

    //等待一定时间,直到控件出现,或者时间结束
    void waitForEle(AppiumDriver driver, String ele);

    void waitForEle(AppiumDriver driver, String ele, int index);

//    void waitForEleId(AppiumDriver driver, final String ele_id);
//
//    void waitForEletext(AppiumDriver driver, final String ele_text);
//
//    void waitForElexpath(AppiumDriver driver, final String ele_xpath);
//
//    void waitForEleAccessibilityId(AppiumDriver driver, final String ele_AccessibilityId);
//    void waitForElename(AppiumDriver driver,final String ele_name);

    //等待一定时间,直到控件出现,或者时间结束,返回booeal值
    Boolean waitForEle_Bool(AppiumDriver driver, String ele);

    Boolean waitForEle_Bool(AppiumDriver driver, String ele, int index);

//    Boolean waitForEleId_bool(AppiumDriver driver, final String ele_id);
//
//    Boolean waitForEletext_bool(AppiumDriver driver, final String ele_text);
//
//    Boolean waitForElexpath_bool(AppiumDriver driver, final String ele_xpath);
//
//    Boolean waitForEleAccessibilityId_bool(AppiumDriver driver, final String ele_AccessibilityId);

    void click(AppiumDriver driver, String click_on_ele);

    void click(AppiumDriver driver, String click_on_ele, int index);

    WebElement getElement(AppiumDriver driver, String ele);

    WebElement getElement(AppiumDriver driver, String ele, int index);

    List<WebElement> getElements(AppiumDriver driver, String ele);

    int getElementCount(AppiumDriver driver, String ele);

    void resetapp(AppiumDriver driver, String bundleId);

    //sendkey
    void sendkey(AppiumDriver driver, String ele, String context);

    void sendkey(AppiumDriver driver, String ele, String context, int index);

    //长按按钮
    void longpress(AppiumDriver driver, String eleid, int clicktime_ms);

    void longpress(AppiumDriver driver, WebElement ele, int clicktime_ms);

    void longpressAndMove(AppiumDriver driver, String fromid, String toid, int clicktime_ms);

    //向某个固定方向划半个屏幕的距离
    void swipeToUp(AppiumDriver driver, int during);

    void swipeToDown(AppiumDriver driver, int during);

    void swipeToLeft(AppiumDriver driver, int during);

    void swipeToRight(AppiumDriver driver, int during);

    //sleep
    void sleep(int sleeptime);

    void takeScreenShot(AppiumDriver driver, String ScreenName);

    void toIosBackGround(AppiumDriver driver, int staytime_second);
    //
    Connection getNetworkType(AppiumDriver driver);

    void setNetworkType(AppiumDriver driver, Connection networktype);
    WebElement SearchParentElementByChildTextIDsParentClass(AppiumDriver driver, String ChildName, String ChildID, String ParentClass);

    WebElement SearchParentElementByChildTextandIDs(AppiumDriver driver, String ChildName, String ChildID, String ParentID);

    WebElement SearchParentElementByChildElement(List<WebElement> ParentList, WebElement ChildElement);

    Boolean IsElementExistUnderElement(WebElement targetElement, WebElement underElement);
    void PrintLnElementByClassName(AppiumDriver driver, String className);
}