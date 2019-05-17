package com.june.thirdshare.weixin;

import android.content.Context;
import android.graphics.Bitmap;

import com.june.thirdshare.weixin.type.WebpageShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WxShare {

    public static String APP_ID;
    public static String APP_SECRET;

    private Context context;
    private IWXAPI api;

    public WxShare(Context context, String appId, String appSecret) {
        this.context = context;
        APP_ID = appId;
        APP_SECRET = appSecret;
        api = WXAPIFactory.createWXAPI(context, APP_ID, true);
    }

    private void share(String webpageUrl, String title, String description, Bitmap thumbBmp, int scene) {
        new WebpageShare(api).share(webpageUrl, title, description, thumbBmp, scene);
    }

    public void shareToFriend(String webpageUrl, String title, String description, Bitmap thumbBmp) {
        share(webpageUrl, title, description, thumbBmp, SendMessageToWX.Req.WXSceneSession);
    }

    public void shareToTimeline(String webpageUrl, String title, String description, Bitmap thumbBmp) {
        share(webpageUrl, title, description, thumbBmp, SendMessageToWX.Req.WXSceneTimeline);
    }

    public void shareToCollect(String webpageUrl, String title, String description, Bitmap thumbBmp) {
        share(webpageUrl, title, description, thumbBmp, SendMessageToWX.Req.WXSceneFavorite);
    }
}
