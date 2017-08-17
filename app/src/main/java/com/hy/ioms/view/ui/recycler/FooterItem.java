package com.hy.ioms.view.ui.recycler;


import com.hy.ioms.R;

import javax.inject.Inject;

/**
 * Created by wsw on 2017/4/12.
 */

public class FooterItem extends BaseItem {
    public final static int LOADING = 0;
    public final static int ERROR = 1;
    public final static int NO_MORE = 2;
    public final static int NO_DATA = 3;

    private int state = LOADING;

    @Inject
    public FooterItem() {
    }

    @Override
    public int getLayout() {
        return R.layout.item_footer;
    }

    public FooterItem setState(int state) {
        this.state = state;
        return this;
    }

    public boolean isLoading() {
        return state == LOADING;
    }

    public boolean isError() {
        return state == ERROR;
    }

    public boolean isNoMore() {
        return state == NO_MORE;
    }

    public boolean isNoData() {
        return state == NO_DATA;
    }

}
