package com.hy.ioms.di.picture;

import android.widget.ArrayAdapter;

import com.hy.ioms.R;
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
import vm.DevicePageDataViewModel;
import vm.PicturePageViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@Module
public class PictureModule {
    private final IView iView;

    public PictureModule(IView iView) {
        this.iView = iView;
    }

    @Named("picture")
    @Provides
    @AppScope
    IView provideIView() {
        return iView;
    }

    @Provides
    @AppScope
    PicturePageViewModel providePicturePageViewModel(DeviceDataService deviceDataService,
                                                     PagingParams pagingParams,
                                                     FooterItem footerItem,
                                                     @Named("picture") IView view, FilterDTO filterDTO) {
        return new PicturePageViewModel(deviceDataService, pagingParams, footerItem, view, filterDTO);
    }

    @Provides
    @AppScope
    List<SpinItemVO> providePictureTypes() {
        List<SpinItemVO> list = new ArrayList<>();
        list.add(new SpinItemVO("计划任务图片", 0, PicturePageViewModel.SCHEDULED));
        list.add(new SpinItemVO("手动拍照图片", 0, PicturePageViewModel.MANUAL));
        return list;
    }

    @Provides
    @AppScope
    SimpleSpinnerAdapter provideArrayAdapter(List<SpinItemVO> pictureTypes, @Named("picture") IView iView) {
        return new SimpleSpinnerAdapter(pictureTypes,iView.getContext());
    }
}
