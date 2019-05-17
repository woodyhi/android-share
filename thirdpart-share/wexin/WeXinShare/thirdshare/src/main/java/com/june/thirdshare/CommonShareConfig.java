package com.june.thirdshare;

public class CommonShareConfig {

    static String WX_APP_ID;
    static String WX_APP_SECRET;

    public static void setWexin(String appId, String appSecret) {
        WX_APP_ID = appId;
        WX_APP_SECRET = appSecret;
    }

}
