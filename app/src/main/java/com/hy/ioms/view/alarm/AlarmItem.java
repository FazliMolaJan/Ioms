package com.hy.ioms.view.alarm;

import android.text.TextUtils;

import com.hy.ioms.R;
import com.hy.ioms.model.vo.AlarmVO;
import com.hy.ioms.view.ui.recycler.BaseItem;

/**
 * Created by wsw on 2017/8/22.
 */

public class AlarmItem extends BaseItem {
    private AlarmVO alarmVO;

    public AlarmItem(AlarmVO alarmVO) {
        this.alarmVO = alarmVO;

        setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.alarm_card_view:
                    System.out.println("alarm_card_view");
//                    DeviceDetailActivity.gotoActivity(view.getContext(), deviceVO);
                    break;
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.item_alarm;
    }

    public String getThumbUrl() {
        if (!TextUtils.isEmpty(alarmVO.getUrl())) {
            return alarmVO.getUrl().replace(".jpeg", "-sm.jpeg");
        }
        return alarmVO.getUrl();
    }

    public AlarmVO getAlarm() {
        return this.alarmVO;
    }

    public String getDeviceCode() {
        return alarmVO.getDeviceCode();
    }

    public String getCompanyName() {
        return alarmVO.getCompanyName();
    }

    public String getCircuitName() {
        return alarmVO.getCircuitName();
    }

    public String getPoleName() {
        return alarmVO.getPoleName();
    }

    public String getCollectionTime() {
        return alarmVO.getCollectionTime();
    }


}
