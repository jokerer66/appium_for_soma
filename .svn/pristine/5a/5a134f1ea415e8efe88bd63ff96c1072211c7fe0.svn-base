package help.driver;

import com.instanza.soma.config.PackageInformation;
import help.bean.AppiumDevice;
import help.bean.AppiumServer;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.MyData;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import static help.startup.SuiteTestThread.appiumServer;

public class MobileInformation {
    public static List<String> UDID;
    public static List<String> Device_Name = new ArrayList<>();
    private static MobileInformation mobileInformation;
    private int base_port = 4725;
    private int base_bootstrapPort = 2251;

    //保存用于返回的设备列表
    public static List<String> listdevicealiasname = new ArrayList();

    public static MobileInformation getInstance(){
        if(mobileInformation == null){
            synchronized (MobileInformation.class){
                if(mobileInformation == null){
                    mobileInformation = new MobileInformation();
                }
            }
        }
        return mobileInformation;
    }

    public MobileInformation() {
    }

    public void GetMObileInformation() {

        InitAppiumServer();
        AddInAndroidMobile();
        AddInIosMobile();
//        DeleteOutMobile();
    }

    public void InitAppiumServer(){
        appiumServer.setServerIP(MyData.hostip);
    }

    public void AddInAndroidMobile() {
        Process process = null;
        InputStreamReader ir = null;
        LineNumberReader input = null;
        String line = null;

        Device_Name.clear();
        long port = 0;
        long bootstrapPort = 0;
        List<String> PLATFORM_NAME = new ArrayList<String>();
        boolean ishuawei = false;
        try {
            process = Runtime.getRuntime().exec("adb devices");
            ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);
            while ((line = input.readLine()) != null) {
                if (line.contains("device") && !line.contains("devices")) {
                    PLATFORM_NAME.add("android");
                    Device_Name.add(line.split("\t")[0].toString());
                }
            }
            line = null;
            input.close();
            ir.close();
            process.destroy();

            //因awk不能识别，用字符串的split来代替。adb shell cat /system/build.prop | grep ro.build.version.release | awk -F = '{print $2}'
            //因huawei手机不能执行grep，
            //huawei的字符串在版本号的字符串后面，所以找到一个的时候不能break
            for (int i = 0; i < Device_Name.size(); i++) {

                AppiumDevice appiumDevice = new AppiumDevice();
                DesiredCapabilities capabilities = new DesiredCapabilities();

                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,Device_Name.get(i));

                //NeedToDo可以用getprop ro.build.version.release这个更简单的命令来实现，待调试
                String platformversioncommand = "adb -s " + Device_Name.get(i) + " shell cat /system/build.prop";
                process = Runtime.getRuntime().exec(platformversioncommand);
                ir = new InputStreamReader(process.getInputStream());
                input = new LineNumberReader(ir);
                while ((line = input.readLine()) != null) {
                    if (line.contains("huawei") || line.contains("honor")) {
                        ishuawei = true;
                    }
                    if (line.contains("ro.build.version.release")) {
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,line.split("=")[1].toString());
                    }
                    //取到设备名
                    if (line.contains("ro.product.model")) {
                        listdevicealiasname.add(i, Device_Name.get(i).toString()+"("+line.split("=")[1].toString()+")");
                    }
                }
                input.close();
                ir.close();
                process.destroy();

                if(isInAppiumServer(Device_Name.get(i))){
                    continue;
                }


