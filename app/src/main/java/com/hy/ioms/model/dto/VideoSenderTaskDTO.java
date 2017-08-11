package com.hy.ioms.model.dto;

import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.VideoStatusVO;

/**
 * 视屏播放任务DTO
 * Created by wsw on 2017/6/1.
 */
@SuppressWarnings("unused")
public class VideoSenderTaskDTO implements Mapper<VideoStatusVO> {

    /**
     * id : 7
     * channel : 1
     * url : rtsp://www.ioms.com.cn:554/EmdRealTimeVideo-HY_OLMS_000000701-Emd.Service.VideoSender.E0-7.sdp
     * stat : Ready
     * nic : Emd.Device.Nic.E1
     * camera : Emd.Device.Camera.E0
     * serverPort : 554
     * serverAddr : www.ioms.com.cn
     * msg :
     */

    private int id;
    private int channel;
    private String url;
    private String stat;
    private String nic;
    private String camera;
    private int serverPort;
    private String serverAddr;
    private String msg;

    public VideoSenderTaskDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public VideoStatusVO transform() {
        VideoStatusVO videoStatusVO = new VideoStatusVO();
        videoStatusVO.setId(this.id);
        videoStatusVO.setChannel(this.channel);
        videoStatusVO.setUrl(this.url);
        videoStatusVO.setStat(this.stat);
        videoStatusVO.setNic(this.nic);
        videoStatusVO.setCamera(this.camera);
        videoStatusVO.setServerPort(this.serverPort);
        videoStatusVO.setServerAddr(this.serverAddr);
        videoStatusVO.setMsg(this.msg);
        return videoStatusVO;
    }
}
