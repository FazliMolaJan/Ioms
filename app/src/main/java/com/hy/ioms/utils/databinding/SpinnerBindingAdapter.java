package com.hy.ioms.utils.databinding;

import android.databinding.BindingAdapter;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.vo.SpinItemVO;
import com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter;

import java.util.List;

import vm.DeviceFilterViewModel;

import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.CIRCUIT;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.COMPANY;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.DEVICE;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.POLE;

/**
 * ${description}
 * Created by wsw on 2017/8/17.
 */
@SuppressWarnings("unused")
public class SpinnerBindingAdapter {

    @BindingAdapter(value = {"datas", "filter"})
    public static void setDatas(Spinner spinner, List<SpinItemVO> datas, FilterDTO filterDTO) {
        FilterSpinnerAdapter adapter = (FilterSpinnerAdapter) spinner.getAdapter();
        adapter.init(datas);
        spinner.setSelection(adapter.getIndexByFilterDTO(filterDTO), true);
    }

    @BindingAdapter(value = {"on_selected"}, requireAll = false)
    public static void setOnItemSelectedListener(Spinner spinner, DeviceFilterViewModel deviceFilterViewModel) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinItemVO spinItemVO = (SpinItemVO) adapterView.getItemAtPosition(position);
                FilterDTO filterDTO = deviceFilterViewModel.getFilter().get();
                @FilterSpinnerAdapter.Type int type = spinItemVO.getType();
                switch (type) {
                    case COMPANY:
                        filterDTO.setCompanyId((long) spinItemVO.getId());
                        break;
                    case CIRCUIT:
                        filterDTO.setCircuitId((long) spinItemVO.getId());
                        break;
                    case POLE:
                        filterDTO.setPoleId((long) spinItemVO.getId());
                        break;
                    case DEVICE:
                        filterDTO.setDeviceId((long) spinItemVO.getId());
                        break;
                }
                deviceFilterViewModel.getFilter().set(filterDTO);
                deviceFilterViewModel.refreshFilter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
