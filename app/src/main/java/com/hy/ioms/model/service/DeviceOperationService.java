package com.hy.ioms.model.service;

import com.hy.ioms.Config;
import com.hy.ioms.model.dto.OperateDTO;
import com.hy.ioms.model.dto.ResponseDTO;
import com.hy.ioms.model.dto.VideoConfigDTO;
import com.hy.ioms.model.interactor.DeviceOperationInteractor;
import com.hy.ioms.model.repository.DeviceOperationRepository;
import com.hy.ioms.model.vo.ResponseVO;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by wsw on 2017/8/9.
 */

public class DeviceOperationService implements DeviceOperationInteractor {

    @Inject
    DeviceOperationRepository deviceOperationRepository;

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
     */
    @Override
    public Single<ResponseVO> play(String deviceCode, String camera, String nic, String channel, String
            protocol, String serverAddress, String serverPort) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo("Emd.Service.VideoSender.E0", "SendVideoStream", "Emd.Method.Normal"));
        Map<String, Object> param = new HashMap<>();
        param.put("Camera", camera);
        param.put("Nic", nic);
        param.put("ServerAddr", serverAddress);
        param.put("ServerPort", serverPort);
        param.put("Protocol", protocol);
        param.put("Channel", channel);
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }
}
