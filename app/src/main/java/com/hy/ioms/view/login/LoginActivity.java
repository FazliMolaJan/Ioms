package com.hy.ioms.view.login;

import android.content.Context;

import com.hy.ioms.R;
import com.hy.ioms.databinding.ActivityLoginBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.login.DaggerLoginComponent;
import com.hy.ioms.di.login.LoginModule;
import com.hy.ioms.view.BaseActivity;

import javax.inject.Inject;

import vm.LoginViewModel;
import vm.UserViewModel;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    @Inject
    UserViewModel userViewModel;
    @Inject
    LoginViewModel loginViewModel;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        //初始化Dagger依赖
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void beforeSetViews() {
        userViewModel.getUser();
        //设置Layout内的data
        b.setUser(userViewModel);
        b.setVm(loginViewModel);
    }

    @Override
    protected void setViews() {
        b.toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(b.toolbar);
    }

    @Override
    protected void doTransaction() {

    }
}

