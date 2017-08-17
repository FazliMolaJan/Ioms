package com.hy.ioms;

import com.hy.ioms.model.net.IomsApi;
import com.hy.ioms.utils.net.CookieUtils;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wsw on 2017/8/3.
 */

public class MockRetrofit {
    private static String baseUrl = "http://www7.ioms.com.cn:9090";
//    private static String baseUrl = "http://172.16.16.121:8080";
    private static String CSRF_TOKEN = "";
    private static String JSESSIONID = "";
    private static String REMEMBER_ME = "";
    private static String COOKIE = "";


    public static IomsApi getInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Response originalResponse = chain.proceed(request);
                    if (request.url().toString().contains("authentic")) {
                        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                            Flowable.fromIterable(originalResponse.headers("Set-Cookie"))
                                    .map(s -> s.split(";")[0])
                                    .doOnNext(cookie -> {
                                        if (cookie.split("=").length > 1) {
                                            if (cookie.contains(Config.SP_CSRF_TOKEN)) {
                                                CSRF_TOKEN = cookie.split("=")[1];
                                            } else if (cookie.contains(Config.SP_JSESSIONID)) {
                                                JSESSIONID = cookie.split("=")[1];
                                            } else if (cookie.contains(Config.SP_REMEMBER_ME)) {
                                                REMEMBER_ME = cookie.split("=")[1];
                                            }
                                        }
                                    })
                                    .subscribe(cookie -> COOKIE = CookieUtils.getCookie(CSRF_TOKEN, JSESSIONID, REMEMBER_ME));
                        }
                    }
                    return originalResponse;
                })
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    if (!request.url().toString().endsWith("authenticate")) {
                        final Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("Cookie", COOKIE);
                        builder.addHeader("JSESSIONID", JSESSIONID);
                        builder.addHeader("remember-me", REMEMBER_ME);
                        builder.addHeader("X-CSRF-TOKEN", CSRF_TOKEN);
                        return chain.proceed(builder.build());
                    } else {
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build().create(IomsApi.class);
    }
}
