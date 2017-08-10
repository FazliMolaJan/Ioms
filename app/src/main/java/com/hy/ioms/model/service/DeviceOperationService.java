package com.hy.ioms.model.service;

import com.hy.ioms.model.dto.OperateDTO;
import com.hy.ioms.model.dto.ResponseDTO;
import com.hy.ioms.model.interactor.DeviceOperationInteractor;
import com.hy.ioms.model.repository.DeviceOperationRepository;
import com.hy.ioms.model.vo.ResponseVO;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;

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

    /**
     * 拍照
     *
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @param presetId   预制位id
     * @param width      图片宽度
     * @param height     图片高
     * @return
     */
    @Override
    public Single<ResponseVO> capturePicture(String deviceCode, String camera, int presetId, int width, int height) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo("Emd.Service.PicCapture.E0", "PicCapture", "Emd.Method.Normal"));
        Map<String, Object> param = new HashMap<>();
        param.put("Camera", camera);
        param.put("PresetId", presetId);
        param.put("Width", width);
        param.put("Height", height);
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }

    /**
     * 打开摄像机电源
     *
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @return
     */
    @Override
    public Single<ResponseVO> OpenCameraPower(String deviceCode, String camera, int time) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo(camera, "Open", "Emd.Method.Normal"));
        Map<String, Object> param = new HashMap<>();
        param.put("OpenTimeSpan", time);
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }

    /**
     * 打开WIFI电源
     *
     * @param deviceCode 设备code
     * @param time       打开时间
     * @return
     */
    @Override
    public Single<ResponseVO> openWifiPower(String deviceCode, int time) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo("Emd.Device.Wifi.E0", "Open", "Emd.Method.Normal"));
        Map<String, Object> param = new HashMap<>();
        param.put("OpenTimeSpan", time);
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }

    /**
     * 预置位设置
     *
     * @param type       类型（相机或者是机械云台）
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @param presetId   预置位id
     * @param speed      速度
     * @return
     */
    @Override
    public Single<ResponseVO> setPreset(String type, String deviceCode, String camera, String command, int presetId, float speed, float horizontal, float vertical) {
        Single<ResponseVO> responseVOSingle;
        //type代表是机械云台或者是camera
        if (type.equals("camera")) {
            responseVOSingle = cameraPresetManager(deviceCode, camera, "SetPreset", presetId, speed);
        } else {
            responseVOSingle = tiltPresetManager(deviceCode, "Set", presetId, horizontal, vertical, speed);
        }
        return responseVOSingle;
    }

    /**
     * 调用预置位
     *
     * @param type       类型（相机或者是机械云台）
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @param presetId   预置位id
     * @param speed      速度
     * @return
     */
    @Override
    public Single<ResponseVO> gotoPreset(String type, String deviceCode, String camera, String command, int presetId, float speed, float horizontal, float vertical) {
        Single<ResponseVO> responseVOSingle;
        if (type.equals("camera")) {
            responseVOSingle = cameraPresetManager(deviceCode, camera, "GotoPreset", presetId, speed);
        } else {
            responseVOSingle = tiltPresetManager(deviceCode, "Goto", presetId, horizontal, vertical, speed);
        }
        return responseVOSingle;
    }


    /**
     * 相机预置位操作
     *
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @param command    指令
     * @param presetId   预置位id
     * @param speed      速度
     * @return
     */
    private Single<ResponseVO> cameraPresetManager(String deviceCode, String camera, String command, int presetId, float speed) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo(camera, "PtzControl", "Emd.Method.Ctrl"));
        Map<String, Object> param = new HashMap<>();
        param.put("Command", command);
        param.put("PresetId", presetId);
        param.put("Speed", speed);
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }

    /**
     * 机械云台预置位操作
     *
     * @param deviceCode 设备code
     * @param command    指令
     * @param presetId   预置位id
     * @param horizontal 待设置预置位的水平方位
     * @param vertical   待设置预置位的垂直方位
     * @param speed      Ptz速度
     * @return
     */
    private Single<ResponseVO> tiltPresetManager(String deviceCode, String command, int presetId, float horizontal, float vertical, float
            speed) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo("Emd.Device.Tilt.E0", "PresetControl", "Emd.Method.Ctrl"));
        Map<String, Object> param = new HashMap<>();
        param.put("Command", command);
        if (command.equals("Set")) {
            param.put("PresetId", presetId);
            if (horizontal != -1f && vertical != -1f) {
                param.put("Vertical", vertical);
                param.put("Horizontal", horizontal);
            }
        } else if (command.equals("Goto")) {
            param.put("PresetId", presetId);
            param.put("Speed", speed);
        }
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }

    /**
     * 转动操作
     *
     * @param type       机器类型（相机或者是机械云台）
     * @param deviceCode 设备id
     * @param camera     目标相机
     * @param command    指令
     * @param speed      速度
     * @return
     */
    @Override
    public Single<ResponseVO> operateControl(String type, String deviceCode, String camera, String command, String speed) {
        Single<ResponseVO> responseVOSingle;
        if (type.equals("camera")) {
            responseVOSingle = cameraOperateManager(deviceCode, camera, command, speed);
        } else {
            responseVOSingle = tiltOperateManager(deviceCode, command, speed);
        }
        return responseVOSingle;
    }

    /**
     * 相机操作管理
     *
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @param command    指令
     * @param speed      速度
     * @return
     */
    private Single<ResponseVO> cameraOperateManager(String deviceCode, String camera, String command, String speed) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo(camera, "PtzControl", "Emd.Method.Ctrl"));
        Map<String, Object> param = new HashMap<>();
        param.put("Command", command);
        param.put("Speed", speed);
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }

    /**
     * 机械云台操作管理
     *
     * @param deviceCode 设备code
     * @param command    指令
     * @param speed      速度
     * @return
     */
    private Single<ResponseVO> tiltOperateManager(String deviceCode, String command, String speed) {
        OperateDTO operateDTO = new OperateDTO();
        operateDTO.setDestInfo(new OperateDTO.DestInfo("Emd.Device.Tilt.E0", "RelativeMove", "Emd.Method.Ctrl"));
        Map<String, Object> param = new HashMap<>();
        param.put("Command", command);
        param.put("Speed", speed);
        operateDTO.setParam(param);
        return deviceOperationRepository.operateDevice(deviceCode, operateDTO)
                .map(ResponseDTO::transform);
    }


}
