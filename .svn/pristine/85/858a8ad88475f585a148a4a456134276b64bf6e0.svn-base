package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by catty on 2017/3/3.
 */
public class ResourceID {

    private AndroidDriver<AndroidElement> driver;
    private static final String RESOURCE_CLASS_HEADER = "package com.instanza.soma.appium.resources;\n\npublic class %s {\n\n";
    private static final String RESOURCE_CLASS_TAIL = "\n}";
    private static final String RESOURCE_FIELD = "    public static final String %s  = \"%s\";\n";
    private static final String RESOURCE_FILE = System.getProperty("user.dir") + "/src/test/java/com/instanza/soma/appium/resources/%s.java";


    @Before
    public void setUp() throws Exception {
//        File appDir = new File("/Users/catty/Documents/dev/IdeaWorkspace/TestJar");
//        File app = new File(appDir, "soma.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "X2P0215714003528");
        // capabilities.setCapability("app", this.getClass().getResource("/soma.apk").getPath());
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autolaunch", false);
        capabilities.setCapability("appPackage", "com.instanza.baba");
        capabilities.setCapability("appActivity", ".activity.CocoVoice");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void convert() {
        String className = "Test";
        Pattern pattern = Pattern.compile("resource-id=\"(([^\"])+)\"", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        try {
            //二级和三级页面必备
//            AppOperationImp ao = new AppOperationImp();
//            ao.waitForEleId(driver, "com.instanza.baba:id/action_bar_root");
            String pageResources = driver.getPageSource();
            Matcher m = pattern.matcher(pageResources);
//            Matcher m = pattern.matcher(FileUtils.readFileToString(new File("/Users/catty/Desktop/a.txt"), "utf-8"));//读本地文件使用
            StringBuilder sb = new StringBuilder(String.format(RESOURCE_CLASS_HEADER, className));

            Set<String> set = new HashSet();
            while (m.find()) {
                String resourceId = m.group(1);
                if (StringUtils.isNotBlank(resourceId)) {
                    if (!set.contains(resourceId)) {
                        set.add(resourceId);
                        String[] resourceIdArray = StringUtils.split(resourceId, "/");
                        if (resourceIdArray.length != 2) {
                            System.out.println("resource-id有问题：" + resourceId);
                            continue;
                        }
                        sb.append(String.format(RESOURCE_FIELD, resourceIdArray[1], resourceId)); //小写的
                        //sb.append(String.format(RESOURCE_FIELD, resourceIdArray[1].toUpperCase(), resourceId));//大写
//                        sb.append(String.format(RESOURCE_FIELD,
//                                CamelCaseUtils.toUnderline(resourceIdArray[1]).toUpperCase(), resourceId));
                    }
                }
            }
            sb.append(RESOURCE_CLASS_TAIL);
            String fileName = String.format(RESOURCE_FILE, className);
            FileUtils.writeStringToFile(new File(fileName), sb.toString());
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

//    @Test
//    public  void changeTXT() {
//        try {
//            File file = new File("/Users/catty/Desktop/a.txt");
//            file.delete();
//            AppOperationImp ao = new AppOperationImp();
//            ao.waitForEleId(driver, "android:id/text1");
//            FileWriter fw = new FileWriter("/Users/catty/Desktop/a.txt", true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write(driver.getPageSource());
//            bw.close();
//            fw.close();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
