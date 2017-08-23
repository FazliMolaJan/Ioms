package com.hy.ioms.di.device.detail;

import android.support.v4.app.Fragment;

import com.hy.ioms.Config;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.alarm.AlarmFragment;
import com.hy.ioms.view.device.DeviceListFragment;
import com.hy.ioms.view.device.detail.DeviceDetailActivity;
import com.hy.ioms.view.information.InformationFragment;
import com.hy.ioms.view.main.MainActivity;
import com.hy.ioms.view.picture.PictureFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@Module
public class DeviceDetailModule {

    private final DeviceDetailActivity deviceDetailActivity;

    public DeviceDetailModule(DeviceDetailActivity deviceDetailActivity) {
        this.deviceDetailActivity = deviceDetailActivity;
    }

    @Named("device_detail")
    @Provides
    @AppScope
    IView provideIView() {
        return deviceDetailActivity;
    }

    @Named("device_detail")
    @Provides
    @AppScope
    List<Fragment> provideFragmentList(DeviceVO deviceVO) {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(InformationFragment.newInstance(deviceVO));
        fragmentList.add(PictureFragment.newInstance(deviceVO));
        fragmentList.add(AlarmFragment.newInstance(deviceVO));
        return fragmentList;
    }

    @Provides
    @AppScope
    DeviceVO provideDeviceVO() {
        return this.deviceDetailActivity.getDeviceVO();
    }


}
