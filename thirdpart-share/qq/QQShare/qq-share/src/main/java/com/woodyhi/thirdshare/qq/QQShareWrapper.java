package com.woodyhi.thirdshare.qq;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class QQShareWrapper {
    private int shareType = QQShare.SHARE_TO_QQ_TYPE_DEFAULT;
    private int mExtarFlag = 0x00;

    Tencent tencent;
    Activity activity;
    ShareInfo shareInfo;

    IUiListener uiListener = new IUiListener() {
        @Override
        public void onCancel() {
            if (shareType != QQShare.SHARE_TO_QQ_TYPE_IMAGE) {
                Toast.makeText(activity, "canceled", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onComplete(Object response) {
            Toast.makeText(activity, response.toString(), Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onError(UiError e) {
            Toast.makeText(activity, "onError: " + e.errorMessage, Toast.LENGTH_SHORT).show();
        }
    };

    public QQShareWrapper(Activity activity, ShareInfo info) {
        this.activity = activity;
        tencent = Tencent.createInstance("222222", activity);
        this.shareInfo = info;
    }

    public void share() {
        final Bundle params = new Bundle();
        if (shareType != QQShare.SHARE_TO_QQ_TYPE_IMAGE) {
            params.putString(QQShare.SHARE_TO_QQ_TITLE, shareInfo.title);
            params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, shareInfo.targetUrl);
            params.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareInfo.summary);
        }
        if (shareType == QQShare.SHARE_TO_QQ_TYPE_IMAGE) {
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, shareInfo.imageUrl);
        } else {
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, shareInfo.imageUrl);
        }
//        params.putString(shareType == QQShare.SHARE_TO_QQ_TYPE_IMAGE ? QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL
//                : QQShare.SHARE_TO_QQ_IMAGE_URL, shareInfo.imageUrl);

        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, shareInfo.appName);
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, shareType);
        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, mExtarFlag);
        if (shareType == QQShare.SHARE_TO_QQ_TYPE_AUDIO) {
            params.putString(QQShare.SHARE_TO_QQ_AUDIO_URL, shareInfo.audioUrl);
        }

        tencent.shareToQQ(activity, params, null);
    }
}
