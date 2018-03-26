package help.driver;

import help.bean.AppiumDevice;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.MyData;

import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by sam on 2017/3/9.
 */
public class DriverThread implements Runnable {
    public static Object object = new Object();
    AppiumDevice device;
    ExecutorService pool = null;

    public DriverThread() {
    }

    public DriverThread(AppiumDevice device) {
        this.device=device;
    }

    //单个线程处理方法，如果要串行处理，在Object前面加上synchronized
    @Override
    public void run() {
        StartDriverThread();
    }




//NeedToDo 只有Browser界面中选中的设备才启动driver并进行测试
    public void StartDriverThread(){
        AppiumDriver driver = null;
        String AppiumServerURL = "http://" + appiumServer.getServerIP() + ":" + device.getAppiumPort() + "/wd/hub";
        System.out.println("startDriver===========================================================");
        System.out.println("AppiumServerURL = " + AppiumServerURL);

//        System.out.println("PLATFORM_VERSION " + capabilitiesList.get(j).getVersion());
//        System.out.println("PLATFORM_NAME " + capabilitiesList.get(j).getPlatform());
//        System.out.println("DEVICE_NAME " + capabilitiesList.get(j).get);
//        System.out.println("APP " + capabilities.getCapability(MobileCapabilityType.APP));
//        System.out.println("appPackage " + capabilities.getCapability("appPackage"));
//        System.out.println("AUTOMATION_NAME " + capabilities.getCapability(MobileCapabilityType.AUTOMATION_NAME));
//        System.out.println("UDID " + capabilities.getCapability(MobileCapabilityType.UDID));
//        System.out.println("noReset " + capabilities.getCapability("noReset"));
        try {
            if (device.getDevCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).toString().contains(MyData.Android_Platform)) {
                //NeedToDo，两个Android+一个Ios时，第2个Android的driver new时失败
                driver = new AndroidDriver(new URL(AppiumServerURL), device.getDevCapabilities());
            } else {
                //NeedToDo 第2个Ios手机在new driver时会报错 iproxy exited with code '208'
                driver = new IOSDriver(new URL(AppiumServerURL), device.getDevCapabilities());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i=0;i<appiumServer.getAppuimDeviceList().size();i++){
            if(appiumServer.getAppuimDeviceList().get(i).getAppiumPort() == device.getAppiumPort()){
                appiumServer.getAppuimDeviceList().get(i).setDriver(driver);
            }
        }

    }
}
