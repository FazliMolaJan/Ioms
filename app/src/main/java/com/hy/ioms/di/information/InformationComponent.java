package com.hy.ioms.di.information;

import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.view.information.InformationFragment;
import com.hy.ioms.view.picture.PictureFragment;

import dagger.Component;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@AppScope
@Component(dependencies = AppComponent.class, modules = InformationModule.class)
public interface InformationComponent {
    void inject(InformationFragment informationFragment);
}
