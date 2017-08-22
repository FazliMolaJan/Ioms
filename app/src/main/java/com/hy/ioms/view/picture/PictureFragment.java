package com.hy.ioms.view.picture;

import com.hy.ioms.R;
import com.hy.ioms.databinding.FragmentPictureListBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.picture.DaggerPictureComponent;
import com.hy.ioms.view.base.BaseFragment;

import javax.inject.Inject;

import vm.PicturePageViewModel;

/**
 * 图片Fragment
 */
public class PictureFragment extends BaseFragment<FragmentPictureListBinding> {

    @Inject
    PicturePageViewModel pictureViewModel;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerPictureComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_picture_list;
    }

    @Override
    protected void beforeSetViews() {

    }

    @Override
    protected void setViews() {

    }

    @Override
    protected void doTransaction() {

    }
}
