package help.bean;

import com.instanza.soma.config.PackageInformation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by apple on 2017/3/8.
 */

public class AppiumServer {
    @Getter
    @Setter
    private String serverIP = null;
    @Getter
    @Setter
    private List<AppiumDevice> appuimDeviceList;

    public AppiumServer() {
        appuimDeviceList = new ArrayList();
    }

//    public static void ServerListAdd(String IP, long PortNumber, String DEVICE_ID, String UDID, String PLATFORM_NAME, String PlatformVersion, long bootstrapPort,Boolean ishuawei) {
//        DesiredCapabilities tempcapabilities = null;
//        AppiumDriver driver = null;
//        Boolean newDevice = true;
//        Boolean newServer = false;
////        int DeviceIndex = 0;
//
//        appiumServer.setServerIP(IP);
//        if (appiumServer.getAppuimDeviceList() == null)
//            appiumServer.setAppuimDeviceList(new ArrayList<AppiumDevice>());
//
//        for (int j = 0; j < appiumServer.getAppuimDeviceList().size(); j++) {
//            if (appiumServer.getAppuimDeviceList().get(j) != null) {
//                if (appiumServer.getAppuimDeviceList().get(j).getDevCapabilities() != null) {
//                    if (appiumServer.getAppuimDeviceList().get(j).getDevCapabilities().getCapability(MobileCapabilityType.UDID).equals(UDID)) {
//                        newDevice = false;
////                        DeviceIndex = j;
//                        break;
//                    }
//                }
//            }
//
//        }
//
//        if (newDevice == true) {
//            appiumServer.getAppuimDeviceList().add(new AppiumDevice(PortNumber, bootstrapPort, tempcapabilities, driver,ishuawei));
//            if (PLATFORM_NAME.contains("android"))
//                setAndroidCapability(appiumServer.getAppuimDeviceList().size() - 1, PlatformVersion, PLATFORM_NAME, UDID);
//            else
//                setIosCapability(appiumServer.getAppuimDeviceList().size() - 1, PlatformVersion, PLATFORM_NAME, DEVICE_ID, UDID);
//        }
//    }


}
