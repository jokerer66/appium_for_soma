package help.controller;

import help.bean.AppiumDevice;
import help.driver.DriverInit;
import help.startup.SuiteTestThread;
import io.appium.java_client.remote.MobileCapabilityType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.files.MyFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by apple on 2017/3/30.
 */
@Controller
@RequestMapping("/starttest")
public class StartTestMIssionController {


    private String devicename_temp,udid_temp;
    public static Object object = new Object();

    /**
     * 启动选择的设备的appiumserver端与相应的driver实例
     * @param devicename
     * @return
     */
    public List<AppiumDevice> startup(String devicename){
        System.out.println("device = "+devicename);
        String[] devicenames = devicename.split(",");
        Boolean flag_select = false;
        List<AppiumDevice> startup_listdevices = new ArrayList();
        for(int i=0;i< SuiteTestThread.appiumServer.getAppuimDeviceList().size();i++){
            for(int j=0;j<devicenames.length;j++){
                devicename_temp = devicenames[j].substring(devicenames[j].indexOf("(")+1,devicenames[j].indexOf(")"));
                udid_temp = devicenames[j].substring(0,devicenames[j].indexOf("("));
//                System.out.println("udid = "+ udid_temp);
//                System.out.println("devicename = "+ devicename_temp);

                String temp = SuiteTestThread.appiumServer.getAppuimDeviceList().get(i).getDevCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString();
                if(temp.equals(devicename_temp) || temp.equals(udid_temp)){
                    startup_listdevices.add(SuiteTestThread.appiumServer.getAppuimDeviceList().get(i));
                    SuiteTestThread.appiumServer.getAppuimDeviceList().get(i).setIsselect_toRunTestcase(true);
                    break;
                }

                if(j ==devicenames.length -1 ){
                    SuiteTestThread.appiumServer.getAppuimDeviceList().get(i).setIsselect_toRunTestcase(false);
                }
            }
        }

        DriverInit.getInstance().StartAppiumServer(startup_listdevices);
        DriverInit.getInstance().StartDriverThreadNew(startup_listdevices);
        startSuitetest(startup_listdevices);

        return startup_listdevices;
    }

    public void startSuitetest(List<AppiumDevice> startup_listdevices){
        final int base_threadNumber = 0;
        List<Thread> threadList = new ArrayList<>();
        for(int i=0;i<startup_listdevices.size();i++){

            if(startup_listdevices.get(i).getDriver() == null){
                continue;
            }
            try{
                if(startup_listdevices.get(i).getDriver()!= null) {
                    threadList.add(new Thread(new SuiteTestThread(""+base_threadNumber + i)));
                }

            }catch (Exception e){e.printStackTrace();}
        }

        for(Thread temp:threadList){
            try{
                temp.start();
            }catch (Exception e){e.printStackTrace();}
        }
        for(Thread temp:threadList){
            try{
                temp.join();
            }catch (Exception e){e.printStackTrace();}
        }

    }

    @RequestMapping(value = "starttest1" ,method = RequestMethod.POST)
    @ResponseBody
    public String starttest1(@RequestParam String devicename, @RequestParam String classname){
        if(devicename.equals("") || devicename == null){
            return "noclass";
        }
        if(devicename.contains("no devices") || devicename.equals("") || devicename == null){
            return "nodevice";
        }
        String[] classnames = classname.split(",");
        List<String> listclassnames = new ArrayList();
        for(int i=0;i<classnames.length;i++){
            listclassnames.add(classnames[i]);
        }

        String xmlcontext = createXmlContext(listclassnames);
        String filename = "/Users/"+System.getProperties().getProperty("user.name")+"/Desktop/xmlfile/MiniRegressionSuite.xml";
        createfile(filename,xmlcontext);


        List<AppiumDevice> listdevices = startup(devicename);
        if(listdevices == null){
            return "error";
        }
        return "finishtest";
    }

    public void createfile(String filename,String context){
        MyFile myFile = MyFile.getInstance();
        myFile.create_exe_file(filename,context);

    }

    public String createXmlContext(List<String> listClassname){
        String str = "";
        str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\" >\n" +
                "<suite name=\"Suite\" >\n" +
                "    <!--parallel=\"true\"  并行-->\n" +
                "    <!--verbose=\"2\" 标识的就是记录的日志级别，共有0-10的级别，其中0表示无，10表示最详细-->\n" +
                "    <!--当preserve-order=\"true\"是，可以保证节点下面的方法是按顺序执行的-->\n" +
                "    <!--<test name=\"Test regression 1\" verbose=\"10\" preserve-order=\"true\">-->\n" +
                "    <test name=\"Test regression 1\">\n" +
                "        <classes>\n" ;
        for(int i=0;i<listClassname.size();i++){
            str = str +
                "            <class name=\""+listClassname.get(i)+"\" />\n";
        }

         str = str+
                "        </classes>\n" +
                "    </test>\n" +
                "    <listeners>\n" +
                "        <listener class-name=\"org.uncommons.reportng.HTMLReporter\" />\n" +
                "        <listener class-name=\"org.uncommons.reportng.JUnitXMLReporter\"/>\n" +
                "    </listeners>\n" +
                "</suite>";
        return str;
    }
}
