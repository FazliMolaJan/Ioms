package com.hy.ioms.di.main;

import android.support.v4.app.Fragment;

import com.hy.ioms.di.AppScope;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.alarm.AlarmFragment;
import com.hy.ioms.view.device.DeviceListFragment;
import com.hy.ioms.view.main.MainActivity;
import com.hy.ioms.view.picture.PictureFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * ${description}
 * Created by wsw on 2017/8/14.
 */

@Module
public class MainModule {
    private final MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @AppScope
    IView provideIView() {
        return mainActivity;
    }

    @Provides
    @AppScope
    List<Fragment> provideFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(DeviceListFragment.newInstance());
        fragmentList.add(PictureFragment.newInstance());
        fragmentList.add(AlarmFragment.newInstance());
        return fragmentList;
    }
}
