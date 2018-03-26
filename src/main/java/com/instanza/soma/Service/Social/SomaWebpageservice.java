package com.instanza.soma.Service.Social;

import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E03_04_SomaWeb;
import com.instanza.soma.resources.E03_Social;
import com.instanza.soma.resources.E06_moments;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by trista on 2017/3/9.
 */
public class SomaWebpageservice {
    public AppOperation appOperation;

    private static SomaWebpageservice _somawebpageservice1;
    public static SomaWebpageservice getInstance(){
        if(_somawebpageservice1 == null){
            synchronized (SomaWebpageservice.class){
                if(_somawebpageservice1 == null){
                    _somawebpageservice1 = new SomaWebpageservice();
                }
            }
        }
        return _somawebpageservice1;
    }

    public SomaWebpageservice(){
        appOperation = AppOperationImp.getInstance();
    }
    public void SomaWebpageservice1(AppiumDriver driver) {
        appOperation.click(driver, E00_Main.Social);
        appOperation.click(driver, E03_Social.social_web);
        appOperation.click(driver,E03_04_SomaWeb.tv_got);
        ((AndroidDriver)driver).pressKeyCode(4);
        //第一次还未扫描登入过soma的web端


    }
}
