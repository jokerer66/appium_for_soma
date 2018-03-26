package utils.testlisten;

import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by apple on 2017/5/23.
 * http://www.cnblogs.com/testway/p/6019779.html
 */
public class ScreenShotListener extends TestListenerAdapter {
    private AppOperation appOperation;
    public int driverNumber = 0;
    public AppiumDriver driver;
    private String tempPhoneNumber;

    private static ScreenShotListener screenShotListener;

    public static ScreenShotListener getInstance(){
        if(screenShotListener == null){
            synchronized (ScreenShotListener.class){
                if(screenShotListener == null){
                    screenShotListener = new ScreenShotListener();
                }
            }
        }
        return screenShotListener;
    }

    public ScreenShotListener() {
        appOperation = AppOperationImp.getInstance();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        driverNumber = Integer.valueOf(Thread.currentThread().getName());
        driver = appiumServer.getAppuimDeviceList().get(driverNumber).getDriver();
        appOperation.takeScreenShot(driver,"driver"+driverNumber+"_"+tr.getMethod().getMethodName());
    }
}
