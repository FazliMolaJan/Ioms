package com.hy.ioms.view.ui.spinner;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hy.ioms.BR;
import com.hy.ioms.R;
import com.hy.ioms.model.vo.SpinItemVO;

import java.util.List;

/**
 * ${description}
 * Created by wsw on 2017/8/22.
 */

public class SimpleSpinnerAdapter extends BaseAdapter {

    private final List<SpinItemVO> datas;
    private final Context mContext;

    public SimpleSpinnerAdapter(List<SpinItemVO> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public SpinItemVO getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return datas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding binding;
        if (view == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.white_spinner_item, viewGroup, false);
        } else {
            binding = DataBindingUtil.getBinding(view);
        }
        binding.setVariable(BR.text, datas.get(i).getName());
        return binding.getRoot();
    }
}
