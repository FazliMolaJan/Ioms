package com.hy.ioms.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

import com.hy.ioms.Config;
import com.hy.ioms.model.Mapper;


/**
 * Created by wsw on 2017/7/13.
 */

public class AlarmBreakVO implements Parcelable, Mapper<AlarmDetailVO> {
    private int id;
    private Long deviceId;
    private String deviceCode;
    private String poleName;
    private String circuitName;
    private String companyName;
    private String collectionTime;
    private String url;
    private String level;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
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

    public AlarmBreakVO() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeValue(this.deviceId);
        dest.writeString(this.deviceCode);
        dest.writeString(this.poleName);
        dest.writeString(this.circuitName);
        dest.writeString(this.companyName);
        dest.writeString(this.collectionTime);
        dest.writeString(this.url);
        dest.writeString(this.level);
        dest.writeString(this.description);
    }

    protected AlarmBreakVO(Parcel in) {
        this.id = in.readInt();
        this.deviceId = (Long) in.readValue(Long.class.getClassLoader());
        this.deviceCode = in.readString();
        this.poleName = in.readString();
        this.circuitName = in.readString();
        this.companyName = in.readString();
        this.collectionTime = in.readString();
        this.url = in.readString();
        this.level = in.readString();
        this.description = in.readString();
    }

    public static final Creator<AlarmBreakVO> CREATOR = new Creator<AlarmBreakVO>() {
        @Override
        public AlarmBreakVO createFromParcel(Parcel source) {
            return new AlarmBreakVO(source);
        }

        @Override
        public AlarmBreakVO[] newArray(int size) {
            return new AlarmBreakVO[size];
        }
    };

    @Override
    public AlarmDetailVO transform() {
        AlarmDetailVO alarmDetailVO = new AlarmDetailVO();
        alarmDetailVO.setId(this.id);
        alarmDetailVO.setDeviceId(this.deviceId);
        alarmDetailVO.setDeviceCode(this.deviceCode);
        alarmDetailVO.setPoleName(this.poleName);
        alarmDetailVO.setCircuitName(this.circuitName);
        alarmDetailVO.setCompanyName(this.companyName);
        alarmDetailVO.setCollectionTime(this.collectionTime);
        alarmDetailVO.setUrl(this.url);
        alarmDetailVO.setLevel(this.level);
        alarmDetailVO.setDescription(this.description);
        alarmDetailVO.setType(Config.ALARM_BREAK);
        return alarmDetailVO;
    }
}
