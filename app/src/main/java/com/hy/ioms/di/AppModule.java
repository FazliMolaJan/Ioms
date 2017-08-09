package com.hy.ioms.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hy.ioms.BuildConfig;
import com.hy.ioms.utils.rx.RxApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return mContext.getSharedPreferences(BuildConfig.SP_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @Singleton
    RxApiManager provideRxApiManager() {
        return RxApiManager.get();
    }
}
