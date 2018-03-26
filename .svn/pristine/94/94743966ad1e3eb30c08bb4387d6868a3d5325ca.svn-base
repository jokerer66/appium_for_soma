package com.instanza.soma.Service.Social;

import com.instanza.soma.resources.E03_03_VIPCenter;
import com.instanza.soma.resources.E03_Social;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;

/**
 * Created by trista on 2017/3/9.
 */
public class VipCenterpageservice {
    public AppOperation appOperation;

    private static VipCenterpageservice _vipcenterpageservice1;

    public static VipCenterpageservice getInstance() {
        if (_vipcenterpageservice1 == null) {
            synchronized (VipCenterpageservice.class) {
                if (_vipcenterpageservice1 == null) {
                    _vipcenterpageservice1 = new VipCenterpageservice();
                }
            }
        }
        return _vipcenterpageservice1;
    }

    public VipCenterpageservice() {
        appOperation = AppOperationImp.getInstance();
    }

    public void VIPCenterPageService1(AppiumDriver driver) {
        appOperation.click(driver, E03_Social.social_vip_center);
        appOperation.click(driver, E03_03_VIPCenter.US$);
        //不支持Google play的手机
        appOperation.click(driver, E03_03_VIPCenter.OK);
        appOperation.swipeToRight(driver,1000);


    }
}