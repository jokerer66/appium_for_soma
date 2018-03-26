package help.controller;

import help.startup.SuiteTestThread;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by apple on 2017/4/13.
 */
@Controller
@RequestMapping("getReport")
public class GetReportController {
    @RequestMapping(method = RequestMethod.GET)
    public String getreport(ModelMap model) {
        int drivercount = SuiteTestThread.appiumServer.getAppuimDeviceList().size()>=1?SuiteTestThread.appiumServer.getAppuimDeviceList().size():1;

        model.addAttribute("drivercount", drivercount-1);
        return "TestReport";
    }
}
