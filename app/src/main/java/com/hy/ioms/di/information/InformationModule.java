package com.hy.ioms.di.information;

import com.hy.ioms.di.AppScope;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.service.DeviceDataService;
import com.hy.ioms.model.vo.SpinItemVO;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.ui.recycler.FooterItem;
import com.hy.ioms.view.ui.spinner.SimpleSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import vm.InformationViewModel;
import vm.PicturePageViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@Module
public class InformationModule {
    private final IView iView;

    public InformationModule(IView iView) {
        this.iView = iView;
    }

    @Named("information")
    @Provides
    @AppScope
    IView provideIView() {
        return iView;
    }

    @Provides
    @AppScope
    InformationViewModel provideInformationViewModel(DeviceDataService deviceDataService,
                                                     @Named("information") IView view) {
        return new InformationViewModel(deviceDataService, view);
    }
}
