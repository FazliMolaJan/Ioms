package com.hy.ioms.view.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Toast;

import com.hy.ioms.R;
import com.hy.ioms.databinding.ActivityMainBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.main.DaggerMainComponent;
import com.hy.ioms.view.base.BaseActivity;
import com.hy.ioms.view.device.DeviceListFragment;
import com.hy.ioms.view.picture.PictureFragment;
import com.hy.ioms.view.ui.viewpager.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vm.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    public static final int DEVICE = 0;
    public static final int PICTURE = 1;
    public static final int ALARM = 2;

    private MenuItem menuItem;

    private long mExitTime;

    @Inject
    MainViewModel mainViewModel;

    @Inject
    List<Fragment> fragmentList;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void beforeSetViews() {
        b.setVm(mainViewModel);
    }

    @Override
    protected void setViews() {
        // TODO: 2017/8/16 等待修改为使用databinding的方式来进行切换
        b.navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_device:
                    b.viewpager.setCurrentItem(DEVICE);
                    return true;
                case R.id.navigation_picture:
                    b.viewpager.setCurrentItem(PICTURE);
                    return true;
                case R.id.navigation_alarm:
                    b.viewpager.setCurrentItem(ALARM);
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
        b.viewpager.setOnTouchListener((v, event) -> true);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        b.viewpager.setAdapter(fragmentAdapter);
    }

    @Override
    protected void doTransaction() {

    }

    public static void gotoActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            //2.保存当前时间
            mExitTime = System.currentTimeMillis();
            //3.提示
            Toast.makeText(this, R.string.exit_message, Toast.LENGTH_SHORT).show();
        } else {
            //4.点击的时间差小于2000，调用父类onBackPressed方法执行退出。
            super.onBackPressed();
        }
    }
}
