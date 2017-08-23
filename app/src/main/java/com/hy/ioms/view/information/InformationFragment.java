package com.hy.ioms.view.information;

import android.os.Bundle;

import com.hy.ioms.R;
import com.hy.ioms.databinding.FragmentDeviceInformationBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.information.DaggerInformationComponent;
import com.hy.ioms.di.information.InformationModule;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.view.base.BaseFragment;
import com.hy.ioms.view.picture.PictureFragment;

import javax.inject.Inject;

import vm.InformationViewModel;

import static com.hy.ioms.Config.ARG_DEVICE_VO;
import static com.hy.ioms.Config.ARG_PICTURE_FRAGMENT_TYPE;

/**
 * 设备Information Fragment
 * Created by wsw on 2017/8/23.
 */

public class InformationFragment extends BaseFragment<FragmentDeviceInformationBinding> {

    @Inject
    InformationViewModel informationViewModel;

    private DeviceVO deviceVO;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerInformationComponent.builder()
                .appComponent(appComponent)
                .informationModule(new InformationModule(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_device_information;
    }

    @Override
    protected void beforeSetViews() {
        deviceVO = getArguments().getParcelable(ARG_DEVICE_VO);
        assert deviceVO != null;
        informationViewModel.setDeviceCode(deviceVO.getCode());
        b.setVm(informationViewModel);
    }

    @Override
    protected void setViews() {

    }

    @Override
    protected void doTransaction() {
        informationViewModel.loadMore();
    }

    /**
     * 初始化,详情界面使用
     *
     * @param deviceVO 设备VO
     */
    public static InformationFragment newInstance(DeviceVO deviceVO) {
        InformationFragment fragment = new InformationFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_DEVICE_VO, deviceVO);
        fragment.setArguments(args);
        return fragment;
    }
}
