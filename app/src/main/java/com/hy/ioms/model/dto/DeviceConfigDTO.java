package com.hy.ioms.model.dto;

/**
 * ${description}
 * Created by wsw on 2017/5/9.
 */

public class DeviceConfigDTO {

    private Integer deviceId;

    private String deviceCode;

    private String baseInfo;

    private String presetConfig;

    private String tourConfig;

    private String videoConfig;

    private String thresholdConfig;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getPresetConfig() {
        return presetConfig;
    }

    public void setPresetConfig(String presetConfig) {
        this.presetConfig = presetConfig;
    }

    public String getTourConfig() {
        return tourConfig;
    }

    public void setTourConfig(String tourConfig) {
        this.tourConfig = tourConfig;
    }

    public String getVideoConfig() {
        return videoConfig;
    }

    public void setVideoConfig(String videoConfig) {
        this.videoConfig = videoConfig;
    }

    public String getThresholdConfig() {
        return thresholdConfig;
    }

    public void setThresholdConfig(String thresholdConfig) {
        this.thresholdConfig = thresholdConfig;
    }
}
