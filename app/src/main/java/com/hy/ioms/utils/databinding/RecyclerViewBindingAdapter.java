package com.hy.ioms.utils.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hy.ioms.view.IView;
import com.hy.ioms.view.ui.recycler.FooterItem;
import com.hy.ioms.view.ui.recycler.MultipleTypeAdapter;

import java.util.List;

import vm.BasePageDataViewModel;

/**
 * ${description}
 * Created by wsw on 2017/8/17.
 */
@SuppressWarnings("unused")
public class RecyclerViewBindingAdapter {

    /**
     * RecyclerView 数据绑定
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static void setRecyclerViewItem(RecyclerView recyclerView, List<MultipleTypeAdapter.IItem> items) {
        MultipleTypeAdapter multipleTypeAdapter = (MultipleTypeAdapter) recyclerView.getAdapter();
        multipleTypeAdapter.setItem(items);
    }

    /**
     * RecyclerView 数据绑定
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter({"is_loading", "footer_item"})
    public static void addRecyclerViewLoadItem(RecyclerView recyclerView, boolean isLoading, FooterItem footerItem) {
        MultipleTypeAdapter multipleTypeAdapter = (MultipleTypeAdapter) recyclerView.getAdapter();
        int index = multipleTypeAdapter.findPos(footerItem);
        if (isLoading) {
            if (index < 0) {
                multipleTypeAdapter.addItem(footerItem);
            }
        } else {
            if (index > 0) {
                multipleTypeAdapter.removeItem(footerItem);
            }
        }
    }

    /**
     * RecycleView滚动监听，自动加载
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter("recycler_scroll")
    public static void addOnScrollListener(RecyclerView recyclerView, BasePageDataViewModel baseDataViewModel) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int lastVisibleItem = 0;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    lastVisibleItem = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                } else if (layoutManager instanceof LinearLayoutManager) {
                    lastVisibleItem = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                }

                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                //lastVisibleItem >= totalItemCount - 4 表示剩下4个item自动加载
                // dy>0 表示向下滑动
                if (baseDataViewModel.pagingParams.totalCount > totalItemCount
                        && lastVisibleItem >= totalItemCount - 4 && dy > 0) {
                    //正在加载或者正在刷新,不应该再去加载数据,这里进行判断
                    if (baseDataViewModel.getCurrentState() == IView.IDLE) {
                        baseDataViewModel.loadMore();//这里多线程也要手动控制isLoadingMore
                    } else {
                        //加载数据
                        Log.d("recycler_scroll", "recycler is loading......please wait");
                    }
                }
            }
        });
    }
}
