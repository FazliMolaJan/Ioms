package com.hy.ioms.view.device;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.hy.ioms.R;
import com.hy.ioms.databinding.FragmentDeviceListBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.device.DaggerDeviceComponent;
import com.hy.ioms.di.device.DeviceModule;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.utils.event.EventMessage;
import com.hy.ioms.view.BaseFragment;
import com.hy.ioms.view.main.MainActivity;
import com.hy.ioms.view.ui.recycler.MultipleTypeAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import vm.DevicePageDataViewModel;
import vm.EventViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/14.
 */

public class DeviceListFragment extends BaseFragment<FragmentDeviceListBinding> {

    @Inject
    DevicePageDataViewModel devicePageDataViewModel;

    @Inject
    MultipleTypeAdapter multipleTypeAdapter;

    @Inject
    EventViewModel eventViewModel;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerDeviceComponent.builder()
                .appComponent(appComponent)
                .deviceModule(new DeviceModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_device_list;
    }

    @Override
    protected void beforeSetViews() {
        eventViewModel.setOnClick(view -> {
            if (view == b.filter) {
                DeviceFilterBottomSheetDialogFragment deviceFilterBottomSheetDialogFragment =
                        DeviceFilterBottomSheetDialogFragment.newInstance(devicePageDataViewModel.getFilterDTO());
                deviceFilterBottomSheetDialogFragment.show(getChildFragmentManager(), null);
            }
        });

        b.setVm(devicePageDataViewModel);
        b.setEvent(eventViewModel);
    }

    @Override
    protected void setViews() {
        b.toolbar.setTitle(R.string.device_fragment_title);
        b.deviceContent.deviceRecyclerView.setHasFixedSize(true);
        b.deviceContent.deviceRecyclerView.setAdapter(multipleTypeAdapter);
        b.deviceContent.deviceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        b.deviceContent.swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        b.deviceContent.swipeRefreshLayout.setOnRefreshListener(() -> devicePageDataViewModel.refresh());
    }

    @Override
    protected void doTransaction() {
        devicePageDataViewModel.refresh();
    }

    public static DeviceListFragment newInstance() {
        DeviceListFragment fragment = new DeviceListFragment();
        Bundle args = new Bundle();
//        args.putParcelable(ARG_DEVICE_VO, deviceVO);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleFilterEvent(FilterDTO filterDTO) {
        devicePageDataViewModel.setFilterDTO(filterDTO);
        devicePageDataViewModel.refresh();
    }
}
