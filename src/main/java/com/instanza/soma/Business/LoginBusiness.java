package com.instanza.soma.Business;

import com.instanza.soma.Service.Login.LoginService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import help.driver.MobileInformation;
import com.instanza.soma.resources.*;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import static org.junit.Assert.*;

/**
 * Created by sam on 2017/3/1.
 */
public class LoginBusiness {

    public AppOperation appOperation;

    private static LoginBusiness t01_login;

    public static LoginBusiness getInstance() {
        if (t01_login == null) {
            synchronized (LoginBusiness.class) {
                if (t01_login == null) {
                    t01_login = new LoginBusiness();
                }
            }
        }
        return t01_login;
    }

    public LoginBusiness() {
        appOperation = AppOperationImp.getInstance();
    }

    public void Login(AppiumDriver driver, String ActivateType, String PhoneNumber, String PhoneCountry, String ProfileName, Boolean ishuawei) {
        appOperation.sleep(2000);
        if(driver.getPlatformName().toLowerCase().equals("android")){
            LoginService.getInstance().Login_android(driver,ActivateType,PhoneNumber,PhoneCountry,ProfileName,ishuawei);
        }else if (driver.getPlatformName().toLowerCase().equals("ios")){
            LoginService.getInstance().Login_ios(driver,ActivateType,PhoneNumber,PhoneCountry,ProfileName,false);
        }

    }
    public void DeleteAccount(AppiumDriver driver,String ActivateType) {
        appOperation.sleep(2000);
        if(driver.getPlatformName().toLowerCase().equals("android")){
            LoginService.getInstance().DeleteAccount_android(driver,ActivateType);
        }else if (driver.getPlatformName().toLowerCase().equals("ios")){
            LoginService.getInstance().DeleteAccount_ios(driver,ActivateType);
        }
    }
}
