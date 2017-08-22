package com.hy.ioms.view.alarm;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.hy.ioms.R;
import com.hy.ioms.databinding.FragmentAlarmListBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.alarm.AlarmModule;
import com.hy.ioms.di.alarm.DaggerAlarmComponent;
import com.hy.ioms.view.base.BaseFragment;
import com.hy.ioms.view.ui.recycler.MultipleTypeAdapter;
import com.hy.ioms.view.ui.spinner.SimpleSpinnerAdapter;

import javax.inject.Inject;
import javax.inject.Named;

import vm.AlarmPageViewModel;
import vm.EventViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/22.
 */

public class AlarmFragment extends BaseFragment<FragmentAlarmListBinding> {
    @Inject
    AlarmPageViewModel alarmPageViewModel;

    @Inject
    EventViewModel eventViewModel;

    @Inject
    MultipleTypeAdapter multipleTypeAdapter;

    @Inject
    @Named("alarm")
    SimpleSpinnerAdapter simpleSpinnerAdapter;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerAlarmComponent.builder()
                .appComponent(appComponent)
                .alarmModule(new AlarmModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_alarm_list;
    }

    @Override
    protected void beforeSetViews() {
        b.setEvent(eventViewModel);
        b.setVm(alarmPageViewModel);
    }

    @Override
    protected void setViews() {
        b.spAlarmType.setAdapter(simpleSpinnerAdapter);
        b.alarmContent.fragmentPictureRv.setHasFixedSize(true);
        b.alarmContent.fragmentPictureRv.setAdapter(multipleTypeAdapter);
        b.alarmContent.fragmentPictureRv.setLayoutManager(new LinearLayoutManager(getContext()));

        b.alarmContent.fragmentPictureRefresh.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        b.alarmContent.fragmentPictureRefresh.setOnRefreshListener(() -> alarmPageViewModel.refresh());
    }

    @Override
    protected void doTransaction() {
        alarmPageViewModel.refresh();
    }

    public static AlarmFragment newInstance() {
        AlarmFragment fragment = new AlarmFragment();
        Bundle args = new Bundle();
//        args.putParcelable(ARG_DEVICE_VO, deviceVO);
        fragment.setArguments(args);
        return fragment;
    }
}
