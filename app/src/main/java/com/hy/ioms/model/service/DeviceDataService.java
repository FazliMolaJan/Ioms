package com.hy.ioms.model.service;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.repository.DeviceDataRepository;
import com.hy.ioms.model.vo.DeviceVO;

import java.util.ArrayList;
import java.util.List;

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
}
