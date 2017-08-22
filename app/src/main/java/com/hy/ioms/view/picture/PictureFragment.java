package com.hy.ioms.view.picture;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.hy.ioms.R;
import com.hy.ioms.databinding.FragmentPictureListBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.di.picture.DaggerPictureComponent;
import com.hy.ioms.di.picture.PictureModule;
import com.hy.ioms.view.base.BaseFragment;
import com.hy.ioms.view.filter.FilterBottomSheetFragment;
import com.hy.ioms.view.ui.recycler.MultipleTypeAdapter;
import com.hy.ioms.view.ui.spinner.SimpleSpinnerAdapter;

import javax.inject.Inject;
import javax.inject.Named;

import vm.EventViewModel;
import vm.PicturePageViewModel;

/**
 * 图片Fragment
 */
public class PictureFragment extends BaseFragment<FragmentPictureListBinding> {

    @Inject
    PicturePageViewModel pictureViewModel;

    @Inject
    EventViewModel eventViewModel;

    @Inject
    MultipleTypeAdapter multipleTypeAdapter;

    @Inject
    @Named("picture")
    SimpleSpinnerAdapter simpleSpinnerAdapter;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerPictureComponent.builder()
                .appComponent(appComponent)
                .pictureModule(new PictureModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_picture_list;
    }

    @Override
    protected void beforeSetViews() {
        eventViewModel.setOnClick(view -> {
            if (view == b.filter) {
                FilterBottomSheetFragment filterBottomSheetFragment =
                        FilterBottomSheetFragment.newInstance(pictureViewModel.getFilterDTO());
                filterBottomSheetFragment.show(getChildFragmentManager(), null);
            }
        });
        b.setEvent(eventViewModel);
        b.setVm(pictureViewModel);
    }

    @Override
    protected void setViews() {
        b.spPictureType.setAdapter(simpleSpinnerAdapter);
        b.pictureContent.fragmentPictureRv.setHasFixedSize(true);
        b.pictureContent.fragmentPictureRv.setAdapter(multipleTypeAdapter);
        b.pictureContent.fragmentPictureRv.setLayoutManager(new GridLayoutManager(getContext(), 2));

        b.pictureContent.fragmentPictureRefresh.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        b.pictureContent.fragmentPictureRefresh.setOnRefreshListener(() -> pictureViewModel.refresh());
    }

    @Override
    protected void doTransaction() {
        pictureViewModel.refresh();
    }

    public static PictureFragment newInstance() {
        PictureFragment fragment = new PictureFragment();
        Bundle args = new Bundle();
//        args.putParcelable(ARG_DEVICE_VO, deviceVO);
        fragment.setArguments(args);
        return fragment;
    }
}
