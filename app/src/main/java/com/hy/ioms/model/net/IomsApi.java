package com.hy.ioms.model.net;


import com.hy.ioms.model.dto.DeviceConfigDTO;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.dto.DeviceStatusDTO;
import com.hy.ioms.model.dto.ManualPictureDTO;
import com.hy.ioms.model.dto.ResponseDTO;
import com.hy.ioms.model.dto.ScheduleTaskResultDTO;
import com.hy.ioms.model.dto.UserDTO;
import com.hy.ioms.model.dto.VideoDTO;
import com.hy.ioms.model.dto.VideoSenderTaskDTO;

import java.util.List;
import java.util.Set;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 网络访问接口 Created by wsw on 2016/12/5.
 */
@SuppressWarnings("unused")
public interface IomsApi {

    /**
     * 登录接口
     *
     * @param username   用户名
     * @param password   密码
     * @param rememberMe 是否保存
     */
    @POST("api/authentication")
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Completable login(@Field("j_username") String username, @Field("j_password") String password,
                      @Field("remember-me") boolean rememberMe);

    /**
     * 获取认证
     */
    @GET("api/authenticate")
    Completable getAuthenticate();

    /**
     * 获取账户信息
     */
    @GET("api/account")
    Single<UserDTO> getAccount();

    /**
     * 根据设备id获取设备信息
     *
     * @param id 设备id
     */
    @GET("api/devices/{id}")
    Single<DeviceDTO> getDevice(@Path("id") Long id);

    /**
     * 获取设备列表
     *
     * @param page 第几页
     * @param size 每页个数
     * @param sort 排序
     */
    @GET("api/devices")
    Single<Response<List<DeviceDTO>>> getDevices(@Query("page") int page, @Query("size") int size,
                                                 @Query("sort") String sort);


    /**
     * 获取手动拍照图片
     *
     * @param deviceId 设备id
     * @param page     页数
     * @param size     每页个数
     * @param sort     排序
     */
    @GET("api/{deviceId}/pic-manuals")
    Single<Response<List<ManualPictureDTO>>>
    getManualPictures(@Path("deviceId") Long deviceId, @Query("page") int page,
                      @Query("size") int size, @Query("sort") String sort);


    /**
     * 根据SessionId获取手动拍照图片
     *
     * @param sessionId 手动拍照的sessionId
     */
    @GET("api/pic-manuals/session-id")
    Single<ManualPictureDTO> getManualPictureBySessionId(@Query("sessionId") String sessionId);

    /**
     * 获取计划任务图片
     *
     * @param deviceId 设备id
     * @param page     页数
     * @param size     每页个数
     * @param sort     排序
     */
    @GET("api/{deviceId}/schedule-task-results")
    Single<Response<List<ScheduleTaskResultDTO>>>
    getScheduleTaskPictures(@Path("deviceId") Long deviceId, @Query("page") int page,
                            @Query("size") int size, @Query("sort") String sort);

    /**
     * 获取在线设备set
     */
    @GET("api/information/deviceSet")
    Single<Set<String>> getOnlineDeviceSet();

    /**
     * 根据code获取设备
     *
     * @param code 设备code
     */
    @GET("api/devices/code/{code}")
    Single<List<DeviceDTO>> getDeviceByCode(@Path("code") String code);


    /**
     * 手动拍照
     *
     * @param sessionId  该任务的唯一标示
     * @param deviceCode 设备code
     * @param camera     相机编号
     * @param presetId   预置位id(为null则是当前位置)
     * @param width      图片宽
     * @param height     图片高
     */
    @GET("api/capturePicture")
    Single<ResponseDTO> capturePicture(@Query("sessionId") String sessionId,
                                       @Query("deviceCode") String deviceCode,
                                       @Query("camera") String camera,
                                       @Query("presetId") String presetId,
                                       @Query("width") String width,
                                       @Query("height") String height);

