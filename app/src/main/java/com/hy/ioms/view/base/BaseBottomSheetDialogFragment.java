package com.hy.ioms.view.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hy.ioms.App;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.utils.rx.RxBottomSheetDialogFragment;
import com.hy.ioms.view.IView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * ${description}
 * Created by wsw on 2017/8/18.
 */

public abstract class BaseBottomSheetDialogFragment<T extends ViewDataBinding> extends RxBottomSheetDialogFragment implements IView {
    protected T b;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.get(this.getContext()).getAppComponent());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    @Override
    public <S> LifecycleTransformer<S> bindLifecycle() {
        return bindToLifecycle();
    }

    @Override
    public LifecycleProvider getLifecycleProvider() {
        return BaseBottomSheetDialogFragment.this;
    }
}
