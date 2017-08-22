package com.hy.ioms.model.vo;

/**
 * Created by wsw on 2017/8/22.
 */

public class AlarmVO {
    public static final int FIRE = 0;
    public static final int BREAK = 1;

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
    private String description;
    private int type;

    public static int getFIRE() {
        return FIRE;
    }

    public static int getBREAK() {
        return BREAK;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AlarmVO{" +
                "id=" + id +
                ", deviceCode='" + deviceCode + '\'' +
                ", poleName='" + poleName + '\'' +
                ", circuitName='" + circuitName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", collectionTime='" + collectionTime + '\'' +
                ", url='" + url + '\'' +
                ", level='" + level + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", distance=" + distance +
                ", deviceId=" + deviceId +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
