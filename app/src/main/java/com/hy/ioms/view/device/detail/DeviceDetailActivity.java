package com.hy.ioms.view.device.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.hy.ioms.Config;
import com.hy.ioms.R;
import com.hy.ioms.databinding.ActivityDeviceDetailBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.device.DeviceModule;
import com.hy.ioms.di.device.detail.DaggerDeviceDetailComponent;
import com.hy.ioms.di.device.detail.DeviceDetailModule;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.view.base.BaseActivity;
import com.hy.ioms.view.main.MainActivity;
import com.hy.ioms.view.ui.viewpager.FragmentAdapter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class DeviceDetailActivity extends BaseActivity<ActivityDeviceDetailBinding> {

    public static final int STATE = 0;
    public static final int PICTURE = 1;
    public static final int ALARM = 2;
    public static final int OPERATE = 3;

    private MenuItem menuItem;

    @Inject
    @Named("device_detail")
    List<Fragment> fragmentList;

    public static void gotoActivity(Context context, DeviceVO deviceVO) {
        Intent intent = new Intent(context, DeviceDetailActivity.class);
        intent.putExtra(Config.ARG_DEVICE_VO, deviceVO);
        context.startActivity(intent);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerDeviceDetailComponent.builder()
                .appComponent(appComponent)
                .deviceDetailModule(new DeviceDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_device_detail;
    }

    @Override
    protected void beforeSetViews() {

    }

    @Override
    protected void setViews() {
        b.navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_state:
                    b.viewpager.setCurrentItem(STATE);
                    return true;
                case R.id.navigation_picture:
                    b.viewpager.setCurrentItem(PICTURE);
                    return true;
                case R.id.navigation_alarm:
                    b.viewpager.setCurrentItem(ALARM);
                    return true;
                case R.id.navigation_operate:
                    b.viewpager.setCurrentItem(OPERATE);
                    return true;
            }
            return false;
        });

        b.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    b.navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = b.navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //禁止ViewPager滑动
//        b.viewpager.setOnTouchListener((v, event) -> true);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        b.viewpager.setAdapter(fragmentAdapter);
    }

    @Override
    protected void doTransaction() {

    }

    public DeviceVO getDeviceVO() {
        return getIntent().getParcelableExtra(Config.ARG_DEVICE_VO);
    }
}
