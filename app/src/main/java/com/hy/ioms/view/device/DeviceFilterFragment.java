package com.hy.ioms.view.device;

import android.os.Bundle;

import com.hy.ioms.App;
import com.hy.ioms.R;
import com.hy.ioms.databinding.BottomSheetDeviceBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.device.DaggerDeviceComponent;
import com.hy.ioms.di.device.DeviceModule;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.view.base.BaseBottomSheetDialogFragment;
import com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.ArrayList;

import javax.inject.Inject;

import vm.DeviceFilterViewModel;
import vm.EventViewModel;

import static com.hy.ioms.Config.ARG_FILTER_DTO;

/**
 * ${description}
 * Created by wsw on 2017/8/16.
 */

public class DeviceFilterFragment extends BaseBottomSheetDialogFragment<BottomSheetDeviceBinding> {
    @Inject
    EventViewModel eventViewModel;

    @Inject
    DeviceFilterViewModel deviceFilterViewModel;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerDeviceComponent.builder()
                .appComponent(App.get(getContext()).getAppComponent())
                .deviceModule(new DeviceModule(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.bottom_sheet_device;
    }

    @Override
    protected void beforeSetViews() {
        b.setVm(deviceFilterViewModel);
        b.setEvent(eventViewModel);
    }

    @Override
    protected void setViews() {
        FilterSpinnerAdapter companyAdapter = new FilterSpinnerAdapter(new ArrayList<>(), getContext(), FilterSpinnerAdapter.COMPANY);
        FilterSpinnerAdapter circuitAdapter = new FilterSpinnerAdapter(new ArrayList<>(), getContext(), FilterSpinnerAdapter.CIRCUIT);
        FilterSpinnerAdapter poleAdapter = new FilterSpinnerAdapter(new ArrayList<>(), getContext(), FilterSpinnerAdapter.POLE);

        b.companySpinner.setAdapter(companyAdapter);
        b.circuitSpinner.setAdapter(circuitAdapter);
        b.poleSpinner.setAdapter(poleAdapter);
    }

    @Override
    protected void doTransaction() {
        deviceFilterViewModel.filter.set(getArguments().getParcelable(ARG_FILTER_DTO));
        deviceFilterViewModel.getFilterTreeNode();
    }

    public static DeviceFilterFragment newInstance(FilterDTO filterDTO) {
        final DeviceFilterFragment orderFragment = new DeviceFilterFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_FILTER_DTO, filterDTO);
        orderFragment.setArguments(args);
        return orderFragment;
    }
}
