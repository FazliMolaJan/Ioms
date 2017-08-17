package com.hy.ioms.view.device;


import com.hy.ioms.Config;
import com.hy.ioms.R;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.view.ui.recycler.BaseItem;

/**
 * 设备
 * Created by wsw on 2017/4/11.
 */

public class DeviceListItem extends BaseItem {
    private DeviceVO mDeviceVO;

    @Override
    public int getLayout() {
        return R.layout.item_device;
    }

    public DeviceListItem(DeviceVO deviceVO) {
        this.mDeviceVO = deviceVO;
        setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.device_card:
//                    DeviceDetailActivity.gotoActivity(view.getContext(), deviceVO);
                    break;
                case R.id.item_device_alarm_btn:
//                    AlarmActivity.gotoActivity(view.getContext(),deviceVO);
                    break;
            }
        });
    }

    public String getName() {
        return mDeviceVO.getName();
    }

    public String getCircuitName() {
        return mDeviceVO.getCircuitName();
    }

    public String getCompanyName() {
        return mDeviceVO.getCompanyName();
    }

    public String getPoleName() {
        return mDeviceVO.getPoleName();
    }

    public String getCode() {
        return mDeviceVO.getCode();
    }

    public Long getDeviceId() {
        return mDeviceVO.getId();
    }

    public DeviceVO getDeviceVO() {
        return mDeviceVO;
    }

    public String getState() {
        return mDeviceVO.isOnline() ? Config.ONLINE_STATE : Config.OFFLINE_STATE;
    }

    public boolean isOnline() {
        return mDeviceVO.isOnline();
    }

    public boolean getAlarm() {
        return mDeviceVO.getProjectType().equals("山火") || mDeviceVO.getProjectType().equals("外破");
    }

    public int getAlarmCount(){
        return mDeviceVO.getAlarmCount();
    }
}
