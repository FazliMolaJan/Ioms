package com.hy.ioms.view.device.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.hy.ioms.Config;
import com.hy.ioms.R;
import com.hy.ioms.databinding.ActivityDeviceDetailBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.device.DeviceModule;
import com.hy.ioms.di.device.detail.DaggerDeviceDetailComponent;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.view.base.BaseActivity;
import com.hy.ioms.view.main.MainActivity;

public class DeviceDetailActivity extends BaseActivity<ActivityDeviceDetailBinding> {

    public static void gotoActivity(Context context, DeviceVO deviceVO) {
        Intent intent = new Intent(context, DeviceDetailActivity.class);
        intent.putExtra(Config.ARG_DEVICE_VO, deviceVO);
        context.startActivity(intent);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerDeviceDetailComponent.builder()
                .appComponent(appComponent)
                .deviceModule(new DeviceModule(this))
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

    }

    @Override
    protected void doTransaction() {

    }
}
