package com.hy.ioms.utils.net;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/4/6.
 */

public class CookiesInterceptor implements Interceptor {

    private Context context;

    public CookiesInterceptor(Context context) {
        super();
        this.context = context;

    }

    private String cookieStr = "";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            final StringBuilder cookieBuffer = new StringBuilder();
            //最近在学习RxJava,这里用了RxJava的相关API大家可以忽略,用自己逻辑实现即可.大家可以用别的方法保存cookie数据
            for (String s : originalResponse.headers("Set-Cookie")) {
                String[] cookieArray = s.split(";");
                cookieBuffer.append(cookieArray[0]).append(";");
            }
            cookieStr = cookieBuffer.toString();
        }

        return originalResponse;
    }
}
