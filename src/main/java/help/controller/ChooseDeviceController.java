package help.controller;

import help.bean.AppiumDevice;
import help.driver.MobileInformation;
import help.startup.SuiteTestThread;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import utils.MyData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by apple on 2017/3/30.
 */

@Controller
@RequestMapping(value = "choosedevice")
public class ChooseDeviceController {

    @RequestMapping(method = RequestMethod.GET)
    public String getdevicelist(ModelMap modelMap){
        MobileInformation.listdevicealiasname.clear();
        MobileInformation.getInstance().GetMObileInformation();
        List<AppiumDevice> listdevice = new ArrayList();
        listdevice = SuiteTestThread.appiumServer.getAppuimDeviceList();
        List<String> listdevicename = new ArrayList();
        if(listdevice.size() <= 0 ){
            listdevicename.add("no devices");
            MobileInformation.listdevicealiasname.add("no devices(no devices)");
        }else
        for(int i=0;i<listdevice.size();i++){
            listdevicename.add(listdevice.get(i).getDevCapabilities().getCapability("deviceName").toString());
        }
        modelMap.addAttribute("devicelist",listdevicename);
        modelMap.addAttribute("listdevicealiasname",MobileInformation.listdevicealiasname);
        modelMap.addAttribute("listclassname", MyData.initListClassname());
        return "chooseDevice";
    }
}
