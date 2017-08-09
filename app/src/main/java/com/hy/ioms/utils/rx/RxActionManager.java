package com.hy.ioms.utils.rx;

import org.reactivestreams.Subscription;

/**
 * Created by wsw on 2017/4/20.
 */
public interface RxActionManager<T> {
    void add(T tag, Subscription subscription);

    void remove(T tag);

    void cancel(T tag);

    void cancelAll();
}