    /**
     * 获取设备的配置信息
     *
     * @param deviceCode 设备code
     */
    @GET("api/device-configs/{deviceCode}")
    Single<DeviceConfigDTO> getDeviceConfig(@Path("deviceCode") String deviceCode);


    /**
     * 控制云台
     *
     * @param deviceCode 设备code
     * @param camera     相机
     * @param command    命令
     * @param speed      速度
     */
    @GET("api/ptz-direction")
    Observable<ResponseDTO> ptzControl(@Query("deviceCode") String deviceCode,
                                       @Query("camera") String camera,
                                       @Query("command") String command,
                                       @Query("speed") String speed);


    /**
     * 调用预置位
     *
     * @param deviceCode 设备code
     * @param camera     相机
     * @param presetId   预置位id
     */
    @GET("api/ptz/preset/goto/{presetId}")
    Observable<ResponseDTO> gotoPreset(@Path("presetId") String presetId,
                                       @Query("deviceCode") String deviceCode,
                                       @Query("camera") String camera
    );

    /**
     * 设置预置位
     *
     * @param deviceCode 设备code
     * @param camera     相机
     * @param presetId   预置位id
     */
    @GET("api/ptz/preset/set/{presetId}")
    Observable<ResponseDTO> setPreset(@Path("presetId") String presetId,
                                      @Query("deviceCode") String deviceCode,
                                      @Query("camera") String camera
    );

    /**
     * 删除预置位
     *
     * @param deviceCode 设备code
     * @param camera     相机
     * @param presetId   预置位id
     */
    @GET("api/ptz/preset/remove/{presetId}")
    Observable<ResponseDTO> removePreset(@Path("presetId") String presetId,
                                         @Query("deviceCode") String deviceCode,
                                         @Query("camera") String camera);

    /**
     * 开始播放视频
     *
     * @param deviceCode 设备id
     * @param camera     目标E0
     * @param nic        网卡E1
     * @param channel    通道号2
     */
    @GET("api/video/play")
    Single<VideoDTO> playVideo(@Query("deviceCode") String deviceCode,
                               @Query("camera") String camera,
                               @Query("channel") String channel,
                               @Query("protocol") String protocol,
                               @Query("nic") String nic);

    /**
     * 停止播放视频
     *
     * @param deviceCode 设备id
     * @param camera     目标E0
     * @param nic        网卡E1
     * @param channel    通道号2
     */
    @GET("api/video/stop")
    Single<String> stopVideo(@Query("protocol") String protocol,
                             @Query("deviceCode") String deviceCode,
                             @Query("camera") String camera,
                             @Query("channel") String channel,
                             @Query("nic") String nic);

    /**
     * 获取设备视频状态
     *
     * @param deviceCode 设备id
     */
    @GET("api/video/status")
    Single<VideoSenderTaskDTO> getVideoSenderTask(@Query("deviceCode") String deviceCode);

    /**
     * 保持播放视频
     *
     * @param deviceCode 设备id
     * @param taskId     任务id
     */
    @GET("api/video/keep")
    Single<ResponseDTO> keepVideo(@Query("deviceCode") String deviceCode,
                                   @Query("taskId") String taskId);


    /**
     * 取得设备的当前信息 CurrentDeviceStatus
     *
     * @param deviceCode 设备id
     */
    @GET("api/information/deviceState/{deviceCode}")
    Single<DeviceStatusDTO> getCurrentDeviceStatus(@Path("deviceCode") String deviceCode);

    /**
     * 设备的操作,包括设备开电,播放,转动等以及设备获取配置等
     *
     * @param deviceCode 设备code
     * @param sessionId  发送的指令id
     * @param controlCmd 发送的命令的json
     */
    @GET("api/{deviceCode}/control")
    Single<ResponseDTO> operateDevice(@Path("deviceCode") String deviceCode,
                                      @Query("sessionId") String sessionId,
                                      @Query("controlCmd") String controlCmd);

}
