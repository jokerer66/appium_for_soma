package com.instanza.soma.resources;

public class E05_03_Account {

    public static final String action_bar_root  = "com.instanza.baba:id/action_bar_root";
    public static final String content  = "android:id/content";
    public static final String drawer_layout  = "com.instanza.baba:id/drawer_layout";
    public static final String frame  = "com.instanza.baba:id/frame";
    public static final String whole_layout  = "com.instanza.baba:id/whole_layout";
    public static final String tool_bar  = "com.instanza.baba:id/tool_bar";
    public static final String action_bar_root_view  = "com.instanza.baba:id/action_bar_root_view";
    public static final String row_MyNumber_text1  = "com.instanza.baba:id/row_MyNumber_text1";
    public static final String row_MyNumber_text2  = "com.instanza.baba:id/row_MyNumber_text2";
//    public static final String row_MyNumber_xpath  = "xpath///XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]";
    public static final String row_MyNumber_xpath  = "xpath///XCUIElementTypeStaticText[@name=\"My Number\"]/../XCUIElementTypeStaticText[2]";
    public static final String row_privacy_text1  = "com.instanza.baba:id/row_privacy_text1";
    public static final String row_deleteaccount_nspredicate  = "name = 'Delete My Account'";
    public static final String row_deleteaccount_text1  = "com.instanza.baba:id/row_deleteaccount_text1";
    public static final String edittext_phone  = "com.instanza.baba:id/edittext_phone";//删除账号的号码输入框
    public static final String delete_account_button  = "com.instanza.baba:id/delete_account_button";//删除确认键
    public static final String Delete  = "text(\"Delete\")";
    public static final String Cancel  = "text(\"Cancel\")";
    public static final String actionbar_line  = "com.instanza.baba:id/actionbar_line";
    public static final String statusBarBackground  = "android:id/statusBarBackground";
    public static final String navigationBarBackground  = "android:id/navigationBarBackground";

    //Account页面的内容
    public static final String row_MyNumber = "com.instanza.baba:id/row_MyNumber";
    public static final String my_number = "My Number";
    public static final String row_privacy = "com.instanza.baba:id/row_privacy";
    public static final String privacy = "Privacy";
    public static final String row_deleteaccount = "com.instanza.baba:id/row_deleteaccount";
    public static final String delete_my_account = "Delete My Account";

    //Privacy页面的内容--who can see my personal info
    public static final String row_lastseen_label = "com.instanza.baba:id/row_lastseen_label";
    public static final String row_lastseen_info = "Who can see my personal info";
    public static final String row_lastseen = "com.instanza.baba:id/row_lastseen";
    public static final String row_lastseen_text1 = "com.instanza.baba:id/row_lastseen_text1";
    public static final String row_lastseen_text2 = "com.instanza.baba:id/row_lastseen_text2";
    public static final String row_lastseen_comment = "com.instanza.baba:id/row_lastseen_comment";
    public static final String comment = "If you don’t share your Last Seen, you won’t be able to see other people’s Last Seen.";
    public static final String alertTitle = "com.instanza.baba:id/alertTitle";
    public static final String last_seen = "Last seen";
    public static final String everyone_id = "android:id/text1";
    public static final String everyone = "Everyone";
    public static final String mycontacts = "My contacts";
    public static final String nobody = "Nobody";
    public static final String returnBack = "classname/android.widget.ImageButton";

    //Privacy页面的内容--Messaging
    public static final String row_blocked_contacts_label = "com.instanza.baba:id/row_blocked_contacts_label";
    public static final String messaging = "Messaging";
    public static final String row_blocked_contacts_text1 = "com.instanza.baba:id/row_blocked_contacts_text1";
    public static final String Blocked = "Blocked contacts";
    public static final String row_blocked_contacts_comment = "com.instanza.baba:id/row_blocked_contacts_comment";
    public static final String blocked_contacts_comment = "Blocked contacts won’t be able to call you or send you messages.";
    public static final String row_blocked_contacts = "com.instanza.baba:id/row_blocked_contacts";

    //Message点击block contacts页面
    public static final String avatar_icon = "AccessibilityId/Settings";
    public static final String block_tool_bar = "com.instanza.baba:id/tool_bar";
    public static final String contact_layout = "com.instanza.baba:id/contact_layout";
    public static final String Cancel_id = "android:id/button2";
    public static final String Confirm_id = "android:id/button1";

    //Privacy页面的内容--Read status
    public static final String row_readstatus_label = "com.instanza.baba:id/row_readstatus_label";//Read status
    public static final String read_status = "Read status";
    public static final String row_readstatus_text1 = "com.instanza.baba:id/row_readstatus_text1";//Read status
    public static final String row_readstatus = "com.instanza.baba:id/row_readstatus";
    public static final String row_readstatus_switch = "com.instanza.baba:id/row_readstatus_switch";//框
    public static final String row_readstatus_comment = "com.instanza.baba:id/row_readstatus_comment";
    public static final String row_readstatus_info = "You will not be able to see read status for the messages you send to other people if you turn off read status.";
}