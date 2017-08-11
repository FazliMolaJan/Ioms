package com.hy.ioms.utils.net;

import android.content.SharedPreferences;
import android.util.Log;

import com.hy.ioms.Config;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wsw on 2017/4/12.
 */

public class ReadCookiesInterceptor implements Interceptor {
    private static final String TAG = "ReadCookiesInterceptor";

    @Inject
    public ReadCookiesInterceptor(@Named("net") SharedPreferences netSharedPreferences) {
        this.sharedPreferences = netSharedPreferences;
    }

    private SharedPreferences sharedPreferences;

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        String cookie = sharedPreferences.getString(Config.SP_COOKIE, Config.DEFAULT_COOKIE);
        String csrfToken = sharedPreferences.getString(Config.SP_CSRF_TOKEN, Config
                .DEFAULT_CSRF_TOKEN);
        String jsessionid = sharedPreferences.getString(Config.SP_JSESSIONID, Config
                .DEFAULT_JSESSIONID);
        String rememberMe = sharedPreferences.getString(Config.SP_REMEMBER_ME, Config
                .DEFAULT_REMEMBER_ME);
        Log.i(TAG, "cookie: " + cookie);
        Log.i(TAG, "csrfToken: " + csrfToken);
        builder.addHeader("Cookie", cookie);
        builder.addHeader("JSESSIONID", jsessionid);
        builder.addHeader("remember-me", rememberMe);
        builder.addHeader("X-CSRF-TOKEN", csrfToken);
        return chain.proceed(builder.build());
    }
}
