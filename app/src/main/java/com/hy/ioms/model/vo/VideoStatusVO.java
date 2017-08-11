package com.hy.ioms.model.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ${description}
 * Created by wsw on 2017/8/10.
 */

public class VideoStatusVO implements Parcelable {
    private int id;
    private int channel;
    private String url;
    private String stat;
    private String nic;
    private String camera;
    private int serverPort;
    private String serverAddr;
    private String msg;

    private VideoStatusVO(Parcel in) {
        id = in.readInt();
        channel = in.readInt();
        url = in.readString();
        stat = in.readString();
        nic = in.readString();
        camera = in.readString();
        serverPort = in.readInt();
        serverAddr = in.readString();
        msg = in.readString();
    }

    public static final Creator<VideoStatusVO> CREATOR = new Creator<VideoStatusVO>() {
        @Override
        public VideoStatusVO createFromParcel(Parcel in) {
            return new VideoStatusVO(in);
        }

        @Override
        public VideoStatusVO[] newArray(int size) {
            return new VideoStatusVO[size];
        }
    };

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

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VideoStatusVO() {
    }

    @Override
    public String toString() {
        return "VideoStatusVO{" +
                "id=" + id +
                ", channel=" + channel +
                ", url='" + url + '\'' +
                ", stat='" + stat + '\'' +
                ", nic='" + nic + '\'' +
                ", camera='" + camera + '\'' +
                ", serverPort=" + serverPort +
                ", serverAddr='" + serverAddr + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(channel);
        parcel.writeString(url);
        parcel.writeString(stat);
        parcel.writeString(nic);
        parcel.writeString(camera);
        parcel.writeInt(serverPort);
        parcel.writeString(serverAddr);
        parcel.writeString(msg);
    }
}
