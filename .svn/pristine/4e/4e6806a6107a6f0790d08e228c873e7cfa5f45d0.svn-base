package com.instanza.soma.Service;

import help.AppOperation;
import help.AppOperationImp;

/**
 * Created by sam on 2017/3/13.
 */
public class SettingPageService {
    public AppOperation appOperation;
    private static SettingPageService settingServiceObj;
    public static SettingPageService getInstance() {
        if (settingServiceObj == null) {
            synchronized (SettingPageService.class) {
                if (settingServiceObj == null) {
                    settingServiceObj = new SettingPageService();
                }
            }
        }
        return settingServiceObj;
    }
    public SettingPageService() {
        appOperation = AppOperationImp.getInstance();
    }
    public void ss(){
        //"com.instanza.baba:id/phone";

    }
}
