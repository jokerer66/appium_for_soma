package com.instanza.soma.Service;

import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E04_03_SingChattingPage;
import com.instanza.soma.resources.E05_04_Chats;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

/**
 * Created by sam on 2017/3/5.
 */
public class ChatsPageService {
    private static ChatsPageService chatsServiceObj;
    public AppOperation appOperation;

    public static ChatsPageService getInstance() {
        if (chatsServiceObj == null) {
            synchronized (ChatsPageService.class) {
                if (chatsServiceObj == null) {
                    chatsServiceObj = new ChatsPageService();
                }
            }
        }
        return chatsServiceObj;
    }
    public ChatsPageService(){
        appOperation = AppOperationImp.getInstance();
    }

    public void SessionClick() {
        //找到Session

        //点击Session
    }

    public void LastSessionClick(AppiumDriver driver) {
        //Main Page
        appOperation.click(driver,E00_Main.chats_ll);
        //Chats Page
        appOperation.click(driver, E05_04_Chats.ChatsSession,6);
    }
}
