package help;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyData;
import utils.MyLogTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by apple on 2017/2/23.
 */
public class AppOperationImp implements AppOperation {

    private static AppOperationImp appOperationImp;
    private MyLogTest mylog ;
    public static AppOperationImp getInstance() {
        if (appOperationImp == null) {
            synchronized (AppOperation.class) {
                if (appOperationImp == null) {
                    appOperationImp = new AppOperationImp();
                }
            }
        }
        return appOperationImp;
    }


    public AppOperationImp() {
        mylog = MyLogTest.getInstance();
    }


    @Override
    public void snapshot(AppiumDriver driver, TakesScreenshot screenShot, String filename) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
        try {
            mylog.log("Threadname = " + Thread.currentThread().getName() + " save snapshot path is:" + currentPath + "/"
                    + filename);
            FileUtils
                    .copyFile(scrFile, new File(currentPath + "\\" + filename));
        } catch (IOException e) {
            mylog.log("Threadname = " + Thread.currentThread().getName() + " Can't save screenshot");
            e.printStackTrace();
        } finally {
            mylog.log("Threadname = " + Thread.currentThread().getName() + " screen shot finished, it's in " + currentPath
                    + " folder");
        }
    }

    @Override
    public void snapshot(AppiumDriver driver, String filename) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        //生成时间戳
        String dateString = formatter.format(new Date());
        String dir_name = System.getProperty("user.dir") + "\\异常图片";
        System.out.println("异常图片目录:" + dir_name);
        //由于可能存在异常图片的且当被删除的可能，所以这边先判断目录是否存在
        if (!(new File(dir_name).isDirectory())) ;
        {
            //目录不存在则创建目录
            new File(dir_name).mkdir();
        }
        //调用方法捕捉画面
        File screen = driver.getScreenshotAs(OutputType.FILE);
        //复制文件到指定目录
        //图片最后存放的路径由 目录：dir_name +时间戳+测试套件+测试用例+测试步骤组合生成
        System.out.println("异常图片名称：" + dir_name + "\\" + dateString + filename + ".jpg");
        FileUtils.copyFile(screen, new File(dir_name + "\\" + dateString + filename + ".jpg"));
    }

    @Override
    public void snapshot(AppiumDriver driver) {
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(System.getProperty("user.dir") + getCurrentDateTime() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");//设置日期格式
        return df.format(new Date());
    }

    /**
     * 等待一定时间,直到控件出现,或者时间结束
     *
     * @param ele    控件id
     * @param driver
     */

    @Override
    public void waitForEle(AppiumDriver driver, final String ele) {
//        waitForEle(driver,ele,0);
        WebDriverWait wait = new WebDriverWait(driver, MyData.waittime);
        String eletype = getEleType(ele);
        final String str = delete_elehead(ele,eletype);

        switch (eletype) {
            case "id":
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return webDriver.findElement(By.id(ele));
                    }
                });
                break;
            case "text":
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        if(driver.getPlatformName().toLowerCase().equals("android"))
                            return ((AndroidDriver) webDriver).findElementByAndroidUIAutomator(str);
                        else
                            return ((IOSDriver) webDriver).findElementByName(str.substring(6,str.length()-2));
                    }
                });
                break;
            case "xpath":
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return webDriver.findElement(By.xpath(str));
                    }
                });
                break;
            case "accessibilityid":
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return ((AppiumDriver) webDriver).findElementByAccessibilityId(str);
                    }
                });
                break;
            case "classname":
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return ((AppiumDriver) webDriver).findElementByClassName(str);
                    }
                });
                break;
            case "iosnspredicate":
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return ((IOSDriver) webDriver).findElementByIosNsPredicate(str);
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public void waitForEle(AppiumDriver driver, final String ele, final int index) {
        //NeedToDo, 有时候因为意外的收到的消息，弹出的Call页面，导致元素获取不到，如何处理
        //NeedToDo有时候定位不准，找不到元素，要在异常抛出前再抓一把元素列表显示，方便debug
        //NeedToDo有时候出现中文键盘，输入文本的时候会暂停，需要重置为英文键盘
        WebDriverWait wait = new WebDriverWait(driver, MyData.waittime);

        String eletype = getEleType(ele);
        final String str = delete_elehead(ele,eletype);
        if (waitForEle_Bool(driver, ele)) {
            switch (eletype) {
                case "id":
                    wait.until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver webDriver) {
                            return webDriver.findElements(By.id(ele)).get(index);
                        }
                    });
                    break;
                case "text":
                    wait.until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver webDriver) {
                            if(driver.getPlatformName().toLowerCase().equals("android"))
                                return (WebElement) ((AndroidDriver) webDriver).findElementsByAndroidUIAutomator(str).get(index);
                            else
                                return (WebElement) ((IOSDriver) webDriver).findElementsByName(str.substring(6,str.length()-2)).get(index);
                        }
                    });
                    break;
                case "xpath":
                    wait.until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver webDriver) {
                            return webDriver.findElements(By.xpath(str)).get(index);
                        }
                    });
                    break;
                case "accessibilityid":
                    wait.until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver webDriver) {
                            return (WebElement) ((AppiumDriver) webDriver).findElementsByAccessibilityId(str).get(index);
                        }
                    });
                    break;
                case "classname":
                    wait.until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver webDriver) {
                            return (WebElement) ((AppiumDriver) webDriver).findElementsByClassName(str).get(index);
                        }
                    });
                    break;
                case "iosnspredicate":
                    wait.until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver webDriver) {
                            return (WebElement) ((IOSDriver) webDriver).findElementsByIosNsPredicate(str).get(index);
                        }
                    });
                    break;
                default:
                    break;
            }
        }
    }


    @Override
    public Boolean waitForEle_Bool(AppiumDriver driver, final String ele) {
        return waitForEle_Bool_WithLimitTime(driver, ele, MyData.waittime);

//        Boolean flag = false;
//        WebDriverWait wait = new WebDriverWait(driver, MyData.waittime);
//        final String str = delete_elehead(ele);
//        String eletype = getEleType(ele);
//
//        try {
//            switch (eletype) {
//                case "id":
//                    wait.until(new ExpectedCondition<WebElement>() {
//                        public WebElement apply(WebDriver webDriver) {
//                            return webDriver.findElement(By.id(ele));
//                        }
//                    });
//                    break;
//                case "text":
//                    wait.until(new ExpectedCondition<WebElement>() {
//                        public WebElement apply(WebDriver webDriver) {
//                            if(driver.getPlatformName().toLowerCase().equals("android"))
//                                return ((AndroidDriver) webDriver).findElementByAndroidUIAutomator(str);
//                            else
//                                return ((IOSDriver) webDriver).findElementByName(str.substring(6,str.length()-2));
//                        }
//                    });
//                    break;
//                case "accessibilityid":
//                    wait.until(new ExpectedCondition<WebElement>() {
//                        public WebElement apply(WebDriver webDriver) {
//                            return ((AppiumDriver) webDriver).findElementByAccessibilityId(str);
//                        }
//                    });
//                    break;
//                case "xpath":
//                    wait.until(new ExpectedCondition<WebElement>() {
//                        public WebElement apply(WebDriver webDriver) {
//                            return webDriver.findElement(By.xpath(str));
//                        }
//                    });
//                    break;
//                case "classname":
//                    wait.until(new ExpectedCondition<WebElement>() {
//                        public WebElement apply(WebDriver webDriver) {
//                            return ((AppiumDriver) webDriver).findElementByClassName(str);
//                        }
//                    });
//                    break;
//                case "iosnspredicate":
//                    wait.until(new ExpectedCondition<WebElement>() {
//                        public WebElement apply(WebDriver webDriver) {
//                            return ((IOSDriver) webDriver).findElementByIosNsPredicate(str);
//                        }
//                    });
//                    break;
//                default:
//                    return false;
//            }
//            flag = true;
//        } catch (TimeoutException e) {
//            flag = false;
////            mylog.log("waitForEle_Bool.element = " + ele + " flag = " + flag);
////            return flag;
////            assert (flag);
//        }
//        mylog.log("waitForEle_Bool.element = " + ele + " flag = " + flag);
//        return flag;
    }

    public Boolean waitForEle_Bool_WithLimitTime(AppiumDriver driver, final String ele, int limittime_second){
        WebElement tempele = null;
        Boolean flag = false;

        String eletype = getEleType(ele);
        final String delete_elehead_str = delete_elehead(ele,eletype);
        WebDriverWait wait = new WebDriverWait(driver, limittime_second);

        try{
            if(driver.getPlatformName().toLowerCase().equals("ios")){
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return getUntilWebelement(webDriver,ele,delete_elehead_str,eletype,"ios");
                    }
                });
            }else if(driver.getPlatformName().toLowerCase().equals("android")){
                wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return getUntilWebelement(webDriver,ele,delete_elehead_str,eletype,"android");
                    }
                });
            }
            flag = true;
        } catch (TimeoutException e) {
//            e.printStackTrace();
            flag = false;
        }
        return flag ;
    }


    public WebElement getUntilWebelement(WebDriver webDriver, String ele, String delete_elehead_str, String eletype, String devicePlatform) {
        WebElement tempelement2 = null;
        List<WebElement> list = null;
        try {
            switch (eletype) {
                case "id":
//                    if(delete_elehead_str.contains("try_again")  || delete_elehead_str.contains("welcome_continue")){
//                        List<WebElement> listtt = webDriver.findElements(By.id(delete_elehead_str));
//                        System.out.println("size = "+ listtt.size());
//                        for(int i = 0;i<listtt.size();i++){
//                            WebElement tempweb = listtt.get(i);
//                            if (tempweb.isDisplayed() ) {
//                                if(tempweb != null){
//                                    System.out.println("i = "+ i);
//                                }
//
//                            }
//                        }
//
//                    }
                    for (WebElement webelement : webDriver.findElements(By.id(delete_elehead_str))) {
                        if (webelement.isDisplayed() ) {
                            tempelement2 = webelement;
                            break;
                        }
                    }
                    break;
                case "text":
                    if(devicePlatform.toLowerCase().equals("android")){
                        tempelement2 =  ((AndroidDriver) webDriver).findElementByAndroidUIAutomator(delete_elehead_str);
                    }else if(devicePlatform.toLowerCase().equals("ios")){
                        list = ((IOSDriver) webDriver).findElementsByName(delete_elehead_str.substring(6, delete_elehead_str.length() - 2));
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).isDisplayed() && list.get(i) != null) {
                                tempelement2 = list.get(i);
                                break;
                            }
                        }
                    }
                    break;
                case "accessibilityid":
                    list = ((AppiumDriver) webDriver).findElementsByAccessibilityId(delete_elehead_str);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isDisplayed() && list.get(i) != null) {
                            tempelement2 = list.get(i);
                            break;
                        }
                    }
                    break;
                case "xpath":
                    for (WebElement webelement : webDriver.findElements(By.xpath(delete_elehead_str))) {
                        if (webelement.isDisplayed() ) {
                            tempelement2 = webelement;
                            break;
                        }
                    }
                    break;
                case "classname":
                    for (WebElement webelement : webDriver.findElements(By.className(delete_elehead_str))) {
                        if (webelement.isDisplayed() ) {
                            tempelement2 = webelement;
                            break;
                        }
                    }
                    break;
                case "iosnspredicate":
                    list = ((IOSDriver) webDriver).findElementsByIosNsPredicate(delete_elehead_str);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isDisplayed() && list.get(i) != null) {
                            tempelement2 = list.get(i);
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }catch (Exception e){
//            e.printStackTrace();

        }
        return tempelement2;
    }


    /**
     * 等待一定时间,直到控件出现,或者时间结束
     *
     * @param ele    控件id
     * @param driver
     */
    @Override
    public Boolean waitForEle_Bool(AppiumDriver driver, final String ele, final int index) {
        return waitForEle_Bool_WithLimitTime(driver,ele, MyData.waittime,index);


//        WebDriverWait wait = new WebDriverWait(driver, MyData.waittime);
//        final String str = delete_elehead(ele);
//        String eletype = getEleType(ele);
//        Boolean flag = false;
//        sleep(2000);
//        if (waitForEle_Bool(driver, ele)) {
//            try {
//                switch (eletype) {
//                    case "id":
//                        wait.until(new ExpectedCondition<WebElement>() {
//                            public WebElement apply(WebDriver webDriver) {
//                                return webDriver.findElements(By.id(ele)).get(index);
//                            }
//                        });
//                        break;
//                    case "text":
//                        wait.until(new ExpectedCondition<WebElement>() {
//                            public WebElement apply(WebDriver webDriver) {
//                                if(driver.getPlatformName().toLowerCase().equals("android"))
//                                    return (WebElement) ((AndroidDriver) webDriver).findElementsByAndroidUIAutomator(str).get(index);
//                                else
//                                    return (WebElement) ((IOSDriver) webDriver).findElementsByName(str.substring(6,str.length()-2)).get(index);
//
//                            }
//                        });
//                        break;
//                    case "accessibilityid":
//                        wait.until(new ExpectedCondition<WebElement>() {
//                            public WebElement apply(WebDriver webDriver) {
//                                return (WebElement) ((AppiumDriver) webDriver).findElementsByAccessibilityId(str).get(index);
//                            }
//                        });
//                        break;
//                    case "xpath":
//                        wait.until(new ExpectedCondition<WebElement>() {
//                            public WebElement apply(WebDriver webDriver) {
//                                return (WebElement) webDriver.findElements(By.xpath(str)).get(index);
//                            }
//                        });
//                        break;
//                    case "classname":
//                        wait.until(new ExpectedCondition<WebElement>() {
//                            public WebElement apply(WebDriver webDriver) {
//                                mylog.log("count = "+ ((AppiumDriver) webDriver).findElementsByClassName(str).size());
//                                return (WebElement) ((AppiumDriver) webDriver).findElementsByClassName(str).get(index);
//                            }
//                        });
//                        break;
//                    case "iosnspredicate":
//                        wait.until(new ExpectedCondition<WebElement>() {
//                            public WebElement apply(WebDriver webDriver) {
//                                return (WebElement) ((IOSDriver) webDriver).findElementsByIosNsPredicate(str).get(index);
//                            }
//                        });
//                        break;
//                    default:
//                        return false;
//                }
//                flag = true;
//            } catch (TimeoutException e) {
//                flag = false;
//                mylog.log("TimeoutException : " + ele + " cannot find in "+MyData.waittime+" seconds");
//            }catch (IndexOutOfBoundsException e) {
//                flag = false;
//                int count = getElementCount(driver,ele);
//                mylog.log("IndexOutOfBoundsException: "+ele+" just find  "+count+"  elements with same "+eletype+" type ");
//                for(int i =0 ;i<count;i++){
//                    WebElement webElement = getElement(driver, ele,i);
//                    mylog.log("numbdr =  "+i+" with location x= "+webElement.getLocation().getX()+" y= "+webElement.getLocation().getY());
//                }
//            }
//        }
//        mylog.log("waitForEle_Bool_index.element = " + ele + " flag = " + flag);
//        return flag;
    }

    public Boolean waitForEle_Bool_WithLimitTime(AppiumDriver driver, final String ele, int limittime_second, int index){
        WebElement tempele = null;
        Boolean flag = false;
        String eletype = getEleType(ele);
        final String delete_elehead_str = delete_elehead(ele,eletype);


        WebDriverWait wait = new WebDriverWait(driver, limittime_second);

        if(driver.getPlatformName().toLowerCase().equals("ios")){
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                    return getUntilWebelement(webDriver,ele,delete_elehead_str,eletype,"ios",index);
                }
            });
        }else if(driver.getPlatformName().toLowerCase().equals("android")){
            wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                    return getUntilWebelement(webDriver,ele,delete_elehead_str,eletype,"android",index);
                }
            });
        }

        return flag ;
    }


    public WebElement getUntilWebelement(WebDriver webDriver, String ele, String delete_elehead_str, String eletype, String devicePlatform, int index) {
        if(index<0){
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element index cannot < 0");
        }
        WebElement tempelement2 = null;
        List<WebElement> list = null;
        try {
            switch (eletype) {
                case "id":
                    for (WebElement webelement : webDriver.findElements(By.id(ele))) {
                        if (webelement.isDisplayed() ) {
                            index--;
                            if(index<0){
                                tempelement2 = webelement;
                                break;
                            }
                        }
                    }
                    break;
                case "text":
                    if(devicePlatform.toLowerCase().equals("android")){
                        tempelement2 = (WebElement) ((AndroidDriver) webDriver).findElementsByAndroidUIAutomator(delete_elehead_str).get(index);

                    }else if(devicePlatform.toLowerCase().equals("ios")){
                        list = ((IOSDriver) webDriver).findElementsByName(delete_elehead_str.substring(6, delete_elehead_str.length() - 2));
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).isDisplayed() && list.get(i) != null) {
                                index--;
                                if(index <= -1){
                                    tempelement2 = list.get(i);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "accessibilityid":
                    list = ((AppiumDriver) webDriver).findElementsByAccessibilityId(delete_elehead_str);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isDisplayed() && list.get(i) != null) {
                            index--;
                            if(index<0){
                                tempelement2 = list.get(i);
                                break;
                            }
                        }
                    }
                    break;
                case "xpath":
                    for (WebElement webelement : webDriver.findElements(By.xpath(delete_elehead_str))) {
                        if (webelement.isDisplayed() ) {
                            index--;
                            if(index<0){
                                tempelement2 = webelement;
                                break;
                            }
                        }
                    }
                    break;
                case "classname":
                    for (WebElement webelement : webDriver.findElements(By.className(delete_elehead_str))) {
                        if (webelement.isDisplayed() ) {
                            index--;
                            if(index<0){
                                tempelement2 = webelement;
                                break;
                            }
                        }
                    }
                    break;
                case "iosnspredicate":
                    list = ((IOSDriver) webDriver).findElementsByIosNsPredicate(delete_elehead_str);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isDisplayed() && list.get(i) != null) {
                            index = index - 1;
                            if(index<0){
                                tempelement2 = list.get(i);

                                break;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();

        }



        return tempelement2;
    }

    @Override
    public void click(AppiumDriver driver, String click_on_ele) {
        WebElement tempele = null;
        tempele = getElement(driver,click_on_ele);
        if(tempele != null && tempele.isDisplayed()){
            tempele.click();
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = " +click_on_ele + " clicked successed");
        }else{
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = " +click_on_ele + " isnot displayed for click ");
        }
    }

    @Override
    public void click(AppiumDriver driver, String click_on_ele, int index) {
        WebElement tempele = null;
        tempele = getElement(driver,click_on_ele,index);
        if(tempele != null && tempele.isDisplayed()){
            tempele.click();
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = " +click_on_ele + " clicked with index = "+index);
        }else{
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = " +click_on_ele + " isnot displayed for click with index = "+index);
        }
    }


    /**
     * @param driver
     * @param ele    元素的str
     * @return
     */
    @Override
    public WebElement getElement(AppiumDriver driver, String ele) {
        WebElement tempele = null;
        String eletype = getEleType(ele);
        String delete_elehead_str = delete_elehead(ele,eletype);


        if (waitForEle_Bool(driver,ele)) {
            tempele = getUntilWebelement(driver, ele, delete_elehead_str, eletype, driver.getPlatformName().toLowerCase());
        }
        if(tempele == null){
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = "+ ele + " get failed");
        }else{
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = "+ ele + " get successed");
        }
        return tempele ;

    }

    @Override
    public WebElement getElement(AppiumDriver driver, String ele, int index) {
        WebElement tempele = null;
        if (waitForEle_Bool(driver,ele)){
            String eletype = getEleType(ele);
            String delete_elehead_str = delete_elehead(ele,eletype);

            tempele = getUntilWebelement(driver, ele, delete_elehead_str, eletype, driver.getPlatformName().toLowerCase(),index);
//            switch (eletype) {
//                case "id":
//                    tempele = (WebElement) driver.findElements(By.id(ele)).get(index);
//                    break;
//                case "text":
//                    if(driver.getPlatformName().toLowerCase().equals("android"))
//                        tempele = (WebElement) ((AndroidDriver) driver).findElementsByAndroidUIAutomator(elevalue).get(index);
//                    else
//                        tempele = (WebElement) ((IOSDriver) driver).findElementsByName(elevalue.substring(6,elevalue.length()-2)).get(index);
//                    break;
//                case "xpath":
//                    tempele = (WebElement) driver.findElements(By.xpath(elevalue)).get(index);
//                    break;
//                case "accessibilityid":
//                    tempele = (WebElement) driver.findElementsByAccessibilityId(elevalue).get(index);
//                    break;
//                case "classname":
//                    tempele = (WebElement) driver.findElementsByClassName(elevalue).get(index);
//                    break;
//                case "iosnspredicate":
//                    tempele = (WebElement) ((IOSDriver)driver).findElementsByIosNsPredicate(elevalue).get(index);
//                    break;
//                default:
//                    break;
//            }
        }
        if(tempele == null){
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = "+ ele + " get failed with index = "+index );
        }else{
            mylog.log("Threadname = " + Thread.currentThread().getName() + " element = "+ ele + " get successed with index = "+index );
        }
        return tempele;
    }

    @Override
    public List<WebElement> getElements(AppiumDriver driver, String ele) {
        List<WebElement> elementList = new ArrayList();
        List<WebElement> elementList_new = new ArrayList();
        if (waitForEle_Bool(driver,ele)){
            String eletype = getEleType(ele);
            String elevalue = delete_elehead(ele,eletype);
            switch (eletype) {
                case "id":
                    elementList = driver.findElements(By.id(ele));
                    break;
                case "text":
                    if(driver.getPlatformName().toLowerCase().equals("android"))
                        elementList = ((AndroidDriver) driver).findElementsByAndroidUIAutomator(elevalue);
                    else
                        elementList = ((IOSDriver) driver).findElementsByName(elevalue.substring(6,elevalue.length()-2));
                    break;
                case "xpath":
                    elementList = driver.findElements(By.xpath(elevalue));
                    break;
                case "accessibilityid":
                    elementList = driver.findElementsByAccessibilityId(elevalue);
                    break;
                case "classname":
                    elementList = driver.findElementsByClassName(elevalue);
                    break;
                case "iosnspredicate":
                    elementList = ((IOSDriver)driver).findElementsByIosNsPredicate(elevalue);
                    break;
                default:
                    break;
            }
            mylog.log("Threadname = " + Thread.currentThread().getName() + " getelements = "+ ele + " get successed" );
        }else{
            mylog.log("Threadname = " + Thread.currentThread().getName() + " getelements = "+ ele + " get failed" );
        }

        for(WebElement webele:elementList){
            if(webele.isDisplayed() && webele!=null){
                elementList_new.add(webele);
            }
        }
        return elementList_new;
    }

    @Override
    public int getElementCount(AppiumDriver driver, String ele) {
        int count = 0;
        count = getElements(driver,ele).size();
        mylog.log("Threadname = " + Thread.currentThread().getName() + " getElementCount size = "+ count +" with element = "+ele);
//
//        String eletype = getEleType(ele);
//        String elevalue = delete_elehead(ele);
//        switch (eletype) {
//            case "id":
//                count = driver.findElements(By.id(ele)).size();
//                break;
//            case "text":
//
//                if(driver.getPlatformName().toLowerCase().equals("android"))
//                    count = ((AndroidDriver) driver).findElementsByAndroidUIAutomator(elevalue).size();
//                else
//                    count = ((IOSDriver) driver).findElementsByName(elevalue.substring(6,elevalue.length()-2)).size();
//                break;
//            case "xpath":
//                count = driver.findElements(By.xpath(elevalue)).size();
//                break;
//            case "accessibilityid":
//                count = driver.findElementsByAccessibilityId(elevalue).size();
//                break;
//            case "classname":
//                count = driver.findElementsByClassName(elevalue).size();
//                break;
//            case "iosnspredicate":
//                count = ((IOSDriver)driver).findElementsByIosNsPredicate(elevalue).size();
//                break;
//            default:
//                break;
//        }
        return count;
    }

    @Override
    public void resetapp(AppiumDriver driver, String bundleId) {
        if(driver.getPlatformName().toLowerCase().equals("android")){
//            driver.removeApp(bundleId);
//            driver.installApp(driver.getCapabilities().getCapability("app").toString());
            driver.resetApp();
            sleep(2000);
        }else if(driver.getPlatformName().toLowerCase().equals("ios")){
            driver.removeApp(bundleId);
            driver.installApp(driver.getCapabilities().getCapability("app").toString());sleep(2000);
            //iosinstallapp之后,会出现卡死的情况,通过closeapp,再launchapp解决
            driver.closeApp();sleep(2000);
            driver.launchApp();sleep(2000);
        }
    }

    public String getEleType(String ele) {
        String eletype = "";
        int temp = ele.toLowerCase().indexOf("/");
        if (temp <= 0) {
            eletype = "";
        } else {
            if (ele.substring(temp - 2, temp + 1).contains("id")) {
                eletype = "id";
            }
        }

//        if(ele.toLowerCase().startsWith("id/")){eletype =  "id";}
//        if(ele.toLowerCase().startsWith("com.instanza.baba:id/")){eletype =  "id";}
//        if(ele.toLowerCase().startsWith("android:id/")){eletype =  "id";}

        if (ele.toLowerCase().startsWith("text")) {
            eletype = "text";
        }
        if (ele.toLowerCase().startsWith("xpath/")) {
            eletype = "xpath";
        }
        if (ele.toLowerCase().startsWith("accessibilityid/")) {
            eletype = "accessibilityid";
        }
        if (ele.toLowerCase().startsWith("classname/")) {
            eletype = "classname";
        }
        if(ele.toLowerCase().startsWith("value") ||ele.toLowerCase().startsWith("name") ||ele.toLowerCase().startsWith("label")){
            eletype = "iosnspredicate";
        }
        return eletype;
    }

    public String delete_elehead(String ele,String eletype) {
        String str = "";
        switch (eletype) {
            case "id":
//                str = ele.substring(ele.toLowerCase().indexOf("id/")+3);
                if(ele.toLowerCase().startsWith("id/")){
                    str = ele.substring(3);
                }else{
                    str = ele;
                }
                break;
            case "text":
                if (ele.toLowerCase().startsWith("text/")) {
                    str = ele.substring(ele.toLowerCase().indexOf("text/") + 5);
//                    if (!str.contains("text(\"")) str = "text(\"" + str + "\")";
                } else {
                    str = ele;
                }

                break;
            case "xpath":
                str = ele.substring(ele.toLowerCase().indexOf("xpath/") + 6);
                break;
            case "accessibilityid":
                str = ele.substring(ele.toLowerCase().indexOf("accessibilityid/") + 16);
                break;
            case "classname":
                str = ele.substring(ele.toLowerCase().indexOf("classname/") + 10);
                break;
            default:
                str = ele;
                break;

        }
        return str;
    }

    /**
     * 找到对应的空间,书写文字
     *
     * @param ele    控件id
     * @param driver
     */
    @Override
    public void sendkey(AppiumDriver driver, String ele, String context) {
        WebElement tempele = null;

        tempele = getElement(driver, ele);
        if (tempele == null) {
            return;
        }
        tempele.clear();
        tempele.sendKeys(context);
        mylog.log("Threadname = " + Thread.currentThread().getName() + " sendkey context:"+ context+"  in element:"+ele);
        if (driver.getPlatformName().toLowerCase().contains("android")){
            sleep(500);
            if(((AndroidDriver)driver).isKeyboardShown()){
                driver.hideKeyboard();
            }
        }else{
        }

    }

//    public void AdbSendKey(String context) {
//        String sendKeyCommand ="adb -s 2a2db6a shell input text "+context;
//        try {
//            Runtime.getRuntime().exec(sendKeyCommand);
//        }catch (Exception e){
//        }
//    }

    @Override
    public void sendkey(AppiumDriver driver, String ele, String context, int index) {
        WebElement tempele = null;

        tempele = getElement(driver, ele, index);
        if (tempele == null) {
            return;
        }
        tempele.clear();
        tempele.sendKeys(context);
        sleep(500);
        if(((AndroidDriver)driver).isKeyboardShown()){
            driver.hideKeyboard();
        }
    }

    /**
     * 长按按钮
     *
     * @param driver
     * @param clicktime_ms 长按时间以ms为单位
     */
    public void longpress(AppiumDriver driver, String eleid, int clicktime_ms) {
        WebElement ele = getElement(driver, eleid);
        longpress(driver,ele,clicktime_ms);
    }
    public void longpress(AppiumDriver driver, WebElement ele, int clicktime_ms) {
        if (ele == null) return;
        if (clicktime_ms <= 500) clicktime_ms = 3000;
        new TouchAction(driver).longPress(ele, clicktime_ms).release().perform();
    }


    @Override
    public void longpressAndMove(AppiumDriver driver, String fromid, String toid, int clicktime_ms) {
        WebElement fromele = getElement(driver, fromid);
        WebElement toele = getElement(driver, toid);
        int fromx = fromele.getLocation().getX();
        int fromy = fromele.getLocation().getY();
        int tox = toele.getLocation().getX();
        int toy = toele.getLocation().getY();
        if (fromele == null || toele == null) return;
        mylog.log("Threadname = " + Thread.currentThread().getName() + " x= " + fromx + " y = " + fromy + " tox = " + tox + " toy = " + toy);
        if (clicktime_ms <= 0) clicktime_ms = 3000;
        TouchAction touch = new TouchAction(driver);
        touch.longPress(fromx, fromy, clicktime_ms).moveTo(tox, toy).release().perform();

    }

    /**
     * This Method for swipe up
     *
     * @param driver
     * @param during
     */
    public void swipeToUp(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loadingtest
    }

    /**
     * This Method for swipe down
     *
     * @param driver
     * @param during
     */
    public void swipeToDown(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
        // wait for page loading
    }

    /**
     * This Method for swipe Left
     *
     * @param driver
     * @param during
     */
    public void swipeToLeft(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 7 / 8, height / 2, width / 8, height / 2, during);
        // wait for page loading
    }

    /**
     * This Method for swipe Right
     *
     * @param driver
     * @param during
     */
    public void swipeToRight(AppiumDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(2, height / 2, width * 7 / 8, height / 2, during);
        // wait for page loading
    }

    @Override
    public void sleep(int sleeptime) {
//        if (sleeptime <= 100) sleeptime = 2000;
        if (sleeptime <= 100) sleeptime = 500;
        try {
            Thread.sleep(sleeptime);
        } catch (Exception e) {

        }
    }

    /**
     *
     * @param driver
     * @param ScreenName 截图的名字
     */
    @Override
    public void takeScreenShot(AppiumDriver driver, String ScreenName) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-kk-mm");
            //生成时间戳
            String dateString = formatter.format(new Date());
            String dir_name = System.getProperty("user.dir") + "/appium_screenshot";
            if (!(new File(dir_name).isDirectory())) ;
            {
                new File(dir_name).mkdir();
            }
            //调用方法捕捉画面
            File screen = driver.getScreenshotAs(OutputType.FILE);
            //复制文件到指定目录
            mylog.log("Threadname = " + Thread.currentThread().getName() + " 异常图片名称" + dir_name + "/" + ScreenName +"_"+ dateString + ".jpg");
            FileUtils.copyFile(screen, new File(dir_name + "/" + ScreenName +"_"+ dateString + ".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toIosBackGround(AppiumDriver driver, int staytime_second) {
        if(staytime_second<=1) staytime_second =1;
        try {
            driver.runAppInBackground(staytime_second);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getNetworkType(AppiumDriver driver) {
        return ((AndroidDriver) driver).getConnection();
    }

    @Override
    public void setNetworkType(AppiumDriver driver, Connection networktype) {
        ((AndroidDriver) driver).setConnection(networktype);
        for (int i = 0; i < 10; i++) {
            if (((AndroidDriver) driver).getConnection() == networktype) {
                break;
            } else {
                sleep(1000);
            }
        }
    }

    @Override
    public WebElement SearchParentElementByChildTextIDsParentClass(AppiumDriver driver, String ChildName, String ChildID, String ParentClass) {
        List<WebElement> ChildElementList = driver.findElementsById(ChildID);
        WebElement ChildElement = null, ParentElement;
        for (int Index1 = 0; Index1 < ChildElementList.size(); Index1++)
            if (ChildElementList.get(Index1).getText().equals(ChildName))
                ChildElement = ChildElementList.get(Index1);
        ParentElement = SearchParentElementByChildElement(driver.findElementsByClassName(ParentClass), ChildElement);
        return ParentElement;
    }

    /*
    @Override
    public WebElement SearchParentElementByClass(List<WebElement> ParentList, WebElement ChildElement) {
        WebElement ParentElement = null;
        int childbeginx, childbeginy, childendx, childendy;
        int parentbeginx, parentbeginy, parentendx, parentendy;
        Dimension childsize, parentsize;

        childbeginx = ChildElement.getLocation().getX();//984
        childbeginy = ChildElement.getLocation().getY();//939
        childsize = ChildElement.getSize();
        childendx = childbeginx + childsize.getWidth();//1032
        childendy = childbeginy + childsize.getHeight();//987
//        mylog.log("Child beginx="+childbeginx+" endx="+childendx+" beginy="+childbeginy+" endy"+childendy+"=============");
        for (int Index1 = 0; Index1 < ParentList.size(); Index1++) {
            parentbeginx = ParentList.get(Index1).getLocation().getX();//0
            parentbeginy = ParentList.get(Index1).getLocation().getY();//819
            parentsize = ParentList.get(Index1).getSize();
            parentendx = parentbeginx + parentsize.getWidth();//1080
            parentendy = parentbeginy + parentsize.getHeight();//1035
//            mylog.log("parent beginx="+parentbeginx+" endx="+parentendx+" beginy="+parentbeginy+" endy"+parentendy+"=============");
            if ((childbeginx >= parentbeginx) &&
                    (childendx <= parentendx) &&
                    (childbeginy >= parentbeginy) &&
                    (childendy <= parentendy)) {
                ParentElement = ParentList.get(Index1);
                return ParentElement;
            }
        }
        return ParentElement;
    }
*/
    @Override
    public WebElement SearchParentElementByChildTextandIDs(AppiumDriver driver, String ChildName, String ChildID, String ParentID) {
        List<WebElement> ChildElementList = driver.findElementsById(ChildID);
        WebElement ChildElement = null, ParentElement;
        for (int Index1 = 0; Index1 < ChildElementList.size(); Index1++)
            if (ChildElementList.get(Index1).getText().equals(ChildName))
                ChildElement = ChildElementList.get(Index1);
        ParentElement = SearchParentElementByChildElement(driver.findElementsById(ParentID), ChildElement);
        return ParentElement;
    }

    @Override
    public WebElement SearchParentElementByChildElement(List<WebElement> ParentList, WebElement ChildElement) {
        WebElement ParentElement = null;
        int childbeginx, childbeginy, childendx, childendy;
        int parentIndexBeginx, parentIndexBeginy, parentIndexEndx, parentIndexEndy;
        int parentBeginx, parentBeginy, parentEndx, parentEndy;
        Dimension childsize, parentIndexSize, parentSize;

        childbeginx = ChildElement.getLocation().getX();//984
        childbeginy = ChildElement.getLocation().getY();//939
        childsize = ChildElement.getSize();
        childendx = childbeginx + childsize.getWidth();//1032
        childendy = childbeginy + childsize.getHeight();//987
//        mylog.log("Child beginx="+childbeginx+" endx="+childendx+" beginy="+childbeginy+" endy"+childendy+"=============");
        for (int Index1 = 0; Index1 < ParentList.size(); Index1++) {
            parentIndexBeginx = ParentList.get(Index1).getLocation().getX();//0
            parentIndexBeginy = ParentList.get(Index1).getLocation().getY();//819
            parentIndexSize = ParentList.get(Index1).getSize();
            parentIndexEndx = parentIndexBeginx + parentIndexSize.getWidth();//1080
            parentIndexEndy = parentIndexBeginy + parentIndexSize.getHeight();//1035
            //如果child在parentIndex内部，那么parentIndex是目标之一
//            mylog.log("parent Index "+Index1+" beginx= "+parentIndexBeginx+" endx="+parentIndexEndx+" beginy="+parentIndexBeginy+" endy"+parentIndexEndy+"=============");
            if ((childbeginx >= parentIndexBeginx) &&
                    (childendx <= parentIndexEndx) &&
                    (childbeginy >= parentIndexBeginy) &&
                    (childendy <= parentIndexEndy)) {
                if(ParentElement!=null){
                    parentBeginx = ParentElement.getLocation().getX();//0
                    parentBeginy = ParentElement.getLocation().getY();//819
                    parentSize = ParentElement.getSize();
                    parentEndx = parentBeginx + parentSize.getWidth();//1080
                    parentEndy = parentBeginy + parentSize.getHeight();//1035
                    //如果parentIndex在parent内部，那么要把parentIndex赋给parent
//                    mylog.log("Verify parent beginx="+parentBeginx+" endx="+parentEndx+" beginy="+parentBeginy+" endy"+parentEndy+"=============");
                    if ((parentIndexBeginx >= parentBeginx) &&
                            (parentIndexEndx <= parentEndx) &&
                            (parentIndexEndx >= parentBeginy) &&
                            (parentIndexEndy <= parentEndy)) {
//                        mylog.log("Pass parent beginx="+parentBeginx+" endx="+parentEndx+" beginy="+parentBeginy+" endy"+parentEndy+"=============");
                        ParentElement = ParentList.get(Index1);
                    }
                }else {
//                    mylog.log("First parent beginx="+parentIndexBeginx+" endx="+parentIndexEndx+" beginy="+parentIndexBeginy+" endy"+parentIndexEndy+"=============");
                    ParentElement = ParentList.get(Index1);
                }
            }
        }
        return ParentElement;
    }

    @Override
    public Boolean IsElementExistUnderElement(WebElement targetElement, WebElement underElement) {
//        mylog.log("targetElement.getLocation().getY() "+ targetElement.getLocation().getY());
//        mylog.log("targetElement.getSize().getHeight() "+ targetElement.getSize().getHeight());
//        mylog.log("underElement.getLocation().getY() "+ underElement.getLocation().getY());
//        mylog.log("underElement.getSize().getHeight() "+ underElement.getSize().getHeight());
        if (targetElement.getLocation().getY() + targetElement.getSize().getHeight() >= underElement.getLocation().getY() + underElement.getSize().getHeight())
            return true;
        return false;
    }
    public void PrintLnElementByClassName(AppiumDriver driver, String className){
        List <WebElement> BackElist =new ArrayList<WebElement>();
        BackElist=driver.findElementsByClassName(className);
        for (int Index1=0;Index1<BackElist.size();Index1++){
            WebElement backE=BackElist.get(Index1);
            mylog.log("Index "+Index1+" Location"+backE.getLocation().toString());
        }

    }
}
