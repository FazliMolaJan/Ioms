package com.hy.ioms.model.service;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.repository.DeviceDataRepository;
import com.hy.ioms.model.vo.DeviceStatusVO;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.model.vo.PictureVO;
import com.hy.ioms.model.vo.VideoStatusVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * 设备数据服务
 * Created by wsw on 2017/8/2.
 */
@SuppressWarnings("unuesd")
public class DeviceDataService implements DeviceDataInteraction {


    @Inject
    public DeviceDataService(DeviceDataRepository deviceDataRepository) {
        this.deviceDataRepository = deviceDataRepository;
    }


    private DeviceDataRepository deviceDataRepository;

    /**
     * 获取设备
     *
     * @param pagingParams 分页信息
     */
    @Override
    public Single<Page<DeviceVO>> getDevices(PagingParams pagingParams) {
        Page<DeviceVO> deviceVoPage = new Page<>();
        return deviceDataRepository
                .getDevices(pagingParams.queryPage, pagingParams.itemsPerPage, pagingParams.sort)
                .doAfterSuccess(deviceVoPage::synchronize)
                .map(Page::getContent)
                .map(deviceDTOs -> {
                    List<DeviceVO> list = new ArrayList<>();
                    for (DeviceDTO deviceDTO : deviceDTOs) {
                        list.add(deviceDTO.transform());
                    }
                    return list;
                }).map(deviceVOs -> {
                    deviceVoPage.setContent(deviceVOs);
                    return deviceVoPage;
                });
    }


    /**
     * 获取计划任务图片
     *
     * @param deviceId     设备id
     * @param pagingParams 分页信息
     */
    @Override
    public Single<Page<PictureVO>> getScheduledTaskPictures(Long deviceId, PagingParams pagingParams) {
        Page<PictureVO> scheduledTaskPictures = new Page<>();
        return deviceDataRepository
                .getScheduledTaskPictures(deviceId, pagingParams.queryPage, pagingParams.itemsPerPage, pagingParams.sort)
                .doAfterSuccess(scheduledTaskPictures::synchronize)
                .map(Page::getContent)
                .map(scheduleTaskPictureDTOs -> {
                    List<PictureVO> list = new ArrayList<>();
                    for (ScheduleTaskPictureDTO scheduleTaskPictureDTO : scheduleTaskPictureDTOs) {
                        list.add(scheduleTaskPictureDTO.transform());
                    }
                    return list;
                }).map(pictureVOs -> {
                    scheduledTaskPictures.setContent(pictureVOs);
                    return scheduledTaskPictures;
                });

    }

    /**
     * 获取手动拍照图片
     *
     * @param deviceId     设备id
     * @param pagingParams 分页信息
     */
    @Override
    public Single<Page<PictureVO>> getManualPictures(Long deviceId, PagingParams pagingParams) {
        Page<PictureVO> manualPicturesVOPage = new Page<>();
        return deviceDataRepository
                .getManualPictures(deviceId, pagingParams.queryPage, pagingParams.itemsPerPage, pagingParams.sort)
                .doAfterSuccess(manualPicturesVOPage::synchronize)
                .map(Page::getContent)
                .map(manualPictureDTOs -> {
                    List<PictureVO> list = new ArrayList<>();
                    for (ManualPictureDTO manualPictureDTO : manualPictureDTOs) {
                        list.add(manualPictureDTO.transform());
                    }
                    return list;
                }).map(pictureVOs -> {
                    manualPicturesVOPage.setContent(pictureVOs);
                    return manualPicturesVOPage;
                });
    }

    /**
     * 获取在线设备
     *
     */
    @Override
    public Single<Set<String>> getOnlineDeviceSet() {
        return deviceDataRepository.getOnlineDeviceSet();
    }

    /**
     * 获取当前设备状态
     *
     * @param deviceCode 设备code
     */
    @Override
    public Single<DeviceStatusVO> getCurrentDeviceStatus(String deviceCode) {
        return deviceDataRepository.getCurrentDeviceStatus(deviceCode)
                .map(DeviceStatusDTO::transform);
    }

    /**
     * 获取视频设备状态
     *
     * @param deviceCode 设备code
     */
    @Override
    public Single<VideoStatusVO> getVideoSenderTask(String deviceCode) {
        return deviceDataRepository.getVideoSenderTask(deviceCode)
                .map(VideoSenderTaskDTO::transform);
    }

}
