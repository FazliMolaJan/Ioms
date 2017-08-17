package com.hy.ioms.model.dto;

import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.AlarmBreakVO;
import com.hy.ioms.utils.DateUtils;

/**
 * Created by wsw on 2017/7/13.
 */

public class AlarmBreakDTO implements Mapper<AlarmBreakVO> {
    private Long id;
    private String deviceCode;
    private String collectionTime;
    private String handledTime;
    private Boolean adminHandled;
    private Boolean userHandled;
    private String breakPicPath;
    private String breakVidPath;
    private Long zoneId;
    private String level;
    private Float distance;
    private String cameraNumber;
    private Float longitude;
    private Float latitude;
    private Boolean hidden;
    private String remark;
    private Long deviceId;

    private String poleCode;//杆塔编号
    private String circuitCode;//线路编号
    private String companyName;//公司名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getHandledTime() {
        return handledTime;
    }

    public void setHandledTime(String handledTime) {
        this.handledTime = handledTime;
    }

    public Boolean getAdminHandled() {
        return adminHandled;
    }

    public void setAdminHandled(Boolean adminHandled) {
        this.adminHandled = adminHandled;
    }

    public Boolean getUserHandled() {
        return userHandled;
    }

    public void setUserHandled(Boolean userHandled) {
        this.userHandled = userHandled;
    }

    public String getBreakPicPath() {
        return breakPicPath;
    }

    public void setBreakPicPath(String breakPicPath) {
        this.breakPicPath = breakPicPath;
    }

    public String getBreakVidPath() {
        return breakVidPath;
    }

    public void setBreakVidPath(String breakVidPath) {
        this.breakVidPath = breakVidPath;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getCameraNumber() {
        return cameraNumber;
    }

    public void setCameraNumber(String cameraNumber) {
        this.cameraNumber = cameraNumber;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getPoleCode() {
        return poleCode;
    }

    public void setPoleCode(String poleCode) {
        this.poleCode = poleCode;
    }

    public String getCircuitCode() {
        return circuitCode;
    }

    public void setCircuitCode(String circuitCode) {
        this.circuitCode = circuitCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public AlarmBreakVO transform() {
        AlarmBreakVO alarmBreakVO = new AlarmBreakVO();
        alarmBreakVO.setDeviceCode(this.deviceCode);
        alarmBreakVO.setCollectionTime(DateUtils.getTime(this.collectionTime));
        alarmBreakVO.setLevel(this.level);
        alarmBreakVO.setUrl(this.breakPicPath);
        alarmBreakVO.setDescription(this.remark);
        return alarmBreakVO;
    }
}
