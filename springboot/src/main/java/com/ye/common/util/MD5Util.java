package com.ye.common.util;

import org.springframework.util.DigestUtils;

/**
 * MD5 加密工具类
 */
public class MD5Util {

    /** MD5 加密 */
    public static String encode(String str){
        if (str == null || "".equals(str)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

}
