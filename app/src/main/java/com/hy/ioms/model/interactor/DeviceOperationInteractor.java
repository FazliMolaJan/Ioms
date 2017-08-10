package com.hy.ioms.model.interactor;

import com.hy.ioms.model.vo.ResponseVO;

import io.reactivex.Single;

/**
 * 设备操作交互器
 * Created by wsw on 2017/8/9.
 */

public interface DeviceOperationInteractor {
    //拍照，打开摄像机电源，打开wifi电源，拉近拉远，预制位调用，||最后实现转动

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

    /**
     * 拍照
     *
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @param presetId   预制位id
     * @param width      图片宽度
     * @param height     图片高
     */
    Single<ResponseVO> capturePicture(String deviceCode, String camera, int presetId, int width, int height);

    /**
     * 打开摄像机电源
     *
     * @param deviceCode 设备code
     * @param camera     目标相机
     * @return
     */
    Single<ResponseVO> OpenCameraPower(String deviceCode, String camera, int time);

    /**
     * 打开wifi电源
     *
     * @param deviceCode 设备code
     * @param time       打开时间
     * @return
     */
    Single<ResponseVO> openWifiPower(String deviceCode, int time);

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
    Single<ResponseVO> setPreset(String type, String deviceCode, String camera, String command, int presetId, float speed, float horizontal, float vertical);

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
    Single<ResponseVO> gotoPreset(String type, String deviceCode, String camera, String command, int presetId, float speed, float horizontal, float vertical);

    /**
     * 转动设置
     *
     * @param type       机器类型（相机或者是机械云台）
     * @param deviceCode 设备id
     * @param camera     目标相机
     * @param command    指令
     * @param speed      速度
     * @return
     */
    Single<ResponseVO> operateControl(String type, String deviceCode, String camera, String command, String speed);

}
