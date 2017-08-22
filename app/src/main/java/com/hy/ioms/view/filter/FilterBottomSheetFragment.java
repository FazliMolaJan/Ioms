package com.hy.ioms.view.filter;

import android.os.Bundle;

import com.hy.ioms.R;
import com.hy.ioms.databinding.FragmentBottomSheetFilterBinding;
import com.hy.ioms.di.AppComponent;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.view.base.BaseBottomSheetDialogFragment;

import static com.hy.ioms.Config.ARG_FILTER_DTO;


public class FilterBottomSheetFragment extends BaseBottomSheetDialogFragment<FragmentBottomSheetFilterBinding> {

    // TODO: 2017/8/22 等待完成一个总的过滤筛选,能够满足再次点击后能恢复上次所选择的条件
    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_bottom_sheet_filter;
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

    public static FilterBottomSheetFragment newInstance(FilterDTO filterDTO) {
        final FilterBottomSheetFragment orderFragment = new FilterBottomSheetFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_FILTER_DTO, filterDTO);
        orderFragment.setArguments(args);
        return orderFragment;
    }
}
