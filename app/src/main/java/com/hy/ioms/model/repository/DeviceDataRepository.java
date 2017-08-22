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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import retrofit2.Response;


/**
 * 设备数据仓库
 * <p>
 * Created by wsw on 2017/8/9.
 */
@SuppressWarnings("unused")
public class DeviceDataRepository {
    private static final String TAG = "DeviceDataRepository";
    private IomsApi iomsApi;
    private Gson gson;

    @Inject
    public DeviceDataRepository(IomsApi iomsApi, Gson gson) {
        this.iomsApi = iomsApi;
        this.gson = gson;
    }

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
    public Single<Page<DeviceDTO>> getDevices(int page, int itemsPerPage, String sort,
                                              Long companyId, Long circuitId, Long poleId) {
        return iomsApi.getDevices(page, itemsPerPage, sort, companyId, circuitId, poleId)
                .map(this::pageTransform)
                .doOnSuccess(dtoPage -> dtoPage.setCurrentPage(page));
    }

    /**
     * 获取计划任务图片
     *
     * @param page      第几页数据
     * @param size      每页个数
     * @param sort      排序
     * @param companyId 公司Id
     * @param circuitId 线路Id
     * @param poleId    杆塔Id
     * @param deviceId  设备id
     * @param startTime 开始时间,为空则是全查
     * @param endTime   结束时间,默认为当天
     */
    public Single<Page<ScheduleTaskPictureDTO>> getScheduledTaskPictures(int page, int size, String sort,
                                                                         Long companyId, Long circuitId,
                                                                         Long poleId, Long deviceId,
                                                                         String startTime, String endTime) {
        return iomsApi.getScheduleTaskPictures(page, size, sort, companyId, circuitId, poleId, deviceId, startTime, endTime)
                .map(this::pageTransform)
                .map(scheduleTaskResultDTOPage -> {
                    Page<ScheduleTaskPictureDTO> pictureDTOPage = new Page<>();
                    pictureDTOPage.setTotalNumber(scheduleTaskResultDTOPage.getTotalNumber());
                    pictureDTOPage.setCurrentPage(scheduleTaskResultDTOPage.getCurrentPage());
                    List<ScheduleTaskPictureDTO> list = new ArrayList<>();
                    for (ScheduleTaskResultDTO scheduleTaskResultDTO : scheduleTaskResultDTOPage.getContent()) {
                        list.add(gson.fromJson(scheduleTaskResultDTO.getContent(), ScheduleTaskPictureDTO.class));
                    }
                    pictureDTOPage.setContent(list);
                    return pictureDTOPage;
                });
    }

    /**
     * 获取手动拍照图片
     *
     * @param page      第几页数据
     * @param size      每页个数
     * @param sort      排序
     * @param companyId 公司Id
     * @param circuitId 线路Id
     * @param poleId    杆塔Id
     * @param deviceId  设备id
     * @param startTime 开始时间,为空则是全查
     * @param endTime   结束时间,默认为当天
     */
    public Single<Page<ManualPictureDTO>> getManualPictures(int page, int size, String sort,
                                                            Long companyId, Long circuitId,
                                                            Long poleId, Long deviceId,
                                                            String startTime, String endTime) {
        return iomsApi.getManualPictures(page, size, sort, companyId, circuitId, poleId, deviceId, startTime, endTime)
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
        Page<T> page = new Page<>();
        String totalCount = listResponse.headers().get(Config.TOTAL_COUNT);
        page.setContent(listResponse.body());
        if (!TextUtils.isEmpty(totalCount)) {
            page.setTotalNumber(Integer.parseInt(totalCount));
        }
        return page;
    }
}
