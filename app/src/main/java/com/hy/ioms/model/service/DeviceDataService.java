package com.hy.ioms.model.service;

import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.dto.AlarmBreakDTO;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.dto.DeviceStatusDTO;
import com.hy.ioms.model.dto.ManualPictureDTO;
import com.hy.ioms.model.dto.ScheduleTaskPictureDTO;
import com.hy.ioms.model.dto.TreeNodeDTO;
import com.hy.ioms.model.dto.VideoSenderTaskDTO;
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
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

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
     * @param page         第几页
     * @param itemsPerPage 每页的个数
     * @param sort         排序
     * @param companyId    公司Id,默认为0
     * @param circuitId    线路Id,默认为0
     * @param poleId       杆塔Id,默认为0
     */
    @Override
    public Single<Page<DeviceVO>> getDevices(int page, int itemsPerPage, String sort,
                                             Long companyId, Long circuitId, Long poleId) {
        Page<DeviceVO> deviceVoPage = new Page<>();
        return deviceDataRepository
                .getDevices(page, itemsPerPage, sort, companyId, circuitId, poleId)
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
     * @param page         第几页数据
     * @param itemsPerPage 每页个数
     * @param sort         排序
     */
    @Override
    public Single<Page<PictureVO>> getScheduledTaskPictures(Long deviceId, int page, int itemsPerPage, String sort) {
        Page<PictureVO> scheduledTaskPictures = new Page<>();
        return deviceDataRepository
                .getScheduledTaskPictures(deviceId, page, itemsPerPage, sort)
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
     * @param page         第几页数据
     * @param itemsPerPage 每页个数
     * @param sort         排序
     */
    @Override
    public Single<Page<PictureVO>> getManualPictures(Long deviceId, int page, int itemsPerPage, String sort) {
        Page<PictureVO> manualPicturesVOPage = new Page<>();
        return deviceDataRepository
                .getManualPictures(deviceId, page, itemsPerPage, sort)
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

    /**
     * 获取设备报警个数
     *
     * @param id          设备di
     * @param projectType 设备的项目类型(山火,外破)
     * @return 报警个数
     */
    @Override
    public Single<Integer> getDeviceAlarmCount(Long id, String projectType) {
        Single<Integer> countSingle;
        switch (projectType) {
            case Config.FIRE_PROJECT: //山火项目
                countSingle = deviceDataRepository.getDeviceFireAlarm(id, Config.HANDLED, 0, 0, "")
                        .map(Page::getTotalNumber);
                break;
            case Config.BREAK_PROJECT://外破项目
                countSingle = deviceDataRepository.getDeviceBreakAlarm(id, Config.HANDLED, 0, 0, "")
                        .map(Page::getTotalNumber);
                break;
            default://其他默认为0个报警
                countSingle = Single.just(0);
                break;
        }
        return countSingle;
    }

    /**
     * 获取TreeNode对象
     */
    @Override
    public Single<List<TreeNodeDTO>> getFilterTreeNode() {
        return deviceDataRepository.getFilterTreeNode();
    }

}
