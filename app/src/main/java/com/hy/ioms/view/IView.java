package com.hy.ioms.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by wsw on 2017/6/13.
 */

public interface IView {
    <T> LifecycleTransformer<T> bindLifecycle();

    Context getContext();

    FragmentActivity getFragmentActivity();
}
