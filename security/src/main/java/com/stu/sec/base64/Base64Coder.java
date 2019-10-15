package com.stu.sec.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Coder {

    public final static String ENCODING = "UTF-8";
    /**
     * Base64编码
     *
     * @param data
     * @return
     */
    public static String encode(String data) throws UnsupportedEncodingException {
        return String.valueOf(Base64.getEncoder().encodeToString(data.getBytes(ENCODING)));
    }

    /**
     * Base64解码
     *
     * @param data
     * @return
     */
    public static String decode(String data) throws UnsupportedEncodingException {
        return new String(Base64.getDecoder().decode(data),ENCODING);
    }
}
