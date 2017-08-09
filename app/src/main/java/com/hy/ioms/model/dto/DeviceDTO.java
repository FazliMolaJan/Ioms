package com.hy.ioms.model.dto;

import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.DeviceVO;

/**
 * Created by wsw on 2017/4/13.
 */

public class DeviceDTO implements Mapper<DeviceVO> {
    private Long id;
    private String code;
    private String name;
    private String type;
    private Float angleNorth;
    private String projectType;
    private String remark;
    private boolean hidden;
    private boolean playable;
    private boolean smsable;
    private boolean active;
    private PoleDTO pole;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getAngleNorth() {
        return angleNorth;
    }

    public void setAngleNorth(Float angleNorth) {
        this.angleNorth = angleNorth;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isPlayAble() {
        return playable;
    }

    public void setPlayAble(boolean playAble) {
        this.playable = playAble;
    }

    public boolean isSmsAble() {
        return smsable;
    }

    public void setSmsAble(boolean smsAble) {
        this.smsable = smsAble;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PoleDTO getPole() {
        return pole;
    }

    public void setPole(PoleDTO pole) {
        this.pole = pole;
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", angleNorth=" + angleNorth +
                ", projectType='" + projectType + '\'' +
                ", remark='" + remark + '\'' +
                ", hidden=" + hidden +
                ", playAble=" + playable +
                ", smsAble=" + smsable +
                ", active=" + active +
                '}';
    }

    @Override
    public DeviceVO transform() {
        DeviceVO deviceVO = new DeviceVO();
        deviceVO.setCode(this.code);
        deviceVO.setId(this.id);
        deviceVO.setName(this.name);
        deviceVO.setCompanyName(this.getPole().getCircuit().getCompany().getName());
        deviceVO.setCircuitName(this.getPole().getCircuit().getName());
        deviceVO.setPoleName(this.getPole().getName());
        deviceVO.setSmsAble(this.smsable);
        deviceVO.setPlayAble(this.playable);
        deviceVO.setProjectType(this.projectType);
        deviceVO.setType(this.type);
        return deviceVO;
    }

}
