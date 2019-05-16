package com.june.thirdshare.weixin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;

import com.june.thirdshare.weixin.type.WebpageShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WxShare {

    public static String APP_ID;
    public static String APP_SECRET;

    private Context context;
    private IWXAPI api;

    public WxShare(Context context) {
        this.context = context;
        if (APP_ID == null) APP_ID = getMetaDataFromApp(context, "WEXIN_APP_ID");
        if (APP_SECRET == null) APP_SECRET = getMetaDataFromApp(context, "WEXIN_APP_SECRET");
        api = WXAPIFactory.createWXAPI(context, APP_ID, true);
    }

    //获取value
    private String getMetaDataFromApp(Context context, String key) {
        String value = null;
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
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
