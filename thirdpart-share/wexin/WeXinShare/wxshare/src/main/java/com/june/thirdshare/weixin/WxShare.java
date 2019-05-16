package com.june.thirdshare.weixin;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.june.thirdshare.weixin.type.WebpageShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WxShare {

    private Context context;
    private IWXAPI api;

    public WxShare(Context context) {
        this.context = context;
        api = WXAPIFactory.createWXAPI(context, BuildConfig.WX_APP_ID, true);
    }

    private void share(int scene) {
        new WebpageShare(api).share("http://www.qq.com",
                "WebPage Title WebPage Title WebPage Title",
                "WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Descr",
                BitmapFactory.decodeResource(context.getResources(), R.drawable.share),
                scene);
    }

    public void shareToFriend() {
        share(SendMessageToWX.Req.WXSceneSession);
    }

    public void shareToTimeline() {
        share(SendMessageToWX.Req.WXSceneTimeline);
    }
}
