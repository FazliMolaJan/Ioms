package com.hy.ioms.di.picture;

import com.hy.ioms.view.IView;

import dagger.Module;

/**
 * ${description}
 * Created by wsw on 2017/8/21.
 */
@Module
public class PictureModule {
    private final IView iView;


    public PictureModule(IView iView) {
        this.iView = iView;
    }


}
