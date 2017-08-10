package com.hy.ioms.model.interactor;

import com.hy.ioms.model.vo.ResponseVO;

import io.reactivex.Single;

/**
 * 设备操作交互器
 * Created by wsw on 2017/8/9.
 */

public interface DeviceOperationInteractor {

    /**
     * 视屏播放
     *
     * @param deviceCode    设备code
     * @param camera        目标相机
     * @param nic           传流网卡
     * @param channel       播放通道号
     * @param protocol      协议,是UDP还是TCP
     * @param serverAddress 流服务器地址
     * @param serverPort    流服务端口
     * @return
     */
    Single<ResponseVO> play(String deviceCode, String camera, String nic, String channel, String
            protocol, String serverAddress, String serverPort);
}
