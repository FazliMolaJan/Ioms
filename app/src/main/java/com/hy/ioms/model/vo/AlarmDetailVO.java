package com.hy.ioms.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wsw on 2017/7/13.
 */

public class AlarmDetailVO implements Parcelable {

    private int id;
    private String deviceCode;
    private String poleName;
    private String circuitName;
    private String companyName;
    private String collectionTime;
    private String url;
    private String level;
    private String description;
    private double longitude;
    private double latitude;
    private double distance;
    private long deviceId;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public AlarmDetailVO() {
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
        dest.writeString(this.description);
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.distance);
        dest.writeLong(this.deviceId);
        dest.writeString(this.type);
    }

    protected AlarmDetailVO(Parcel in) {
        this.id = in.readInt();
        this.deviceCode = in.readString();
        this.poleName = in.readString();
        this.circuitName = in.readString();
        this.companyName = in.readString();
        this.collectionTime = in.readString();
        this.url = in.readString();
        this.level = in.readString();
        this.description = in.readString();
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.distance = in.readDouble();
        this.deviceId = in.readLong();
        this.type = in.readString();
    }

    public static final Creator<AlarmDetailVO> CREATOR = new Creator<AlarmDetailVO>() {
        @Override
        public AlarmDetailVO createFromParcel(Parcel source) {
            return new AlarmDetailVO(source);
        }

        @Override
        public AlarmDetailVO[] newArray(int size) {
            return new AlarmDetailVO[size];
        }
    };
}
