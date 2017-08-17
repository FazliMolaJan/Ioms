package com.hy.ioms.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

import com.hy.ioms.Config;
import com.hy.ioms.model.Mapper;


/**
 * Created by wsw on 2017/6/27.
 */

public class AlarmFireVO implements Parcelable, Mapper<AlarmDetailVO> {
    private int id;
    private String deviceCode;
    private String poleName;
    private String circuitName;
    private String companyName;
    private String collectionTime;
    private String url;
    private String level;
    private double longitude;
    private double latitude;
    private double distance;
    private long deviceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getPoleName() {
        return poleName;
    }

    public void setPoleName(String poleName) {
        this.poleName = poleName;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public AlarmDetailVO transform() {
        AlarmDetailVO alarmDetailVO = new AlarmDetailVO();
        alarmDetailVO.setCircuitName(this.circuitName);
        alarmDetailVO.setCompanyName(this.companyName);
        alarmDetailVO.setLevel(this.level);
        alarmDetailVO.setDeviceCode(this.deviceCode);
        alarmDetailVO.setLatitude(this.latitude);
        alarmDetailVO.setLongitude(this.longitude);
        alarmDetailVO.setUrl(this.url);
        alarmDetailVO.setId(this.id);
        alarmDetailVO.setDistance(this.distance);
        alarmDetailVO.setDeviceId(this.deviceId);
        alarmDetailVO.setPoleName(this.poleName);
        alarmDetailVO.setCollectionTime(this.collectionTime);
        alarmDetailVO.setType(Config.ALARM_FIRE);
        return alarmDetailVO;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.deviceCode);
        dest.writeString(this.poleName);
        dest.writeString(this.circuitName);
        dest.writeString(this.companyName);
        dest.writeString(this.collectionTime);
        dest.writeString(this.url);
        dest.writeString(this.level);
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.distance);
        dest.writeLong(this.deviceId);
    }

    public AlarmFireVO() {
    }

    protected AlarmFireVO(Parcel in) {
        this.id = in.readInt();
        this.deviceCode = in.readString();
        this.poleName = in.readString();
        this.circuitName = in.readString();
        this.companyName = in.readString();
        this.collectionTime = in.readString();
        this.url = in.readString();
        this.level = in.readString();
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.distance = in.readDouble();
        this.deviceId = in.readLong();
    }

    public static final Creator<AlarmFireVO> CREATOR = new Creator<AlarmFireVO>() {
        @Override
        public AlarmFireVO createFromParcel(Parcel source) {
            return new AlarmFireVO(source);
        }

        @Override
        public AlarmFireVO[] newArray(int size) {
            return new AlarmFireVO[size];
        }
    };
}
