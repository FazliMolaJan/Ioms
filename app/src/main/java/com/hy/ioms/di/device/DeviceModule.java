package com.hy.ioms.di.device;

import com.hy.ioms.di.AppScope;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.service.DeviceDataService;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.ui.recycler.FooterItem;
import com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter;

import java.util.ArrayList;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import vm.DeviceFilterViewModel;
import vm.DevicePageDataViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/14.
 */

@Module
public class DeviceModule {
    private final IView iView;

    public DeviceModule(IView iView) {
        this.iView = iView;
    }

    @Named("device")
    @Provides
    @AppScope
    IView provideIView() {
        return iView;
    }

    @Provides
    @AppScope
    DevicePageDataViewModel provideDevicePageDataViewModel(DeviceDataService deviceDataService,
                                                           PagingParams pagingParams,
                                                           FooterItem footerItem,
                                                           @Named("device") IView view, FilterDTO filterDTO) {
        return new DevicePageDataViewModel(deviceDataService, pagingParams, footerItem, view,filterDTO);
    }

    @Provides
    @AppScope
    DeviceFilterViewModel provideDeviceFilterViewModel(DeviceDataService deviceDataService,@Named("device") IView view) {
        return new DeviceFilterViewModel(deviceDataService,view);
    }
}
