package com.instanza.soma.resources;

public class E00_02_ActivatePhoneVerification {
    public static String RegionSelect = "com.instanza.baba:id/select_country_text";
    public static String RegionSelect_xpath = "xpath///XCUIElementTypeStaticText[@name=\"Confirm your country code and enter your phone number.\"]/../XCUIElementTypeButton[1]";
    public static String search_box = "com.instanza.baba:id/search_box";

    public static String edittext_phone = "com.instanza.baba:id/edittext_phone";
    public static String NextButton = "com.instanza.baba:id/next";
    public static String NextButton_nspredicate = "name = 'Next'";
    public static String ReEnterNumber_nspredicate = "name like 'Please re-enter your phone number*'";

    public static String Approve = "text/text(\"Approve\")";
    public static String Approve_nspredicate = "name = 'Approve'";
    public static String Reenternumber = "Please re-enter your phone number.";
    public static String tryverifynumber = "text/text(\"Please try verifying your number in SOMA.\")";
    public static String tryagainButton_nspredicate = "xpath///XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeButton[1]";
    public static String tryagain_text = "Try Again";
    //verify
    public static String Verification_text_back_Key = "//android.view.View[contains(@resource-id , 'tool_bar')]/android.widget.TextView[1]";
    public static String Verification_text_back_Value = "Verification";
    public static String Confirm_text_Key = "//android.view.View[contains(@resource-id , 'main_layout')]/android.widget.TextView[1]";
    public static String Confirm_text_Value = "Confirm your country code and enter your phone number.";
    public static String ContinueButton = "Contacts Access Continue";//Ios Only

    //NeedToDo
    public static String United_States_xpath = "xpath///android.widget.TextView[@text='United States']/..";

}
