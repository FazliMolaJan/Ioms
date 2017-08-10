package com.hy.ioms.model.dto;

import java.util.List;

/**
 * 视频配置DTO
 * Created by wsw on 2017/6/1.
 */
@SuppressWarnings("unused")
public class VideoConfigDTO {

    /**
     * Channel : 1
     * Nic : Emd.Device.Nic.E1
     * Camera : Emd.Device.Camera.E0
     * Protocol : tcp
     * presets : [1,2,3]
     */

    private int Channel;
    private String Nic;
    private String Camera;
    private String Protocol;
    private List<Integer> presets;

    public int getChannel() {
        return Channel;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String Nic) {
        this.Nic = Nic;
    }

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String Camera) {
        this.Camera = Camera;
    }

    public String getProtocol() {
        return Protocol;
    }

    public void setProtocol(String Protocol) {
        this.Protocol = Protocol;
    }

    public List<Integer> getPresets() {
        return presets;
    }

    public void setPresets(List<Integer> presets) {
        this.presets = presets;
    }

    @Override
    public String toString() {
        return "VideoConfigDTO{" +
                "Channel=" + Channel +
                ", Nic='" + Nic + '\'' +
                ", Camera='" + Camera + '\'' +
                ", Protocol='" + Protocol + '\'' +
                ", presets=" + presets +
                '}';
    }
}
