package com.instanza.soma.Business;

import com.instanza.soma.Service.Setting.AccountPage;
//import com.instanza.soma.resources.E05_03_03_DeleteAccount;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;

/**
 * Created by sam on 2017/3/6.
 */
public class DeleteAccount {
    public AppOperation appOperation;

    private static DeleteAccount deleteAccountObj;

    public static DeleteAccount getInstance() {
        if (deleteAccountObj == null) {
            synchronized (DeleteAccount.class) {
                if (deleteAccountObj == null) {
                    deleteAccountObj = new DeleteAccount();
                }
            }
        }
        return deleteAccountObj;
    }

    public DeleteAccount() {
        appOperation = AppOperationImp.getInstance();
    }

    public void DeleteAccount(AppiumDriver driver, String Phonenumber) {
        AccountPage.getInstance().AccountUpdate(driver, AccountPage.AccountCase.AccountDelete, Phonenumber);
    }
}
