package com.hy.ioms.model.interaction;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.dto.TreeNodeDTO;
import com.hy.ioms.model.vo.AlarmVO;
import com.hy.ioms.model.vo.DeviceStatusVO;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.model.vo.PictureVO;
import com.hy.ioms.model.vo.VideoStatusVO;

import java.util.List;
import java.util.Set;

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
     * @param page         第几页
     * @param itemsPerPage 每页的个数
     * @param sort         排序
     * @param companyId    公司Id,默认为0
     * @param circuitId    线路Id,默认为0
     * @param poleId       杆塔Id,默认为0
     */
    Single<Page<DeviceVO>> getDevices(int page, int itemsPerPage, String sort, Long companyId,
                                      Long circuitId, Long poleId);

    /**
     * 获取计划任务图片
     *
     * @param page         第几页数据
     * @param itemsPerPage 每页个数
     * @param sort         排序
     * @param companyId    公司Id
     * @param circuitId    线路Id
     * @param poleId       杆塔Id
     * @param deviceId     设备id
     * @param startTime    开始时间,为空则是全查
     * @param endTime      结束时间,默认为当天
     */
    Single<Page<PictureVO>> getScheduledTaskPictures(int page, int itemsPerPage, String sort, Long companyId,
                                                     Long circuitId, Long poleId, Long deviceId,
                                                     String startTime, String endTime);

    /**
     * 获取设备手动拍照图片
     *
     * @param page         第几页数据
     * @param itemsPerPage 每页个数
     * @param sort         排序
     * @param companyId    公司Id
     * @param circuitId    线路Id
     * @param poleId       杆塔Id
     * @param deviceId     设备id
     * @param startTime    开始时间,为空则是全查
     * @param endTime      结束时间,默认为当天
     */
    Single<Page<PictureVO>> getManualPictures(int page, int itemsPerPage, String sort, Long companyId,
                                              Long circuitId, Long poleId, Long deviceId,
                                              String startTime, String endTime);

    /**
     * 获取设备山火报警
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
    Single<Page<AlarmVO>> getFireAlarm(int page, int size, String sort,
                                       Long companyId, Long circuitId,
                                       Long poleId, Long deviceId,
                                       String startTime, String endTime);

    /**
     * 获取设备外破报警
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
    Single<Page<AlarmVO>> getBreakAlarm(int page, int size, String sort,
                                        Long companyId, Long circuitId,
                                        Long poleId, Long deviceId,
                                        String startTime, String endTime);


    /**
     * 获取在线设备code列表
     */
    Single<Set<String>> getOnlineDeviceSet();


    /**
     * 获取设备的当前状态
     *
     * @param deviceCode 设备code
     */
    Single<DeviceStatusVO> getCurrentDeviceStatus(String deviceCode);

    /**
     * 获取设备视频的当前状态
     *
     * @param deviceCode 设备code
     */
    Single<VideoStatusVO> getVideoSenderTask(String deviceCode);

    /**
     * 获取设备当前报警个数
     *
     * @param id          设备di
     * @param projectType 设备的项目类型(山火,外破)
     */
    Single<Integer> getDeviceAlarmCount(Long id, String projectType);

    /**
     * 获取TreeNode对象
     */
    Single<List<TreeNodeDTO>> getFilterTreeNode();


}
