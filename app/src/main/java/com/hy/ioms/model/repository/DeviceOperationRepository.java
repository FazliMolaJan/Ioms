package com.hy.ioms.model.repository;

import com.google.gson.Gson;
import com.hy.ioms.model.dto.OperateDTO;
import com.hy.ioms.model.dto.ResponseDTO;
import com.hy.ioms.model.net.IomsApi;
import com.hy.ioms.utils.CommandUtil;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by wsw on 2017/8/9.
 */

public class DeviceOperationRepository {
    private IomsApi iomsApi;
    private Gson gson;

    @Inject
    public DeviceOperationRepository(IomsApi iomsApi, Gson gson) {
        this.iomsApi = iomsApi;
        this.gson = gson;
    }

    public Single<ResponseDTO> operateDevice(String deviceCode, OperateDTO operateDTO) {
        return iomsApi.operateDevice(deviceCode, CommandUtil.getCommandId(), gson.toJson
                (operateDTO));
    }
}
