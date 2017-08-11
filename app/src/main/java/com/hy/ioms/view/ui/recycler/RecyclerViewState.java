package com.hy.ioms.view.ui.recycler;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 定义了RecycleView的状态
 * Created by wsw on 2017/8/11.
 */

public class RecyclerViewState {
    public static final int IDIE = 0;
    public static final int refreshing = 1;
    public static final int loading = 2;

    //用 @IntDef "包住" 常量；
    // @Retention 定义策略
    // 声明构造器
    @IntDef({IDIE, refreshing, loading})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }


}
