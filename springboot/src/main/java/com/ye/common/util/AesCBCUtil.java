package com.ye.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理 对原始数据进行AES加密后，在进行Base64编码转化
 */
public class AesCBCUtil {

    private static String encrypt(byte[] sSrc, String sKey) throws Exception {
        if (sKey == null || sSrc == null) {
            return null;
        }
        return byte2hex(encryptByte(sSrc, sKey)).toLowerCase();
    }

    // 加密
    public static String encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null || sSrc == null) {
            return null;
        }
        return encrypt(sSrc.getBytes(), sKey);
    }

    private static byte[] encryptByte(byte[] sSrc, String sKey) throws Exception {
        if (sKey == null || sSrc == null) {
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            return null;
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(sKey.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        return cipher.doFinal(sSrc);
    }

    private static String decrypt(byte[] sSrc, String sKey) throws Exception {
        if (sKey == null || sSrc == null) {
            return null;
        }
        return new String(decryptByte(sSrc, sKey));
    }

    private static byte[] decryptByte(byte[] sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null || sSrc == null) {
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                return null;
            }
            byte[] raw = sKey.getBytes();// "ASCII"
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(sKey.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            try {
                return cipher.doFinal(sSrc);
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    // 解密
    public static String decrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null || sSrc == null) {
            return null;
        }
        return decrypt(hex2byte(sSrc), sKey);
    }

    private static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return b;
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    public static void main(String[] arg) {
        try {
            // 需要加密的字串
            String cSrc = "2000";
            String sKey = "d6797b0f95f8ead1";
            System.out.println("加密前的字串是：" + cSrc);
            // 加密
            String enString = encrypt(cSrc, sKey);
            System.out.println("加密后的字串是：" + enString);
            // 解密
            String DeString = decrypt(enString, sKey);
            System.out.println("解密后的字串是：" + DeString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}