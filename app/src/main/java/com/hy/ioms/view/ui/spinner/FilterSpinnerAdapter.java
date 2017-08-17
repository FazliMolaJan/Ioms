package com.hy.ioms.view.ui.spinner;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.IntDef;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hy.ioms.BR;
import com.hy.ioms.R;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.vo.SpinItemVO;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;

/**
 * ${description}
 * Created by wsw on 2017/8/17.
 */

public class FilterSpinnerAdapter extends BaseAdapter {
    public static final int COMPANY = 0;
    public static final int CIRCUIT = 1;
    public static final int POLE = 2;
    public static final int DEVICE = 3;

    //用 @IntDef "包住" 常量；
    // @Retention 定义策略
    // 声明构造器
    //空闲状态,刷新中,加载中
    @IntDef({COMPANY, CIRCUIT, POLE, DEVICE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private List<SpinItemVO> datas;
    private Context mContext;
    private int type;

    public FilterSpinnerAdapter(List<SpinItemVO> datas, Context mContext, @Type int type) {
        this.datas = datas;
        this.mContext = mContext;
        this.type = type;
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
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.spinner_item, viewGroup, false);
        } else {
            binding = DataBindingUtil.getBinding(view);
        }
        binding.setVariable(BR.text, datas.get(i).getName());
        return binding.getRoot();
    }

    public void add(SpinItemVO data) {
        datas.add(data);
        notifyDataSetChanged();
    }

    public void addAll(Collection<SpinItemVO> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void set(SpinItemVO data) {
        datas.clear();
        datas.add(data);
        notifyDataSetChanged();
    }

    public void setAll(Collection<SpinItemVO> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Type
    public int getType() {
        return this.type;
    }

    public void init(List<SpinItemVO> datas) {
        this.datas.clear();
        this.datas.add(new SpinItemVO("不限", this.getType(), 0));
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }


    public int getIndexByFilterDTO(FilterDTO filterDTO) {
        int index = 0;
        @Type int type = this.getType();
        switch (type) {
            case COMPANY:
                for (SpinItemVO data : datas) {
                    if (filterDTO.getCompanyId() == data.getId()) {
                        index = datas.indexOf(data);
                        break;
                    }
                }
                break;
            case CIRCUIT:
                for (SpinItemVO data : datas) {
                    if (filterDTO.getCircuitId() == data.getId()) {
                        index = datas.indexOf(data);
                        break;
                    }
                }
                break;
            case POLE:
                for (SpinItemVO data : datas) {
                    if (filterDTO.getPoleId() == data.getId()) {
                        index = datas.indexOf(data);
                        break;
                    }
                }
                break;
            case DEVICE:
                break;
        }

        return index;
    }

}
