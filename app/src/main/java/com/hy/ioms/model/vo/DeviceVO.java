package com.hy.ioms.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wsw on 2017/4/11.
 */

public class DeviceVO implements Parcelable {
    private Long id;
    private String code;
    private String name;
    private String companyName;
    private String circuitName;
    private String poleName;
    private String projectType;
    private String type;
    private boolean playAble;
    private boolean smsAble;
    private boolean isOnline;
    private int alarmCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public String getPoleName() {
        return poleName;
    }

    public void setPoleName(String poleName) {
        this.poleName = poleName;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPlayAble() {
        return playAble;
    }

    public void setPlayAble(boolean playAble) {
        this.playAble = playAble;
    }

    public boolean isSmsAble() {
        return smsAble;
    }

    public void setSmsAble(boolean smsAble) {
        this.smsAble = smsAble;
    }

    public int getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(int alarmCount) {
        this.alarmCount = alarmCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.code);
        dest.writeString(this.name);
        dest.writeString(this.companyName);
        dest.writeString(this.circuitName);
        dest.writeString(this.poleName);
        dest.writeString(this.projectType);
        dest.writeString(this.type);
        dest.writeByte(this.playAble ? (byte) 1 : (byte) 0);
        dest.writeByte(this.smsAble ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isOnline ? (byte) 1 : (byte) 0);
        dest.writeInt(this.alarmCount);
    }

    public DeviceVO() {
    }

    protected DeviceVO(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.code = in.readString();
        this.name = in.readString();
        this.companyName = in.readString();
        this.circuitName = in.readString();
        this.poleName = in.readString();
        this.projectType = in.readString();
        this.type = in.readString();
        this.playAble = in.readByte() != 0;
        this.smsAble = in.readByte() != 0;
        this.isOnline = in.readByte() != 0;
        this.alarmCount = in.readInt();
    }

    public static final Parcelable.Creator<DeviceVO> CREATOR = new Parcelable.Creator<DeviceVO>() {
        @Override
        public DeviceVO createFromParcel(Parcel source) {
            return new DeviceVO(source);
        }

        @Override
        public DeviceVO[] newArray(int size) {
            return new DeviceVO[size];
        }
    };

    @Override
    public String toString() {
        return "DeviceVO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", circuitName='" + circuitName + '\'' +
                ", poleName='" + poleName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", type='" + type + '\'' +
                ", playAble=" + playAble +
                ", smsAble=" + smsAble +
                ", isOnline=" + isOnline +
                ", alarmCount=" + alarmCount +
                '}';
    }
}
