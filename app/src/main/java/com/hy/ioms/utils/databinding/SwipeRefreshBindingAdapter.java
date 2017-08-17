package com.hy.ioms.utils.databinding;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

import com.hy.ioms.view.IView;

import vm.BasePageDataViewModel;
import vm.IBaseDataViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/17.
 */
@SuppressWarnings("unused")
public class SwipeRefreshBindingAdapter {
    /**
     * Reloads the data when the pull-to-refresh is triggered.
     * <p>
     * Creates the {@code android:onRefresh} for a {@link SwipeRefreshLayout}
     * that takes a {@link BasePageDataViewModel}.
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter("onRefresh")
    public static void setSwipeRefreshLayoutOnRefreshListener(SwipeRefreshLayout swipeRefreshLayout,
                                                              IBaseDataViewModel baseDataViewModel) {
        swipeRefreshLayout.setOnRefreshListener(baseDataViewModel::refresh);
    }

    /**
     * Reloads the data when the pull-to-refresh is triggered.
     * <p>
     * Creates the {@code android:onRefresh} for a {@link SwipeRefreshLayout}
     * that takes a {@link BasePageDataViewModel}.
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter("refresh_state")
    public static void setSwipeRefreshLayoutState(SwipeRefreshLayout swipeRefreshLayout,
                                                  int state) {
        if (state == IView.IDLE) {
            swipeRefreshLayout.setRefreshing(false);
        } else if (state == IView.REFRESHING) {
            swipeRefreshLayout.setRefreshing(true);
        }
    }
}
