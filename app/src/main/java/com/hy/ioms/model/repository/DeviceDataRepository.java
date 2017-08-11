package com.hy.ioms.model.repository;

import com.google.gson.Gson;
import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.dto.DeviceStatusDTO;
import com.hy.ioms.model.dto.ManualPictureDTO;
import com.hy.ioms.model.dto.ScheduleTaskPictureDTO;
import com.hy.ioms.model.dto.ScheduleTaskResultDTO;
import com.hy.ioms.model.dto.VideoSenderTaskDTO;
import com.hy.ioms.model.net.IomsApi;


import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import retrofit2.Response;


/**
 * 设备数据仓库
 *
 * Created by wsw on 2017/8/9.
 */

public class DeviceDataRepository {
    private IomsApi iomsApi;

    @Inject
    public DeviceDataRepository(IomsApi iomsApi) {
        this.iomsApi = iomsApi;
    }

    @Inject
    Gson gson;

    /**
     * 获取设备
     *
     * @param page 第几页
     * @param size 每页的个数
     * @param sort 排序
     */
    @NonNull
    public Single<Page<DeviceDTO>> getDevices(int page, int size, String sort) {
        return iomsApi.getDevices(page, size, sort)
                .map(listResponse -> {
                    Page<DeviceDTO> devicePage = new Page<>();
                    String totalCount = listResponse.headers().get(Config.TOTAL_COUNT);
                    devicePage.setContent(listResponse.body());
                    devicePage.setTotalNumber(Integer.parseInt(totalCount));
                    devicePage.setCurrentPage(page);
                    return devicePage;
                });
    }

    /**
     * 获取计划任务图片
     *
     * @param deviceId 设备id
     * @param page 第几页
     * @param size 每页的个数
     * @param sort 排序
     */
    public Single<Page<ScheduleTaskPictureDTO>> getScheduledTaskPictures(Long deviceId, int page, int size, String sort) {
        return iomsApi.getScheduleTaskPictures(deviceId, page, size, sort)
                .map((Response<List<ScheduleTaskResultDTO>> listResponse) -> {
                    Page<ScheduleTaskResultDTO> scheduleTaskPicturesPage = new Page<>();
                    String totalCount = listResponse.headers().get(Config.TOTAL_COUNT);
                    scheduleTaskPicturesPage.setContent(listResponse.body());
                    scheduleTaskPicturesPage.setTotalNumber(Integer.parseInt(totalCount));
                    scheduleTaskPicturesPage.setCurrentPage(page);
                    return scheduleTaskPicturesPage;
                })
                .map(new Function<Page<ScheduleTaskResultDTO>, Page<ScheduleTaskPictureDTO>>() {
                    @Override
                    public Page<ScheduleTaskPictureDTO> apply(@NonNull Page<ScheduleTaskResultDTO> scheduleTaskResultDTOPage) throws Exception {
                        return null;
                    }
                });
    }

    /**
     * 获取手动拍照图片
     *
     * @param deviceId 设备id
     * @param page 第几页
     * @param size 每页的个数
     * @param sort 排序
     */
    public Single<Page<ManualPictureDTO>> getManualPictures(Long deviceId, int page, int size, String sort) {
        return iomsApi.getManualPictures(deviceId, page, size, sort)
                .map(listResponse -> {
                    Page<ManualPictureDTO> manualPicturesPage = new Page<>();
                    String totalCount = listResponse.headers().get(Config.TOTAL_COUNT);
                    manualPicturesPage.setContent(listResponse.body());
                    manualPicturesPage.setTotalNumber(Integer.parseInt(totalCount));
                    manualPicturesPage.setCurrentPage(page);
                    return manualPicturesPage;
                });
    }

    /**
     * 获取在线设备
     */
    public Single<Set<String>> getOnlineDeviceSet() {
        return iomsApi.getOnlineDeviceSet();
    }

    /**
     * 获取当前设备状态
     *
     * @param deviceCode 设备code
     */
    public Single<DeviceStatusDTO> getCurrentDeviceStatus(String deviceCode) {
        return iomsApi.getCurrentDeviceStatus(deviceCode);
    }

    /**
     * 获取视频设备状态
     *
     * @param deviceCode 设备code
     */
    public Single<VideoSenderTaskDTO> getVideoSenderTask(String deviceCode) {
        return iomsApi.getVideoSenderTask(deviceCode);
    }
}
