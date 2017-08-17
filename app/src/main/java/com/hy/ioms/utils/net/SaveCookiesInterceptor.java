package com.hy.ioms.utils.net;

import android.content.SharedPreferences;
import android.util.Log;

import com.hy.ioms.Config;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wsw on 2017/4/12.
 */

public class SaveCookiesInterceptor implements Interceptor {
    private static final String TAG = "SaveCookiesInterceptor";

    @Inject
    public SaveCookiesInterceptor(@Named("net") SharedPreferences netSharedPreferences) {
        this.sharedPreferences = netSharedPreferences;
    }

    private SharedPreferences sharedPreferences;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response originalResponse = chain.proceed(request);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (request.url().toString().contains("authentic")) {
            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                Flowable.fromIterable(originalResponse.headers("Set-Cookie"))
                        .map(s -> s.split(";")[0])
                        .doOnNext(cookie -> {
                            if (cookie.split("=").length > 1) {
                                if (cookie.contains(Config.SP_CSRF_TOKEN)) {
                                    String csrf = cookie.split("=")[1];
                                    Log.i(TAG, "save X-CSRF-TOKEN: " + csrf);
                                    editor.putString(Config.SP_CSRF_TOKEN, csrf).apply();
                                } else if (cookie.contains(Config.SP_JSESSIONID)) {
                                    String jsessionid = cookie.split("=")[1];
                                    Log.i(TAG, "save JSESSIONID: " + jsessionid);
                                    editor.putString(Config.SP_JSESSIONID, jsessionid).apply();
                                } else if (cookie.contains(Config.SP_REMEMBER_ME)) {
                                    String rememberMe = cookie.split("=")[1];
                                    Log.i(TAG, "save remember-me: " + rememberMe);
                                    editor.putString(Config.SP_REMEMBER_ME, rememberMe).apply();
                                }
                            }
                        })
                        .toList()
                        .subscribe(strings -> CookieUtils.saveCookie(sharedPreferences));
            }
        }

        return originalResponse;
    }
}