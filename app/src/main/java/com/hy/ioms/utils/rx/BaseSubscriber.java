package com.hy.ioms.utils.rx;

import android.content.Context;
import android.widget.Toast;

import com.hy.ioms.utils.net.NetworkUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by wsw on 2017/4/20.
 */

public abstract class BaseSubscriber<T> implements Subscriber<T> {

    private Context context;

    public BaseSubscriber(Context context) {
        this.context = context;
    }

    public void onSubscribe(Subscription s) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
            s.cancel();//取消向下发送请求
            onComplete();//结束信息
        } else {
            s.request(Long.MAX_VALUE);
        }
    }
}
