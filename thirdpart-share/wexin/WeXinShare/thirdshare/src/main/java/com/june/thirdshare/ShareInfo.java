package com.june.thirdshare;

import android.graphics.Bitmap;

public class ShareInfo {
    String webPageUrl;
    String title;
    String description;
    Bitmap bitmap;

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

        public Builder setBimap(Bitmap bitmap) {
            shareInfo.bitmap = bitmap;
            return this;
        }

        public ShareInfo build() {
            return shareInfo;
        }
    }
}
