package com.hy.ioms.di.login;


import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.view.login.LoginActivity;

import dagger.Component;

/**
 * Create By :wsw
 * 2016-08-31 15:07
 */
@AppScope
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);

}
