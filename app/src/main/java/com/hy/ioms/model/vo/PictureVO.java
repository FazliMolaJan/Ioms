package com.hy.ioms.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wsw on 2017/4/11.
 */

public class PictureVO{
    private String url;
    private String thumbUrl;
    private String date;
    private String deviceCode;

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

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public PictureVO() {
    }


}
