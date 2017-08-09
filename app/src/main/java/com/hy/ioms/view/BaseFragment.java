package com.hy.ioms.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hy.ioms.App;
import com.hy.ioms.di.AppComponent;

/**
 * fragment基类封装
 * Created by wsw on 2017/4/8.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    protected T b;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.get(this.getContext()).getAppComponent());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        beforeSetViews();//setViewModule
        setViews();//设置界面
        return b.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doTransaction(); //开始业务逻辑
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    @LayoutRes
    protected abstract int getLayoutResId();

    protected abstract void beforeSetViews();

    protected abstract void setViews();

    protected abstract void doTransaction();

}