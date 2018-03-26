package utils.assertT;

import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import utils.MyLogTest;

import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 2017/6/12.
 */
public class AssertT {
    private static AssertT assertT;
    private AppOperation appOperation;
    private MyLogTest log;

    public static AssertT getInstance(){
        if(assertT == null){
            synchronized (AssertT.class){
                if(assertT == null){
                    assertT = new AssertT();
                }
            }
        }
        return assertT;
    }

    public AssertT() {
        appOperation = AppOperationImp.getInstance();
        log = MyLogTest.getInstance();
    }

    /**
     * 判断eleid的元素是否展示出现
     * @param driver
     * @param reporttext
     * @param assertElement
     */
    public void AssertElementIsShow(AppiumDriver driver, String reporttext, String assertElement){
        Reporter.log(reporttext);
        assertTrue(appOperation.waitForEle_Bool(driver,assertElement));
    }

    /**
     * 判断eleid的元素文案中是否包含该verifyText
     * @param driver
     * @param reporttext
     * @param eleid
     * @param AssertText
     */
    public void AssertTextInElement(AppiumDriver driver,String reporttext,String eleid,String AssertText){
        WebElement tempelement = appOperation.getElement(driver,eleid);
        Reporter.log(reporttext);
        log.log("text =  "+tempelement.getText());
        assertTrue(tempelement.getText().contains(AssertText));
    }
}
