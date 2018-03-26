package com.instanza.soma.Service.Social;

/**
 * Created by trista on 2017/3/9.
 */

import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E03_02_GameCenter;
import com.instanza.soma.resources.E03_Social;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class GameCenterPageService {
    public AppOperation appOperation;

    private static GameCenterPageService _gamecenterPageService1;
    public static GameCenterPageService getInstance(){
        if(_gamecenterPageService1 == null){
            synchronized (GameCenterPageService.class){
                if(_gamecenterPageService1 == null){
                    _gamecenterPageService1 = new GameCenterPageService();
                }
            }
        }
        return _gamecenterPageService1;
    }

    public GameCenterPageService(){appOperation = AppOperationImp.getInstance();}
public void GameCenterPageService1(AppiumDriver driver ){
    //
    appOperation.click(driver, E00_Main.Social);
    appOperation.click(driver, E03_Social.social_game_center);
    appOperation.click(driver,E03_02_GameCenter.iv_cover1);
    appOperation.swipeToLeft(driver,2000);
    appOperation.sleep(2000);
    appOperation.swipeToRight(driver,2000);
    appOperation.sleep(2000);
    appOperation.swipeToLeft(driver,2000);
    ((AndroidDriver)driver).pressKeyCode(4);
    appOperation.click(driver,E03_02_GameCenter.tv_operation);//点击get按钮
//Need To下载软件
    ((AndroidDriver)driver).pressKeyCode(4);
    appOperation.sleep(2000);
    appOperation.swipeToRight(driver,1000);

}
    public void VIPCenterPageService1(AppiumDriver driver ){
        appOperation.click(driver,E03_Social.social_vip_center);

    }
}
