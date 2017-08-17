package com.hy.ioms.model.dto;

import android.os.Parcel;
import android.os.Parcelable;

import javax.inject.Inject;

/**
 * ${description}
 * Created by wsw on 2017/8/16.
 */

public class FilterDTO implements Parcelable {
    private Long companyId = 0L;
    private Long circuitId = 0L;
    private Long poleId = 0L;
    private Long deviceId = 0L;
    private String startTime;
    private String endTime;

    @Inject
    public FilterDTO() {}

    public FilterDTO(Long companyId, Long circuitId, Long poleId, Long deviceId) {
        this.companyId = companyId;
        this.circuitId = circuitId;
        this.poleId = poleId;
        this.deviceId = deviceId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(Long circuitId) {
        this.circuitId = circuitId;
    }

    public Long getPoleId() {
        return poleId;
    }

    public void setPoleId(Long poleId) {
        this.poleId = poleId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.companyId);
        dest.writeValue(this.circuitId);
        dest.writeValue(this.poleId);
        dest.writeValue(this.deviceId);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
    }

    protected FilterDTO(Parcel in) {
        this.companyId = (Long) in.readValue(Long.class.getClassLoader());
        this.circuitId = (Long) in.readValue(Long.class.getClassLoader());
        this.poleId = (Long) in.readValue(Long.class.getClassLoader());
        this.deviceId = (Long) in.readValue(Long.class.getClassLoader());
        this.startTime = in.readString();
        this.endTime = in.readString();
    }

    public static final Parcelable.Creator<FilterDTO> CREATOR = new Parcelable.Creator<FilterDTO>() {
        @Override
        public FilterDTO createFromParcel(Parcel source) {
            return new FilterDTO(source);
        }

        @Override
        public FilterDTO[] newArray(int size) {
            return new FilterDTO[size];
        }
    };

    @Override
    public String toString() {
        return "FilterDTO{" +
                "companyId=" + companyId +
                ", circuitId=" + circuitId +
                ", poleId=" + poleId +
                ", deviceId=" + deviceId +
                '}';
    }

}
