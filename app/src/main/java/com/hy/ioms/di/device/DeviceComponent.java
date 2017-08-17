package com.hy.ioms.di.device;

import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.di.login.LoginModule;
import com.hy.ioms.view.device.DeviceFilterBottomSheetDialogFragment;
import com.hy.ioms.view.device.DeviceListFragment;
import com.hy.ioms.view.main.MainActivity;

import dagger.Component;

/**
 * ${description}
 * Created by wsw on 2017/8/14.
 */

@AppScope
@Component(dependencies = AppComponent.class, modules = DeviceModule.class)
public interface DeviceComponent {
    void inject(DeviceListFragment deviceListFragment);

    void inject(DeviceFilterBottomSheetDialogFragment deviceFilterBottomSheetDialogFragment);
}
