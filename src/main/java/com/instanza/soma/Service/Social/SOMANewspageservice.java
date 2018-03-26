package com.instanza.soma.Service.Social;

import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E03_Social;
import com.instanza.soma.resources.E06_moments;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;

/**
 * Created by trista on 2017/3/14.
 */
public class SOMANewspageservice {
    public AppOperation appOperation;

    private static SOMANewspageservice _somaNewspageservice1;
    public static SOMANewspageservice getInstance(){
        if(_somaNewspageservice1 == null){
            synchronized (SOMANewspageservice.class){
                if(_somaNewspageservice1 == null){
                    _somaNewspageservice1 = new SOMANewspageservice();
                }
            }
        }
        return _somaNewspageservice1;
    }

    public SOMANewspageservice(){
        appOperation = AppOperationImp.getInstance();
    }
public void SOMANewspageservice12 (AppiumDriver driver) {
        appOperation.click(driver, E00_Main.Social);
//        appOperation.click(driver, E03_Social.social_somanews);
    //NEED to
}
}
