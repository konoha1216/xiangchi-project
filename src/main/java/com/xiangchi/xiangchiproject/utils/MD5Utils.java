package com.xiangchi.xiangchiproject.utils;

import com.xiangchi.xiangchiproject.common.Constant;
import com.xiangchi.xiangchiproject.common.XiangchiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class MD5Utils {

    public static String getMD5Str(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            throw new XiangchiException("md5算法加密失败");
        }
        return Base64.encodeBase64String(md5.digest((str + Constant.SALT).getBytes()));
    }

    public static void main(String[] args) {
        System.out.println(getMD5Str("Wyp19720326"));
    }
}
