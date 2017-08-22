package com.hy.ioms.di.alarm;

import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.view.alarm.AlarmFragment;

import dagger.Component;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@AppScope
@Component(dependencies = AppComponent.class, modules = AlarmModule.class)
public interface AlarmComponent {
    void inject(AlarmFragment alarmFragment);
}
