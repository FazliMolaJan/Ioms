package com.hy.ioms.di.net;


import android.content.Context;

import com.hy.ioms.BuildConfig;
import com.hy.ioms.Config;
import com.hy.ioms.model.net.IomsApi;
import com.hy.ioms.utils.net.NullOnEmptyConverterFactory;
import com.hy.ioms.utils.net.ReadCookiesInterceptor;
import com.hy.ioms.utils.net.SaveCookiesInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 提供APIServer的类 Create By :wsw 2016-12-06 21:31
 */
@Module
public class ApiServiceModule {

    // Retrofit 2.0的请求
    @Provides
    @Singleton
    IomsApi provideIomsApi(Context context, ReadCookiesInterceptor readCookiesInterceptor,
                           SaveCookiesInterceptor saveCookiesInterceptor,
                           NullOnEmptyConverterFactory nullOnEmptyConverterFactory) {
        OkHttpClient httpClient;
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(readCookiesInterceptor)
                    .addInterceptor(saveCookiesInterceptor)
                    .build();
        } else {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(readCookiesInterceptor)
                    .addInterceptor(saveCookiesInterceptor)
                    .build();
        }

        return new Retrofit.Builder()
                .baseUrl(Config.API_HOST)
                .addConverterFactory(nullOnEmptyConverterFactory)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build().create(IomsApi.class);
    }
}
