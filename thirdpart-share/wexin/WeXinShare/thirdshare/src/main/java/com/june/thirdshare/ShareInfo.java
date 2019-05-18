package com.june.thirdshare;

import android.graphics.Bitmap;

public class ShareInfo {
    String title;
    String description;
    Bitmap thumbBitmap;
    String webPageUrl;

    public static class Builder {
        private ShareInfo shareInfo;

        public Builder() {
            shareInfo = new ShareInfo();
        }

        public Builder setWebpageurl(String url) {
            shareInfo.webPageUrl = url;
            return this;
        }

        public Builder setTitle(String title) {
            shareInfo.title = title;
            return this;
        }

        public Builder setDescription(String desc) {
            shareInfo.description = desc;
            return this;
        }

        public Builder setThumbBimap(Bitmap bitmap) {
            shareInfo.thumbBitmap = bitmap;
            return this;
        }

        public ShareInfo build() {
            return shareInfo;
        }
    }
}
