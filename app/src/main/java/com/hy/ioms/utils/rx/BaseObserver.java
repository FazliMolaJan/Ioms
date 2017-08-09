package com.hy.ioms.utils.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by wsw on 2017/6/13.
 */

public abstract class BaseObserver<T> implements Observer<T> {


    @Override
    public void onSubscribe(Disposable d) {

    }


    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
