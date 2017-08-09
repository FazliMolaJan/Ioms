package com.hy.ioms.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wsw on 2017/4/11.
 */

public class PictureVO implements Parcelable {
    private String url;
    private String thumbUrl;
    private String date;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        setThumbUrlFromUrl(this.url);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    private void setThumbUrlFromUrl(String url) {
        this.thumbUrl = url.replace(".jpeg", "-sm.jpeg");
    }

    public PictureVO() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.thumbUrl);
        dest.writeString(this.date);
    }

    protected PictureVO(Parcel in) {
        this.url = in.readString();
        this.thumbUrl = in.readString();
        this.date = in.readString();
    }

    public static final Creator<PictureVO> CREATOR = new Creator<PictureVO>() {
        @Override
        public PictureVO createFromParcel(Parcel source) {
            return new PictureVO(source);
        }

        @Override
        public PictureVO[] newArray(int size) {
            return new PictureVO[size];
        }
    };
}
