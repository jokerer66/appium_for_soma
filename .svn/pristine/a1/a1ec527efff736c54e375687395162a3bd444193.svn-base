package com.instanza.soma.Service.Setting;

import java.util.Random;

/**
 * Created by catty on 2017/7/26.
 * For Settings public methods
 */
public class SettingsTools {

    /**
     * 工具方法
     * 生成一个随机的字符串，保证两次之间的字符串不一致
     *
     * @param length 指定生成字符串的长度
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
