package com.june.thirdshare;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.june.thirdshare.weixin.WxShare;
import com.woodyhi.dialog.BottomDialogFragment;
import com.woodyhi.dialog.OnViewCreatedListener;

public class CommonShare {

    ShareInfo shareInfo;
    BottomDialogFragment bottomDialogFragment;

    public void setShareInfo(ShareInfo info) {
        this.shareInfo = info;
    }

    public void showShare(FragmentManager fragmentManager) {
        bottomDialogFragment = new BottomDialogFragment();
        bottomDialogFragment.setLayoutResId(R.layout.dialog_fragment_third_share);
        bottomDialogFragment.setOnViewCreatedListener(new OnViewCreatedListener() {
            @Override
            public void onViewCreate(View view) {
                initView(view);
            }
        });
        bottomDialogFragment.show(fragmentManager, BottomDialogFragment.class.getSimpleName());
    }

    private void initView(final View view) {
        view.findViewById(R.id.share_to_friend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WxShare(view.getContext(), CommonShareConfig.WX_APP_ID, CommonShareConfig.WX_APP_SECRET)
                        .shareToFriend(shareInfo.webPageUrl, shareInfo.title, shareInfo.description, shareInfo.thumbBitmap);
                bottomDialogFragment.dismiss();
            }
        });
        view.findViewById(R.id.share_to_moments).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WxShare(view.getContext(), CommonShareConfig.WX_APP_ID, CommonShareConfig.WX_APP_SECRET)
                        .shareToTimeline(shareInfo.webPageUrl, shareInfo.title, shareInfo.description, shareInfo.thumbBitmap);
                bottomDialogFragment.dismiss();
            }
        });
        view.findViewById(R.id.share_to_collect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialogFragment.dismiss();
            }
        });
    }
}
