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
    Single<Page<DeviceVO>> getDevices(PagingParams pagingParams);
}
