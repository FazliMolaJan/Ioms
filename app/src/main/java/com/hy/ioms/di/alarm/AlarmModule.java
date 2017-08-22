package com.hy.ioms.di.alarm;

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
import vm.AlarmPageViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@Module
public class AlarmModule {
    private final IView iView;

    public AlarmModule(IView iView) {
        this.iView = iView;
    }

    @Named("alarm")
    @Provides
    @AppScope
    IView provideIView() {
        return iView;
    }

    @Provides
    @AppScope
    AlarmPageViewModel provideAlarmPageViewModel(DeviceDataService deviceDataService,
                                                 PagingParams pagingParams,
                                                 FooterItem footerItem,
                                                 @Named("alarm") IView view, FilterDTO filterDTO) {
        return new AlarmPageViewModel(deviceDataService, pagingParams, footerItem, view, filterDTO);
    }

    @Provides
    @AppScope
    List<SpinItemVO> providePictureTypes() {
        List<SpinItemVO> list = new ArrayList<>();
        list.add(new SpinItemVO("山火报警", 0, AlarmPageViewModel.FIRE));
        list.add(new SpinItemVO("外破报警", 0, AlarmPageViewModel.BREAK));
        return list;
    }

    @Named("alarm")
    @Provides
    @AppScope
    SimpleSpinnerAdapter provideArrayAdapter(List<SpinItemVO> pictureTypes, @Named("alarm") IView iView) {
        return new SimpleSpinnerAdapter(pictureTypes, iView.getContext());
    }
}
