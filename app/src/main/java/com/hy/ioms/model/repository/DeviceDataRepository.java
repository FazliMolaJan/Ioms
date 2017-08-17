package com.hy.ioms.model.repository;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.dto.AlarmBreakDTO;
import com.hy.ioms.model.dto.AlarmFireDTO;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.dto.DeviceStatusDTO;
import com.hy.ioms.model.dto.ManualPictureDTO;
import com.hy.ioms.model.dto.ScheduleTaskPictureDTO;
import com.hy.ioms.model.dto.ScheduleTaskResultDTO;
import com.hy.ioms.model.dto.TreeNodeDTO;
import com.hy.ioms.model.dto.VideoSenderTaskDTO;
import com.hy.ioms.model.net.IomsApi;


import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import retrofit2.Response;


/**
 * 设备数据仓库
 * <p>
 * Created by wsw on 2017/8/9.
 */

public class DeviceDataRepository {
    private static final String TAG = "DeviceDataRepository";
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
     * @param page         第几页
     * @param itemsPerPage 每页的个数
     * @param sort         排序
     * @param companyId    公司Id,默认为0
     * @param circuitId    线路Id,默认为0
     * @param poleId       杆塔Id,默认为0
     */
    @NonNull
    public Single<Page<DeviceDTO>> getDevices(int page, int itemsPerPage, String sort, Long companyId, Long circuitId, Long poleId) {
        return iomsApi.getDevices(page, itemsPerPage, sort, companyId, circuitId, poleId)
                .map(this::pageTransform)
                .doOnSuccess(dtoPage -> dtoPage.setCurrentPage(page));
    }

    /**
     * 获取计划任务图片
     *
     * @param deviceId 设备id
     * @param page     第几页
     * @param size     每页的个数
     * @param sort     排序
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
     * @param page     第几页
     * @param size     每页的个数
     * @param sort     排序
     */
    public Single<Page<ManualPictureDTO>> getManualPictures(Long deviceId, int page, int size, String sort) {
        return iomsApi.getManualPictures(deviceId, page, size, sort)
                .map(this::pageTransform)
                .doOnSuccess(dtoPage -> dtoPage.setCurrentPage(page));
    }

    /**
     * 获取设备山火报警
     *
     * @param sort      排序
     * @param page      第几页
     * @param size      每页的个数
     * @param deviceId  设备id
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param deliver   用户只能看到推送了的
     */
    public Single<Page<AlarmFireDTO>> getDeviceFireAlarm(Long deviceId, String startTime,
                                                         String endTime, int deliver, int page,
                                                         int size, String sort) {
        return iomsApi.getDeviceFireAlarm(page, size, sort, deviceId, startTime, endTime, deliver)
                .map(this::pageTransform)
                .doOnSuccess(dtoPage -> dtoPage.setCurrentPage(page));
    }

    /**
     * 获取设备山火报警
     *
     * @param sort     排序
     * @param page     第几页
     * @param size     每页的个数
     * @param deviceId 设备id
     * @param deliver  用户只能看到推送了的
     */
    public Single<Page<AlarmFireDTO>> getDeviceFireAlarm(Long deviceId, int deliver, int page,
                                                         int size, String sort) {
        return iomsApi.getDeviceFireAlarm(page, size, sort, deviceId, null, null, deliver)
                .map(this::pageTransform)
                .doOnSuccess(dtoPage -> dtoPage.setCurrentPage(page));
    }

    /**
     * 获取设备外破报警
     *
     * @param sort      排序
     * @param page      第几页
     * @param size      每页的个数
     * @param deviceId  设备id
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param deliver   用户只能看到推送了的
     */
    public Single<Page<AlarmBreakDTO>> getDeviceBreakAlarm(Long deviceId, String startTime,
                                                           String endTime, int deliver, int page,
                                                           int size, String sort) {
        return iomsApi.getDeviceBreakAlarm(page, size, sort, deviceId, startTime, endTime, deliver)
                .map(this::pageTransform)
                .doOnSuccess(dtoPage -> dtoPage.setCurrentPage(page));
    }

    /**
     * 获取设备外破报警
     *
     * @param sort     排序
     * @param page     第几页
     * @param size     每页的个数
     * @param deviceId 设备id
     * @param deliver  用户只能看到推送了的
     */
    public Single<Page<AlarmBreakDTO>> getDeviceBreakAlarm(Long deviceId, int deliver, int page,
                                                           int size, String sort) {
        return iomsApi.getDeviceBreakAlarm(page, size, sort, deviceId, null, null, deliver)
                .map(this::pageTransform)
                .doOnSuccess(dtoPage -> dtoPage.setCurrentPage(page));
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

    /**
     * 获取TreeNode
     */
    public Single<List<TreeNodeDTO>> getFilterTreeNode() {
        return iomsApi.getTreeNode();
    }

    /**
     * page转换函数
     *
     * @param listResponse 获取到Response 对象
     * @param <T>          DTO
     * @return Page<T>
     */
    private <T> Page<T> pageTransform(Response<List<T>> listResponse) {
        Log.i(TAG, "pageTransform");
        Page<T> page = new Page<>();
        String totalCount = listResponse.headers().get(Config.TOTAL_COUNT);
        page.setContent(listResponse.body());
        if (!TextUtils.isEmpty(totalCount)) {
            page.setTotalNumber(Integer.parseInt(totalCount));
        }
        return page;
    }
}
