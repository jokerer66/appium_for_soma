package help.bean;

import com.instanza.soma.config.PackageInformation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import static help.startup.SuiteTestThread.appiumServer;

/**
 * Created by apple on 2017/3/8.
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class AppiumDevice {
    private long appiumPort;//The appium Server port to connect to this Device
    private long bootstrapPort;//bootstrap Port
    private DesiredCapabilities devCapabilities;
    private Boolean ishuawei;
    private Boolean isselect_toRunTestcase;
    private AppiumDriver driver;

}