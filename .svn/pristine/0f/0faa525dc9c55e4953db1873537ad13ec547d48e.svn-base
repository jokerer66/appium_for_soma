package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/3/7.
 */
public class MyData {
    public static int waittime = 20;
    public final static String msgtype_text ="msgtype_text";
    public final static String msgtype_contact ="msgtype_contact";
    public final static String msgtype_picture ="msgtype_picture";
    public final static String msgtype_video ="msgtype_video";
    public final static String msgtype_voice ="msgtype_voice";
    public final static String msgtype_location ="msgtype_location";
    public static String backSameMsg = "backSameMsg";
    public static String backNewMsg = "backNewMsg";

    public static List<String> listclassname = new ArrayList();


    public static String hostip = "127.0.0.1";
    public static String Android_Platform = "Android";
    public static String Ios_Platform = "Ios";
    public static String Automation_Name_Appium = "Appium";
    public static String Automation_Name_XCUITest = "XCUITest";
    public static String Ios_Bundle_id = "com.instanza.BaBa";


    /**
     * Class的add的顺序决定在前台的显示顺序,同时也决定了执行顺序
     * class内部的执行顺序由方法名决定
     * 可以使用@Test  (priority =2) 设定优先级决定执行顺序
     * 没设置优先级的会默认优先级0优先执行,多个class中相同优先级的相同执行
     * @return
     */
    public static List<String> initListClassname(){
        listclassname.clear();
        listclassname.add("com.instanza.soma.test.BeginTestClass");
        listclassname.add("com.instanza.soma.test.LoginTestClass");
        listclassname.add("com.instanza.soma.test.CleanTestClass");
        listclassname.add("com.instanza.soma.test.MainTestClass");
        listclassname.add("com.instanza.soma.test.MomentsTestClass");
        listclassname.add("com.instanza.soma.test.SettingsTestClass");

        return listclassname;
    }

}
