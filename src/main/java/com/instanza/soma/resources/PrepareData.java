package com.instanza.soma.resources;

/**
 * Created by apple on 2017/4/7.
 */
public class PrepareData {
    //登陆用手机号码
    public static String[] LoginPhoneNumber = new String[]{"3174973959","9013004438"};
    //登陆用国家名称
    public static String[] LoginCountry = new String[]{"United States","United States"};
    //登陆用用户名
    public static String[] LoginUsername = new String[]{"3959","4438"};

    private static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    /**
     * 返回手机号码
     */
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    public static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;
    }

    
}
