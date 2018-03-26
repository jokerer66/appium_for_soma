package utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by catty on 2017/3/1.
 */
public class CamelCaseUtils {

    // 将驼峰风格替换为下划线风格
    public static String toUnderline(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() + i, matcher.end() + i, "_" + matcher.group().toLowerCase());
        }
        if (builder.charAt(0) == '_') builder.deleteCharAt(0);
        return builder.toString();
    }

}
