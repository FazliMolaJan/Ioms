package com.hy.ioms.view;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.app.FragmentActivity;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wsw on 2017/6/13.
 */

public interface IView {
    <T> LifecycleTransformer<T> bindLifecycle();

    Context getContext();

    LifecycleProvider getLifecycleProvider();

    int IDLE = 0;
    int REFRESHING = 1;
    int LOADING = 2;

    //用 @IntDef "包住" 常量；
    // @Retention 定义策略
    // 声明构造器
    //空闲状态,刷新中,加载中
    @IntDef({IDLE, REFRESHING, LOADING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }
}
