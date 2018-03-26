package com.instanza.soma.Business;

import com.instanza.soma.Service.AddPageService;
import com.instanza.soma.Service.ChatsPageService;
import com.instanza.soma.Service.ChattingPageService;
import com.instanza.soma.Service.ContactsPageService;
import com.instanza.soma.resources.E00_Main;
import com.instanza.soma.resources.E00_Main01_Search;
import com.instanza.soma.resources.E04_03_SingChattingPage;
import help.AppOperation;
import help.AppOperationImp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sam on 2017/3/5.
 */
public class SentMessage {
    public AppOperation appOperation;

    private static SentMessage sentMessageObj;
    public static SentMessage getInstance() {
        if (sentMessageObj == null) {
            synchronized (SentMessage.class) {
                if (sentMessageObj == null) {
                    sentMessageObj = new SentMessage();
                }
            }
        }
        return sentMessageObj;
    }
    public SentMessage(){appOperation = AppOperationImp.getInstance();}


//    public enum Entrance {Search, Contacts, AddButtonSingleChatting, AddButtonGroupChatting, Chats;}
    public enum Entrance {Search, Contacts, AddButtonSingleChatting, AddButtonGroupChatting, Chats;}
    public enum Type {TextEmoj, Voice, Photo, Video, CameraPhoto, CameraVideo, Location_DefaultSend,Location_SelectSend,Location_SearchSend, Namecard;}

    public enum BackType {Element, KeyCode;}



    //发一条消息，退出到主页面，再继续发消息，直到各种类型的消息都发送一遍
    public void SentAllKindsMessageEnterAndBack(AppiumDriver driver,String receiverPhoneNumber) {
        //LoginBusiness.getInstance().Login(driver, "Old", "4106704956", "united states", "Name");//老用户登录
        for(Type typeObj:Type.values()) {
//            SentMessage(driver,Entrance.Search,typeObj,"I come from SentMessageFromAllEntrance by "+Type.values(), BackType.Element);
            SentMessage(driver,Entrance.Search,typeObj,"SentAllKindsMessageEnterAndBack by "+typeObj, BackType.Element,receiverPhoneNumber);
        }
//NeedToDo
//        SentMessage(driver, Entrance.Search, Type.CameraPhoto,"I come from SentMessage", BackType.KeyCode);
//        SentMessage(driver, Entrance.Search, Type.CameraVideo,"I come from SentMessage", BackType.KeyCode);
//        SentMessage(driver, Entrance.Search, Type.Location,"I come from SentMessage", BackType.KeyCode);
    }
    public void SentMessageFromAllEntrance(AppiumDriver driver, String receiverPhoneNumber) {
        //LoginBusiness.getInstance().Login(driver, "Old", "4106704956", "united states", "Name");//老用户登录
        //从不同的入口发各种消息，发完后再退到主界面
        for(Entrance entranceObj:Entrance.values()) {
            SentMessage(driver, entranceObj,Type.TextEmoj,"SentMessageFromAllEntrance by "+entranceObj, BackType.Element,receiverPhoneNumber);
        }
//                    SentMessage(driver, Entrance.AddButtonSingleChatting,Type.TextEmoj,"SentMessageFromAllEntrance by ", BackType.Element);

    }
    public void SentMessage(AppiumDriver driver) {
        //LoginBusiness.getInstance().Login(driver, "Old", "4106704956", "united states", "Name");//老用户登录
        //对不同的人发各种消息，发完后再退到主界面
    }

