package com.hy.ioms.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hy.ioms.App;
import com.hy.ioms.di.net.ApiServiceModule;
import com.hy.ioms.model.net.IomsApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {com.hy.ioms.di.AppModule.class, ApiServiceModule.class})
public interface AppComponent {

    void inject(App app);

    IomsApi iomsApi();

    Context context();

    Gson gson();

    SharedPreferences netSharedPreferences();

    SharedPreferences normalSharedPreferences();



}
