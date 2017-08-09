package com.hy.ioms.model.dto;

import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.PictureVO;
import com.hy.ioms.utils.DateUtils;

/**
 * ${description}
 * Created by wsw on 2017/4/10.
 */

public class ManualPictureDTO implements Mapper<PictureVO>{


    /**
     * id : 2
     * deviceId : 1
     * url : http://www4.ioms.com.cn:9090/static/\HY_OLMS_L_0000001\PicCapture\2017-4\20170417-152636.jpeg
     * collectionTime : 2017-04-17T15:26:36+08:00
     * deviceCode : HY_OLMS_L_0000001
     * sessionId : 1ad3300a-3e95-40a5-aabd-de19d9cd9ee6
     */

    private int id;
    private int deviceId;
    private String url;
    private String collectionTime;
    private String deviceCode;
    private String sessionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    @Override
    public PictureVO transform() {
        PictureVO pictureVO = new PictureVO();
        pictureVO.setDate(DateUtils.getTime(this.collectionTime));
        pictureVO.setUrl(this.url);
        return pictureVO;
    }

    @Override
    public String toString() {
        return "ManualPictureDTO{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", url='" + url + '\'' +
                ", collectionTime='" + collectionTime + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
