package com.hy.ioms.utils.net;

import android.content.SharedPreferences;
import android.util.Log;

import com.hy.ioms.Config;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Flowable;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by wsw on 2017/4/12.
 */

public class SaveCookiesInterceptor implements Interceptor {
    private static final String TAG = "SaveCookiesInterceptor";
    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    public SaveCookiesInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Flowable.fromIterable(originalResponse.headers("Set-Cookie"))
                    .map(s -> s.split(";")[0])
                    .subscribe(cookie -> {
                        if (cookie.split("=").length > 1) {
                            if (cookie.contains(Config.SP_CSRF_TOKEN)) {
                                String csrf = cookie.split("=")[1];
                                Log.i(TAG, "save X-CSRF-TOKEN: " + csrf);
                                editor.putString(Config.SP_CSRF_TOKEN, csrf);
                            } else if (cookie.contains(Config.SP_JSESSIONID)) {

                                String jsessionid = cookie.split("=")[1];
                                Log.i(TAG, "save JSESSIONID: " + jsessionid);
                                editor.putString(Config.SP_JSESSIONID, jsessionid);

                            } else if (cookie.contains(Config.SP_REMEMBER_ME)) {
                                String rememberMe = cookie.split("=")[1];
                                Log.i(TAG, "save remember-me: " + rememberMe);
                                editor.putString(Config.SP_REMEMBER_ME, rememberMe);
                            }
                        }
                        editor.apply();
                    }, throwable -> Log.e(TAG, "accept: ", throwable), () -> {
                        String cookie = CookieUtils.saveCookie(sharedPreferences);
                        Log.i(TAG, "save cookie " + cookie);
                        editor.putString(Config.SP_COOKIE, cookie);
                        editor.apply();
                    });


        }

        return originalResponse;
    }
}