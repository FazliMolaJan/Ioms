package com.hy.ioms.view.alarm;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hy.ioms.Config;
import com.hy.ioms.R;
import com.hy.ioms.databinding.FragmentAlarmListBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.alarm.AlarmModule;
import com.hy.ioms.di.alarm.DaggerAlarmComponent;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.view.base.BaseFragment;
import com.hy.ioms.view.ui.recycler.MultipleTypeAdapter;
import com.hy.ioms.view.ui.spinner.SimpleSpinnerAdapter;

import javax.inject.Inject;
import javax.inject.Named;

import vm.AlarmPageViewModel;
import vm.EventViewModel;

import static com.hy.ioms.Config.ARG_DEVICE_VO;

/**
 * ${description}
 * Created by wsw on 2017/8/22.
 */

public class AlarmFragment extends BaseFragment<FragmentAlarmListBinding> {

    public static final int MAIN = 0;
    public static final int DETAIL = 1;

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
        int type = getArguments().getInt(Config.ARG_ALARM_FRAGMENT_TYPE);
        switch (type) {
            case MAIN:
                b.spAlarmType.setAdapter(simpleSpinnerAdapter);
                break;
            case DETAIL:
                b.spAlarmType.setVisibility(View.GONE);
                DeviceVO deviceVO = getArguments().getParcelable(ARG_DEVICE_VO);
                assert deviceVO != null;
                alarmPageViewModel.getFilterDTO().setDeviceId(deviceVO.getId());
                alarmPageViewModel.type.set(getArguments().getInt(Config.ARG_ALARM_TYPE));
                break;
        }
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

    /**
     * 初始化,主界面使用
     */
    public static AlarmFragment newInstance() {
        AlarmFragment fragment = new AlarmFragment();
        Bundle args = new Bundle();
        args.putInt(Config.ARG_ALARM_FRAGMENT_TYPE, MAIN);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 初始化,详情界面使用
     *
     * @param deviceVO 设备VO
     */
    public static AlarmFragment newInstance(DeviceVO deviceVO) {
        AlarmFragment fragment = new AlarmFragment();
        Bundle args = new Bundle();
        args.putInt(Config.ARG_ALARM_FRAGMENT_TYPE, DETAIL);
        args.putParcelable(Config.ARG_DEVICE_VO, deviceVO);
        switch (deviceVO.getProjectType()) {
            case "山火":
                args.putInt(Config.ARG_ALARM_TYPE, AlarmPageViewModel.FIRE);
                break;
            case "外破":
                args.putInt(Config.ARG_ALARM_TYPE, AlarmPageViewModel.BREAK);
                break;
        }
        fragment.setArguments(args);
        return fragment;
    }
}
