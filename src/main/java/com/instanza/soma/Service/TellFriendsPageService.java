package com.instanza.soma.Service;

import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E01_Callls;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by sam on 2017/3/6.
 */
public class TellFriendsPageService {
    public AppOperation appOperation;

    private static TellFriendsPageService tellFriendsObj;
    public static TellFriendsPageService getInstance(AppiumDriver driver){
        if(tellFriendsObj == null){
            synchronized (TellFriendsPageService.class){
                if(tellFriendsObj == null){
                    tellFriendsObj = new TellFriendsPageService(driver);
                }
            }
        }
        return tellFriendsObj;
    }

    public TellFriendsPageService(AppiumDriver driver){
        appOperation = AppOperationImp.getInstance();
        TellFriendsEntrance(driver);
    }

    public void TellFriendsByFacebook (AppiumDriver driver) {
        TellFriendsEntrance(driver);

        //Tell friends about SOMA 弹框
        appOperation.click(driver, E01_Callls.Tellfriends_Facebook);
        //Facebook Page
        appOperation.sendkey(driver,E01_Callls.Facebook_status_text,"hello");//输入文案hello
        appOperation.click(driver,E01_Callls.Facebook_button_share);

        TellFriendsBack(driver);
    }
    public void TellFriendsByTwitter (AppiumDriver driver) {
        TellFriendsEntrance(driver);
        //Tell friends about SOMA 弹框
        appOperation.click(driver, E01_Callls.Tellfriends_Twitter);
        //Twitter Page
        appOperation.click(driver,E01_Callls.Twitter_composer_post);
        TellFriendsBack(driver);
    }
    public void TellFriendsByMessage (AppiumDriver driver) {
        TellFriendsEntrance(driver);
        //Tell friends about SOMA 弹框
        appOperation.click(driver, E01_Callls.Tellfriends_Messages);
        //System Message Page
        appOperation.sendkey(driver,E01_Callls.SystemMessage_recipients_editor_to,"15967164429");
        appOperation.click(driver,E01_Callls.SystemMessage_btn_add_recipient);
        TellFriendsBack(driver);
    }
    public void TellFriendsByWhatsapp (AppiumDriver driver) {
        TellFriendsEntrance(driver);
        //Tell friends about SOMA 弹框
        appOperation.click(driver, E01_Callls.Tellfriends_WhatsApp);
        //Whatsapp page
        appOperation.click(driver,E01_Callls.Whatsapp_contactpicker_row_name);
        appOperation.click(driver,E01_Callls.Whatsapp_send);
        appOperation.click(driver,E01_Callls.Whatsapp_send);
        TellFriendsBack(driver);
    }
    public void TellFriendsByLine (AppiumDriver driver) {
        TellFriendsEntrance(driver);
        //Tell friends about SOMA 弹框

        //NeedToDo

        TellFriendsBack(driver);
    }
    public void TellFriendsByWechat (AppiumDriver driver) {
        TellFriendsEntrance(driver);
        //Tell friends about SOMA 弹框

        //NeedToDo

        TellFriendsBack(driver);
    }
    public void TellFriendsEntrance(AppiumDriver driver){
        //Main Page
        appOperation.click(driver, E00_Main.maintab_calls);
        //Calls Page 点击Tell friends about SOMA
        appOperation.click(driver, E01_Callls.tell_friends);
    }
    public void TellFriendsBack(AppiumDriver driver){
        //NeedTodo
//        driver.pressKeyCode(4);//返回上一级页面
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.pressKeyCode(4);//返回上一级页面
    }

}
