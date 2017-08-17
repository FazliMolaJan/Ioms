package com.hy.ioms;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppModule;
import com.hy.ioms.di.DaggerAppComponent;
import com.hy.ioms.di.net.ApiServiceModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by wsw on 2017/7/13.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }

//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
//        } else {
//            Timber.plant(new CrashReportingTree());
//        }

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

