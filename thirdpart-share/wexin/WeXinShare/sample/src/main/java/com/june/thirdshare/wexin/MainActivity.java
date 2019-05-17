package com.june.thirdshare.wexin;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.june.thirdshare.CommonShare;
import com.june.thirdshare.CommonShareConfig;
import com.june.thirdshare.ShareInfo;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        CommonShareConfig.setWexin("wxd930ea5d5a258f4f", "1d6d1d57a3dd063b36d917bc0b44d964");


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareInfo shareInfo = new ShareInfo.Builder().setWebpageurl("http://www.qq.com")
                        .setTitle("WebPage Title WebPage Title WebPage Title")
                        .setDescription("WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Description WebPage Descr")
                        .setBimap(BitmapFactory.decodeResource(getResources(), com.june.thirdshare.weixin.R.drawable.share))
                        .build();
                CommonShare commonShare = new CommonShare();
                commonShare.setShareInfo(shareInfo);
                commonShare.showShare(getSupportFragmentManager());
            }
        });
    }
}
