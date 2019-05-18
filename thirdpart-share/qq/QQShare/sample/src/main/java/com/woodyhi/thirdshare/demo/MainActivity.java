package com.woodyhi.thirdshare.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.woodyhi.thirdshare.qq.QQShareWrapper;
import com.woodyhi.thirdshare.qq.ShareInfo;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareInfo shareInfo = new ShareInfo();
                shareInfo.title = "分享标题";
                shareInfo.summary = "摘要内容QQ分享 摘要内容QQ分享 摘要内容QQ分享";
                shareInfo.targetUrl = "http://www.qq.com";
                shareInfo.imageUrl = "http://inews.gtimg.com/newsapp_bt/0/876781763/1000";
                shareInfo.appName = "测试分享app";
                new QQShareWrapper(MainActivity.this, shareInfo).share();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_QQ_SHARE) {
            Tencent.onActivityResultData(requestCode, resultCode, data, uiListener);
        }
    }


    IUiListener uiListener = new IUiListener() {
        @Override
        public void onCancel() {
//            if (shareType != QQShare.SHARE_TO_QQ_TYPE_IMAGE) {
                Toast.makeText(MainActivity.this, "canceled", Toast.LENGTH_SHORT).show();
//            }
        }
        @Override
        public void onComplete(Object response) {
            Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onError(UiError e) {
            Toast.makeText(MainActivity.this, "onError: " + e.errorMessage, Toast.LENGTH_SHORT).show();
        }
    };

}
