package com.instanza.soma.Service;

import com.instanza.soma.resources.E00_Main01_Search;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sam on 2017/3/15.
 */
public class SearchPageService {
    public AppOperation appOperation;

    private static SearchPageService searchPageObj;
    public static SearchPageService getInstance() {
        if (searchPageObj == null) {
            synchronized (SearchPageService.class) {
                if (searchPageObj == null) {
                    searchPageObj = new SearchPageService();
                }
            }
        }
        return searchPageObj;
    }
    public SearchPageService(){
        appOperation = AppOperationImp.getInstance();
    }

    public Boolean IsContactExist(AppiumDriver driver, String searchPhoneNumber){
        try{
            driver.findElementById(E00_Main01_Search.search_src_text).sendKeys(searchPhoneNumber);//输入文案4429
//        String s="+1 850-692-2155";
//        String b=s.replaceAll("-","");
            WebElement targetElement=null, underElement=null;
            targetElement=driver.findElementById("com.instanza.baba:id/contact_name");
            underElement=((AndroidDriver)driver).findElementByAndroidUIAutomator("text(\"Contacts\")");
            if((targetElement!=null)&&(underElement!=null))
                return appOperation.IsElementExistUnderElement(targetElement,underElement);

        }catch (Exception e){
            return false;
        }
        return false;
    }
    public void SearchClick(AppiumDriver driver, String receiverPhoneNumber){
        //Main Page's Search button->Search Page->...
        //搜索出结果并已注册为SOMA，点击后->Chatting
        //搜索出结果未注册为SOMA，点击后->Contact
        //搜索结果为空，显示no result
        driver.findElementByAccessibilityId("Search").click();//点击搜索按钮
        driver.findElementById(E00_Main01_Search.search_src_text).sendKeys(receiverPhoneNumber);//输入文案4429
        driver.findElementById(E00_Main01_Search.contact_layout).click();//点击搜索结果
    }
}
