package com.instanza.soma.Service;

import help.AppOperation;
import com.instanza.soma.resources.*;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by yutangyong on 14/03/2017.
 */
public class OperationMessageService {
    public AppOperation appOperation;


    private static OperationMessageService operationMessageService;

    public static OperationMessageService getInstance() {
        if (operationMessageService == null) {
            synchronized (OperationMessageService.class) {
                if (operationMessageService == null) {
                    operationMessageService = new OperationMessageService();
                }
            }
        }
        return operationMessageService;
    }
    public OperationMessageService() {
        appOperation = AppOperationImp.getInstance();
    }

    public void CopyText(AppiumDriver driver, String Message) {
        //NeedToDo 复制消息

    }

    public void ForwordMessage(AppiumDriver driver, String Message) {
        //NeedToDo转发消息

    }
    public void DeletedMessage(AppiumDriver driver, String Message) {
        //NeedToDo 删除消息

    }


}