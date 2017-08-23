package com.hy.ioms.di.device.detail;

import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.di.device.DeviceModule;
import com.hy.ioms.view.device.detail.DeviceDetailActivity;

import dagger.Component;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@AppScope
@Component(dependencies = AppComponent.class, modules = DeviceDetailModule.class)
public interface DeviceDetailComponent {
    void inject(DeviceDetailActivity deviceDetailActivity);
}
