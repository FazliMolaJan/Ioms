package com.hy.ioms.view.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.hy.ioms.R;
import com.hy.ioms.databinding.ActivityTestBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.view.base.BaseActivity;
import com.hy.ioms.view.ui.recycler.MultipleTypeAdapter;

public class TestActivity extends BaseActivity<ActivityTestBinding> {
    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test;
    }

    @Override
    protected void beforeSetViews() {

    }

    @Override
    protected void setViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        b.testRv.setLayoutManager(linearLayoutManager);

        new LinearSnapHelper().attachToRecyclerView(b.testRv);

        b.testRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    notifyBackgroundChange();
                }
            }
        });

        MultipleTypeAdapter multipleTypeAdapter = new MultipleTypeAdapter();

        multipleTypeAdapter.addItem(new BatteryItem());
        multipleTypeAdapter.addItem(new BatteryItem());


    }

    @Override
    protected void doTransaction() {

    }
}