    //已经在聊天Chatting界面才能调用SentMessage
    public void SentMessage(AppiumDriver driver, int CycleNumber, String receiverPhoneNumber) {
        SentMessageBySerarch(driver,receiverPhoneNumber);
        while(CycleNumber != 0){
            String MessageBody = "Sent last "+ CycleNumber +" cycle messages";
            ChattingPageService.getInstance().SentMessageTextEmoj(driver, MessageBody);
            ChattingPageService.getInstance().SentMessageVoice(driver);
            ChattingPageService.getInstance().SentMessagePhoto(driver, ChattingPageService.ImageType.Image,1);
            ChattingPageService.getInstance().SentMessageVideo(driver);
//            ChattingPageService.getInstance().SentMessageCameraPhoto(driver);
//            ChattingPageService.getInstance().SentMessageCameraVideo(driver);
//            ChattingPageService.getInstance().SentMessageLocation(driver);
            ChattingPageService.getInstance().SentMessageNameCard(driver, receiverPhoneNumber, ChattingPageService.NameCardType.Defualt);
            CycleNumber --;
        }
        SearchEntranceBackByElement(driver);
    }
    public void SentMessage(AppiumDriver driver, Entrance MsgEntrance, Type MsgType, String Message, BackType MsgBack,String receiverPhoneNumber){

        //Enterance
        switch (MsgEntrance){
            case Search:
                SentMessageBySerarch(driver, receiverPhoneNumber);
                break;
            case Contacts:
                ContactsPageService.getInstance().FirstLineContactClick(driver);
//                ContactsPageService.getInstance().ClickContactByName(driver,receiverPhoneNumber);
                break;
            case AddButtonSingleChatting:
                AddPageService.getInstance().EnterSingleChattingByAddButton(driver,receiverPhoneNumber);
                break;
            case AddButtonGroupChatting:
//                AddPageService.getInstance().EnterGroupChattingByAddButton(driver,receiverPhoneNumber,"8912");//4429和8912要在通讯录中可以找到
                AddPageService.getInstance().EnterGroupChattingByAddButton(driver,"4429","8912");//4429和8912要在通讯录中可以找到
                break;
            case Chats:
                ChatsPageService.getInstance().LastSessionClick(driver);
                break;
            default :
                break;
        }
        //BuildMessage

        //SentMessage
        switch (MsgType){

            case TextEmoj:
                ChattingPageService.getInstance().SentMessageTextEmoj(driver,Message);
                break;
            case Voice:
                ChattingPageService.getInstance().SentMessageVoice(driver);
                break;
            case Photo:
                ChattingPageService.getInstance().SentMessagePhoto(driver, ChattingPageService.ImageType.Image,1);
                //ChattingPageService.getInstance().SentMessagePhoto(driver,9);
                //ChattingPageService.getInstance().SentMessagePhoto(driver,11);
                break;
            case Video:
                ChattingPageService.getInstance().SentMessageVideo(driver);
                break;
            case CameraPhoto:
                ChattingPageService.getInstance().SentMessageCameraPhoto(driver);
                break;
            case CameraVideo:
//                ChattingPageService.getInstance().SentMessageCameraVideo(driver);
                break;
            case Location_DefaultSend:
//                ChattingPageService.getInstance().SentMessageLocation(driver, ChattingPageService.LocationType.DefaultSend);
                break;
            case Location_SelectSend:
//                ChattingPageService.getInstance().SentMessageLocation(driver, ChattingPageService.LocationType.SearchSend);
                break;
            case Location_SearchSend:
//                ChattingPageService.getInstance().SentMessageLocation(driver, ChattingPageService.LocationType.SearchSend);
                break;
            case Namecard:
                ChattingPageService.getInstance().SentMessageNameCard(driver,"13148307145",ChattingPageService.NameCardType.Defualt);
                break;
            default :
                break;
        }
        //Back
        if(MsgBack== BackType.Element){
            if(MsgEntrance.equals(Entrance.Search)) SearchEntranceBackByElement(driver);
            else ChattingEntranceBackByElement(driver);
        }else if(MsgBack== BackType.KeyCode){
            if(MsgEntrance.equals(Entrance.Search)) SearchEntranceBackByKeyCode(driver);
            else ChattingEntranceBackByKeyCode(driver);
        }
    }
    public void SentMessageBySerarch(AppiumDriver driver, String receiverPhoneNumber) {
        //driver.findElementByAccessibilityId(E00_Main.Search).click();//点击搜索按钮
        driver.findElementByAccessibilityId(E00_Main.Search).click();//点击搜索按钮
        driver.findElementById(E00_Main01_Search.search_src_text).sendKeys(receiverPhoneNumber);//输入文案4429
        driver.findElementById(E00_Main01_Search.contact_layout).click();//点击搜索结果
    }
    public void ChattingEntranceBackByElement(AppiumDriver driver) {
        try{
            appOperation.click(driver, E04_03_SingChattingPage.back);
        }catch (Exception e1){
            try{
                appOperation.click(driver, E04_03_SingChattingPage.back);
            }catch (Exception e2){
                try{
                    appOperation.click(driver, E04_03_SingChattingPage.back);
                }catch (Exception e3){

                }
            }
        }
    }
    public void ChattingEntranceBackByKeyCode(AppiumDriver driver) {
//NeedTodo
//        driver.pressKeyCode(4);//KEYCODE_BACK        返回键     4
        driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
    }
    public void SearchEntranceBackByElement(AppiumDriver driver){
        driver.findElementById(E04_03_SingChattingPage.back).click();//退出聊天页面返回上一级页面
//        appOperation.click(driver,E04_03_SingChattingPage.back,E00_Main01_Search.SearchBack);
        List<AndroidElement> FieldsList = driver.findElementsByClassName(E00_Main01_Search.SearchBack);
        FieldsList.get(0).click();
//        for(int i=1;i<10;i++) System.out.println(i+"SearchBack "+driver.findElementById(E00_Main01_Search.SearchBack).getLocation().toString());//0,75
//        driver.findElementByXPath(E00_Main01_Search.SearchBack).click();//退出聊天页面返回上一级页面
        driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
    }
    public void SearchEntranceBackByKeyCode(AppiumDriver driver) {
//NeedToDo
//        driver.pressKeyCode(4);//KEYCODE_BACK        返回键     4
//        driver.pressKeyCode(4);//KEYCODE_BACK        返回键     4
        driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
    }

}
