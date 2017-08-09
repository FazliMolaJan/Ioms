package com.hy.ioms.di.login;

import android.content.SharedPreferences;

import com.hy.ioms.di.AppScope;
import com.hy.ioms.model.net.IomsApi;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.login.LoginActivity;

import dagger.Module;
import dagger.Provides;
import vm.LoginViewModel;

/**
 * login module 用于提供登录所需要的注入类
 * Created by Administrator on 2017/4/5.
 */
@Module
public class LoginModule {
    private final LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    @AppScope
    IView provideIView() {
        return loginActivity;
    }

    @Provides
    @AppScope
    LoginViewModel provideLoginViewModel(IomsApi iomsApi,
                                         SharedPreferences sharedPreferences, IView view) {
        return new LoginViewModel(iomsApi, sharedPreferences, view);
    }
}
