package com.hy.ioms.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.hy.ioms.App;
import com.hy.ioms.di.AppComponent;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Create By :wsw
 * 2016-08-30 16:01
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends RxAppCompatActivity implements IView {
    protected T b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.get(this).getAppComponent());
        bindViews();//绑定界面
        beforeSetViews();//setViewModule
        setViews();//设置界面
        doTransaction(); //开始业务逻辑
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    @LayoutRes
    protected abstract int getLayoutResId();

    protected void bindViews() {
        b = DataBindingUtil.setContentView(this, getLayoutResId());
    }

    protected abstract void beforeSetViews();

    protected abstract void setViews();

    protected abstract void doTransaction();

    @Override
    public LifecycleProvider getLifecycleProvider() {
        return BaseActivity.this;
    }

    @Override
    public <S> LifecycleTransformer<S> bindLifecycle() {
        return bindToLifecycle();
    }
}
