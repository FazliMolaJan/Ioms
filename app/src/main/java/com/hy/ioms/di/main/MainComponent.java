package com.hy.ioms.di.main;

import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.di.login.LoginModule;
import com.hy.ioms.view.main.MainActivity;

import dagger.Component;

/**
 * ${description}
 * Created by wsw on 2017/8/14.
 */

@AppScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);

}
