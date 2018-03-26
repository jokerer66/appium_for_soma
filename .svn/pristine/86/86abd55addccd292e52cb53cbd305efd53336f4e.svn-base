package com.instanza.soma.Service;

import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E04_Contacts;
import com.instanza.soma.resources.E05_Setting;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sam on 2017/3/5.
 */
public class ContactsPageService {
    public AppOperation appOperation;
    private static ContactsPageService contactsServiceObj;
    public static ContactsPageService getInstance() {
        if (contactsServiceObj == null) {
            synchronized (ContactsPageService.class) {
                if (contactsServiceObj == null) {
                    contactsServiceObj = new ContactsPageService();
                }
            }
        }
        return contactsServiceObj;
    }
    public ContactsPageService() {
        appOperation = AppOperationImp.getInstance();
    }

    public void FirstLineContactClick(AppiumDriver driver) {
//        driver.findElementById(E00_Main.contacts_ll).click();
//        List<AndroidElement> FieldsList = driver.findElementsByClassName("android.widget.RelativeLayout");
//        FieldsList.get(4).click();
        //Main page
        appOperation.click(driver,E00_Main.contacts_ll);
        //Contacts page
        appOperation.click(driver, E04_Contacts.Contact);
    }
    public void ClickContactByName(AppiumDriver driver, String ContactName){
        appOperation.click(driver,E00_Main.contacts_ll);
//        appOperation.SearchParentElementByChildTextandIDs(driver, ContactName, "com.instanza.baba:id/contact_name", "com.instanza.baba:id/contact_layout").click();
    }
}
