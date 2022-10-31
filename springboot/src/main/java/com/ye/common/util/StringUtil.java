package com.ye.common.util;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * null 和 "" 均返回 true
     */
    public static Boolean isEmpty(String str){
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串是否非空
     * null 和 "" 均返回 true
     */
    public static Boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

}
