package com.hy.ioms.model.dto;


import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.AlarmVO;
import com.hy.ioms.utils.DateUtils;

import java.util.Date;

/**
 * Created by wsw on 2017/6/27.
 */
@SuppressWarnings("unused")
public class AlarmFireDTO implements Mapper<AlarmVO> {

    /**
     * id : 938
     * deviceCode : HY_OLMS_111111112
     * collectionTime : 2017-06-29T07:41:18.000+0000
     * adminHandledTime : null
     * userHandledTime : null
     * deliver : false
     * adminHandled : false
     * visiblePicPath : http://www7.ioms.com.cn:9090/static/accessPicture\HY_OLMS_111111112\WildFireAlarm\2017-6\20170629-154229.jpeg
     * infraredPicPath : http://www7.ioms.com.cn:9090/static/accessPicture\HY_OLMS_111111112\WildFireAlarm\2017-6\20170629-154239.jpeg
     * visibleVidPath : null
     * infraredVidPath : null
     * level : 2
     * ptzAngleX : 130.0
     * ptzAngleY : -20.2
     * distance : 1502.0
     * cameraNumber : Emd.Service.WildFire.E0
     * longitude : 102.29
     * latitude : 27.92
     * hidden : false
     * blowingLine : null
     * remark : null
     * deviceId : 3
     * poleCode : FireTest01
     * circuitCode : FireTest01
     * companyName : 四川在线测试部
     */

    private int id;
    private String deviceCode;
    private Date collectionTime;
    private String adminHandledTime;
    private String userHandledTime;
    private boolean deliver;
    private boolean adminHandled;
    private String visiblePicPath;
    private String infraredPicPath;
    private String visibleVidPath;
    private String infraredVidPath;
    private String level;
    private double ptzAngleX;
    private double ptzAngleY;
    private double distance;
    private String cameraNumber;
    private double longitude;
    private double latitude;
    private boolean hidden;
    private boolean blowingLine;
    private String remark;
    private int deviceId;
    private String poleCode;
    private String circuitCode;
    private String companyName;

    public String getAdminHandledTime() {
        return adminHandledTime;
    }

    public void setAdminHandledTime(String adminHandledTime) {
        this.adminHandledTime = adminHandledTime;
    }

    public String getUserHandledTime() {
        return userHandledTime;
    }

    public void setUserHandledTime(String userHandledTime) {
        this.userHandledTime = userHandledTime;
    }

    public String getVisibleVidPath() {
        return visibleVidPath;
    }

    public void setVisibleVidPath(String visibleVidPath) {
        this.visibleVidPath = visibleVidPath;
    }

    public String getInfraredVidPath() {
        return infraredVidPath;
    }

    public void setInfraredVidPath(String infraredVidPath) {
        this.infraredVidPath = infraredVidPath;
    }

    public boolean isBlowingLine() {
        return blowingLine;
    }

    public void setBlowingLine(boolean blowingLine) {
        this.blowingLine = blowingLine;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public boolean isDeliver() {
        return deliver;
    }

    public void setDeliver(boolean deliver) {
        this.deliver = deliver;
    }

    public boolean isAdminHandled() {
        return adminHandled;
    }

    public void setAdminHandled(boolean adminHandled) {
        this.adminHandled = adminHandled;
    }

    public String getVisiblePicPath() {
        return visiblePicPath;
    }

    public void setVisiblePicPath(String visiblePicPath) {
        this.visiblePicPath = visiblePicPath;
    }

    public String getInfraredPicPath() {
        return infraredPicPath;
    }

    public void setInfraredPicPath(String infraredPicPath) {
        this.infraredPicPath = infraredPicPath;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getPtzAngleX() {
        return ptzAngleX;
    }

    public void setPtzAngleX(double ptzAngleX) {
        this.ptzAngleX = ptzAngleX;
    }

    public double getPtzAngleY() {
        return ptzAngleY;
    }

    public void setPtzAngleY(double ptzAngleY) {
        this.ptzAngleY = ptzAngleY;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getCameraNumber() {
        return cameraNumber;
    }

    public void setCameraNumber(String cameraNumber) {
        this.cameraNumber = cameraNumber;
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

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
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
    public AlarmVO transform() {
        AlarmVO alarmFireVO = new AlarmVO();
        alarmFireVO.setDeviceCode(this.deviceCode);
        alarmFireVO.setCollectionTime(DateUtils.getTime(this.collectionTime));
        alarmFireVO.setLatitude(this.latitude);
        alarmFireVO.setLongitude(this.longitude);
        alarmFireVO.setLevel(this.level);
        alarmFireVO.setUrl(this.visiblePicPath);
        alarmFireVO.setDistance(this.distance);
        alarmFireVO.setCompanyName(this.companyName);
        alarmFireVO.setCircuitName(this.circuitCode);
        alarmFireVO.setPoleName(this.poleCode);
        alarmFireVO.setType(AlarmVO.FIRE);
        return alarmFireVO;
    }
}
