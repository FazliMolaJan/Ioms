package com.hy.ioms.utils.rx;

import android.content.Context;
import android.widget.Toast;

import com.hy.ioms.utils.net.NetworkUtil;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by wsw on 2017/4/20.
 */

public abstract class BaseSingleObserver<T> implements SingleObserver<T> {


    private Context context;

    public BaseSingleObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
            disposable.dispose();
        }
    }
    // FIXME: 2017/4/25 想要通过预处理来判断为空，不起作用，暂时还不知道怎么修改,等待后面修复
//    @Override
//    public void onSuccess(T t) {
//        if (t instanceof Collection) {
//            if (((Collection) t).size() < 1) {
//                throw new RuntimeException(context.getString(R.string.item_no_data_message));
//            }
//        }
//    }
}
