package com.hy.ioms.view.device;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.hy.ioms.App;
import com.hy.ioms.databinding.BottomSheetDeviceBinding;
import com.hy.ioms.di.device.DaggerDeviceComponent;
import com.hy.ioms.di.device.DeviceModule;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.view.IView;
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

public class DeviceFilterBottomSheetDialogFragment extends BottomSheetDialogFragment implements IView {

    private BottomSheetDeviceBinding binding;

    @Inject
    EventViewModel eventViewModel;

    @Inject
    DeviceFilterViewModel deviceFilterViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        DaggerDeviceComponent.builder()
                .appComponent(App.get(getContext()).getAppComponent())
                .deviceModule(new DeviceModule(this))
                .build().inject(this);

        binding = BottomSheetDeviceBinding.inflate(inflater, container, false);

        binding.setVm(deviceFilterViewModel);
        binding.setEvent(eventViewModel);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FilterSpinnerAdapter companyAdapter = new FilterSpinnerAdapter(new ArrayList<>(), getContext(), FilterSpinnerAdapter.COMPANY);
        FilterSpinnerAdapter circuitAdapter = new FilterSpinnerAdapter(new ArrayList<>(), getContext(), FilterSpinnerAdapter.CIRCUIT);
        FilterSpinnerAdapter poleAdapter = new FilterSpinnerAdapter(new ArrayList<>(), getContext(), FilterSpinnerAdapter.POLE);

        binding.companySpinner.setAdapter(companyAdapter);
        binding.circuitSpinner.setAdapter(circuitAdapter);
        binding.poleSpinner.setAdapter(poleAdapter);

        deviceFilterViewModel.getFilter().set(getArguments().getParcelable(ARG_FILTER_DTO));
        deviceFilterViewModel.getFilterTreeNode();
    }

    public static DeviceFilterBottomSheetDialogFragment newInstance(FilterDTO filterDTO) {
        final DeviceFilterBottomSheetDialogFragment orderFragment = new DeviceFilterBottomSheetDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_FILTER_DTO, filterDTO);
        orderFragment.setArguments(args);
        return orderFragment;
    }

    @Override
    public <T> LifecycleTransformer<T> bindLifecycle() {
        return null;
    }

    @Override
    public LifecycleProvider getLifecycleProvider() {
        return null;
    }


}
