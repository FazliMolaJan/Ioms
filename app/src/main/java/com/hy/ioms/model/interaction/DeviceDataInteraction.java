package com.hy.ioms.model.interaction;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.vo.DeviceStatusVO;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.model.vo.PictureVO;
import com.hy.ioms.model.vo.VideoStatusVO;

import java.util.List;

import io.reactivex.Single;

/**
 * 设备数据交互器
 * Created by wsw on 2017/8/9.
 */
@SuppressWarnings("unused")
public interface DeviceDataInteraction {
    //获取设备的状态，baseInfo，图片（手动拍照图片，计划任务图片）

    /**
     * 获取设备
     *
     * @param pagingParams 分页信息
     */
    Single<Page<DeviceVO>> getDevices(PagingParams pagingParams);

    /**
     * 获取计划任务图片
     *
     * @param deviceCode   设备code
     * @param pagingParams 分页信息
     */
    Single<Page<PictureVO>> getScheduledTaskPictures(String deviceCode, PagingParams pagingParams);

    /**
     * 获取设备手动拍照图片
     *
     * @param deviceCode   设备code
     * @param pagingParams 分页信息
     */
    Single<Page<PictureVO>> getManualPictures(String deviceCode, PagingParams pagingParams);

    /**
     * 获取在线设备code列表
     */
    Single<List<String>> getOnlineDeviceCodeList();


    /**
     * 获取设备的当前状态
     *
     * @param deviceCode 设备code
     */
    Single<DeviceStatusVO> getDeviceStatus(String deviceCode);

    /**
     * 获取设备视频的当前状态
     *
     * @param deviceCode 设备code
     */
    Single<VideoStatusVO> getVideoStatus(String deviceCode);
}