package com.hy.ioms.model.repository;

import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.net.IomsApi;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

/**
 * Created by wsw on 2017/8/9.
 */

public class DeviceDataRepository {
    private IomsApi iomsApi;

    @Inject
    public DeviceDataRepository(IomsApi iomsApi) {
        this.iomsApi = iomsApi;
    }

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
}
