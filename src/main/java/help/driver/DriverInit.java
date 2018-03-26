package help.driver;

//import io.appium.java_client.AppiumDriver;
import help.AppOperationImp;
import help.bean.AppiumDevice;
import help.startup.SuiteTestThread;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.MyLogTest;
import utils.MyProcess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


/**
 * Created by sam on 2017/3/5.
 */
public class DriverInit {
    private static DriverInit initdriverobj;
//    public static List<AppiumDriver> driverlist_All = new ArrayList<>();

    public static DriverInit getInstance() {
        if (initdriverobj == null) {
            synchronized (DriverInit.class) {
                if (initdriverobj == null) {
                    initdriverobj = new DriverInit();
                }
            }
        }
        return initdriverobj;
    }
    //一旦启动就持续的检测是否有可用的设备，是否有可用的端口，是否有废弃的设备，是否有废弃的端口进行处理
    //NeedToDo 无线连接被测手机的App
    //NeedToDo 两个手机之间通过监控的方式来感知接收消息和接听电话
    //NeedToDo 通过Web的方式，在手机端触发进行自动化回归测试
    public void setUp() throws Exception {
//        MobileInformation.GetMObileInformation();
//        StartAppiumServer();
//        StartDriverThreadNew();
    }

    /**
     * 启动appium服务端
     * @param listdevices
     */
    public void StartAppiumServer(List<AppiumDevice> listdevices){
        if(listdevices == null || listdevices.size() <=0){
            return;
        }
        String AppiumServerCommand = "";
        Boolean newAppiumServerconnect = false;
        System.out.println("AppiumServerCommand begin====================================================================");
        for (int j = 0; j < listdevices.size(); j++) {

            AppiumServerCommand = "appium -p " + listdevices.get(j).getAppiumPort() + " -bp " + listdevices.get(j).getBootstrapPort();
            if (!MyProcess.IsProcessActive(listdevices.get(j).getAppiumPort())) {
                System.out.println("Appium server start " + AppiumServerCommand);
                MyProcess.execCommand_simple(AppiumServerCommand);
                newAppiumServerconnect = true;
                AppOperationImp.getInstance().sleep(1500);
            } else {
                System.out.println("Appium server already exist " + AppiumServerCommand);
            }
        }
        if (newAppiumServerconnect) {
            System.out.println("New Appium server start, waitting");
            AppOperationImp.getInstance().sleep(30 * 1000);
        }
    }


    /**
     * 启动driver
     * @param listdevices
     */
    public void StartDriverThreadNew(List<AppiumDevice> listdevices){//getDevCapabilities().getCapability(MobileCapabilityType.UDID)



        List<Thread> driverThreadList = new ArrayList<>();
        for(int i=0;i<listdevices.size();i++){
            if(listdevices.get(i).getDriver()== null){
                try{
                    driverThreadList.add(new Thread(new DriverThread(listdevices.get(i))));
                }catch (Exception e){

                }
                MyLogTest.getInstance().log("build driver with "+listdevices.get(i).getDevCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME));
            }else {
                MyLogTest.getInstance().log("driver is exist with "+listdevices.get(i).getDevCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME));
            }
        }


        for(int i=0;i<driverThreadList.size();i++){
            try{
                driverThreadList.get(i).start();
            }catch (Exception e){

            }

        }
        for(int i=0;i<driverThreadList.size();i++){
            try{
                driverThreadList.get(i).join();
            }catch (Exception e){

            }

        }

//        for (int j = 0; j < listdevices.size(); j++) {
//            //因为回归测试，所以每次最好是新安装apk开始进行测试，这样反正每次就重新new 一个driver
//            if(listdevices.get(j).getDriver() !=null)
//                listdevices.get(j).setDriver(null);
////            else System.out.println("Driver already exist with index= "+j+" "+appiumServer.getAppuimDeviceList().get(j).getDriver().toString());
//            futureList.add(startDriver(j));
//        }

    }

}
