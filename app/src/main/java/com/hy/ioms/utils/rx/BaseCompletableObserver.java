package com.hy.ioms.utils.rx;

import android.content.Context;
import android.widget.Toast;

import com.hy.ioms.utils.net.NetworkUtil;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/**
 * ${description}
 * Created by wsw on 2017/8/12.
 */

public abstract class BaseCompletableObserver implements CompletableObserver {

    private Context context;

    public BaseCompletableObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
            disposable.dispose();
        }
    }
}
