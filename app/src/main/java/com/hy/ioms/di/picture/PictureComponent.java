package com.hy.ioms.di.picture;

import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.AppScope;
import com.hy.ioms.view.picture.PictureFragment;

import dagger.Component;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@AppScope
@Component(dependencies = AppComponent.class, modules = PictureModule.class)
public interface PictureComponent {
    void inject(PictureFragment pictureFragment);
}
