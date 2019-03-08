package com.hmz.administrator.cf.utils;

import java.util.regex.Pattern;


public class MyUtils {
    /**
     *
     * 判断是否为双精度小数
     *
     * @param str
     * @return
     */
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }
}
