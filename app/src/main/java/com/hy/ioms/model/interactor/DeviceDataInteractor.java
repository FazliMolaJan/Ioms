package com.hy.ioms.model.interactor;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.vo.DeviceVO;

import io.reactivex.Single;

/**
 * 设备数据交互器
 * Created by wsw on 2017/8/9.
 */

public interface DeviceDataInteractor {
    //获取设备的状态，baseInfo，图片（手动拍照图片，计划任务图片）
    Single<Page<DeviceVO>> getDevices(PagingParams pagingParams);

}
