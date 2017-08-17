package com.hy.ioms.view.ui.recycler;

import android.databinding.BaseObservable;
import android.view.View;

import com.hy.ioms.BR;


/**
 * Created by wsw on 2017/4/11.
 */

public abstract class BaseItem extends BaseObservable implements MultipleTypeAdapter.IItem{
    @Override
    public int getVariableId() {
        return BR.item;
    }

    ////////////////////////////////////////////
    // handle event
    private View.OnClickListener onClickListener;

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