                appiumDevice = addAndroidDriver(appiumServer.getAppuimDeviceList().size()+ base_port,appiumServer.getAppuimDeviceList().size()+ base_bootstrapPort ,capabilities,ishuawei);
                appiumServer.getAppuimDeviceList().add(appiumDevice);

            }
            //Kill -9 adbprocess
            process = Runtime.getRuntime().exec("pgrep adb");
            ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);

            while ((line = input.readLine()) != null) {
                StringBuilder KillAdbString = new StringBuilder();
                KillAdbString.append("kill -9 ");
                KillAdbString.append(line.toString());
                process = Runtime.getRuntime().exec(KillAdbString.toString());
            }
            input.close();
            ir.close();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void AddInIosMobile() {
        Process process = null;
        InputStreamReader ir = null;
        LineNumberReader input = null;
        String line = null;
        long port = 0;
        long bootstrapPort = 0;

        try {
            process = Runtime.getRuntime().exec("instruments -s devices");
            ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);
            while ((line = input.readLine()) != null) {
                if (line.contains("[")) {
                    if (!line.substring(line.indexOf("[") + 1, line.indexOf("]")).contains("-") && line.contains("(") && line.contains(")") && line.contains("[") && line.contains("]")) {
                        String udid ,devicename,platformversion;
                        devicename = line.substring(0, line.indexOf("("));
                        platformversion = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                        udid = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
                        listdevicealiasname.add(udid+"(" + devicename + ")");
                        if(isInAppiumServer(devicename)){
                            continue;
                        }
                        AppiumDevice appiumDevice = new AppiumDevice();
                        DesiredCapabilities capabilities = new DesiredCapabilities();

                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,devicename);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformversion);
                        capabilities.setCapability(MobileCapabilityType.UDID,udid);


                        appiumDevice = addIosDriver(appiumServer.getAppuimDeviceList().size()+ base_port,appiumServer.getAppuimDeviceList().size()+ base_bootstrapPort ,capabilities,false);
                        appiumServer.getAppuimDeviceList().add(appiumDevice);

                    }
                }

            }
            input.close();
            ir.close();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean isInAppiumServer(String devicename){
        Boolean flag = false;

        if(appiumServer.getAppuimDeviceList().size() <= 0){
            return false;
        }else{
            for(int i=0;i<appiumServer.getAppuimDeviceList().size();i++){
                if(devicename.equals(appiumServer.getAppuimDeviceList().get(i).getDevCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME))){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static void DeleteOutMobile() {
        Boolean NeedDelete = true;
        if(appiumServer.getAppuimDeviceList() == null || UDID.size() <= 0)
            return;
        for (int i = 0; i < appiumServer.getAppuimDeviceList().size(); i++) {
            for (int j = 0; j < UDID.size(); j++) {
                if (appiumServer.getAppuimDeviceList().get(i).getDevCapabilities().getCapability(MobileCapabilityType.UDID).equals(UDID.get(j))) {
                    NeedDelete = false;
                    break;
                }
            }
            if (NeedDelete == true) {
                appiumServer.getAppuimDeviceList().remove(i);
                i = i - 1;
            } else NeedDelete = true;
        }
    }


    //devCapabilities中需要携带deviceName 和 platformVersion
    public AppiumDevice addAndroidDriver(long appiumPort, long bootstrapPort, DesiredCapabilities devCapabilities, Boolean ishuawei) {
        AppiumDevice androiddriver = new AppiumDevice();
        androiddriver.setAppiumPort(appiumPort);
        androiddriver.setBootstrapPort(bootstrapPort);
        androiddriver.setIshuawei(ishuawei);
        androiddriver.setIsselect_toRunTestcase(false);

        devCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MyData.Android_Platform);
        devCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 10);//默认60s
        devCapabilities.setCapability(MobileCapabilityType.NO_RESET, true); //true不需要再次安装包，而是直接使用App界面, 不要在会话前重置应用状态。默认值false。
        devCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, MyData.Automation_Name_Appium);
        devCapabilities.setCapability(MobileCapabilityType.APP, PackageInformation.AndroidAppName);
        devCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PackageInformation.AndroidPackageName);
        devCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, PackageInformation.AndroidActivityName);//Android特有的

        androiddriver.setDevCapabilities(devCapabilities);
        return androiddriver;
    }

    ////devCapabilities中需要携带deviceName 和 platformVersion 和 udid
    public AppiumDevice addIosDriver(long appiumPort, long bootstrapPort, DesiredCapabilities devCapabilities, Boolean ishuawei) {
        AppiumDevice iosdriver = new AppiumDevice();
        iosdriver.setAppiumPort(appiumPort);
        iosdriver.setBootstrapPort(bootstrapPort);
        iosdriver.setIshuawei(ishuawei);
        iosdriver.setIsselect_toRunTestcase(false);

        devCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MyData.Ios_Platform);
        devCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 10);//默认60s
        devCapabilities.setCapability(MobileCapabilityType.NO_RESET, true); //true不需要再次安装包，而是直接使用App界面, 不要在会话前重置应用状态。默认值false。
        devCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, MyData.Automation_Name_XCUITest);
        devCapabilities.setCapability(MobileCapabilityType.APP, PackageInformation.iOSAppName);
        devCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, MyData.Ios_Bundle_id);
        iosdriver.setDevCapabilities(devCapabilities);
        return iosdriver;
    }
}
