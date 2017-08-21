package vm;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.dto.TreeNodeDTO;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.SpinItemVO;
import com.hy.ioms.utils.TreeNodeUtils;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.annotations.NonNull;

import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.CIRCUIT;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.COMPANY;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.DEVICE;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.POLE;


/**
 * ${description}
 * Created by wsw on 2017/8/16.
 */

public class DeviceFilterViewModel extends BaseObservable {
    private DeviceDataInteraction deviceDataInteraction;
    private IView view;

    public ObservableField<FilterDTO> filter = new ObservableField<>();
    public ObservableList<TreeNodeDTO> treeNodeDTO = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> companies = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> circuits = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> poles = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> devices = new ObservableArrayList<>();
    public AdapterView.OnItemSelectedListener onItemSelected;

    public ObservableBoolean loading = new ObservableBoolean(true);

    public DeviceFilterViewModel(DeviceDataInteraction deviceDataInteraction, IView view) {
        this.deviceDataInteraction = deviceDataInteraction;
        this.view = view;
        onItemSelected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinItemVO spinItemVO = (SpinItemVO) adapterView.getItemAtPosition(position);
                FilterDTO filterDTO = filter.get();
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
                filter.set(filterDTO);
                refreshFilter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    public void getFilterTreeNode() {
        deviceDataInteraction.getFilterTreeNode()
                .doOnSubscribe(disposable -> loading.set(true))
                .doFinally(() -> loading.set(false))
                .doOnSuccess(treeNodeDTOs -> treeNodeDTO.addAll(treeNodeDTOs))
                .compose(RxJavaUtils.single_io_main())
                .subscribe(new BaseSingleObserver<List<TreeNodeDTO>>(view.getContext()) {
                    @Override
                    public void onSuccess(@NonNull List<TreeNodeDTO> treeNodeDTOs) {
                        TreeNodeUtils.treeNodeAnalysis(treeNodeDTOs, filter.get(), companies, circuits, poles);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        Toast.makeText(view.getContext(), "获取数据失败!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void search() {
        EventBus.getDefault().post(filter.get());
        ((BottomSheetDialogFragment) view).dismiss();
    }

    public void refreshFilter() {
        TreeNodeUtils.treeNodeAnalysis(treeNodeDTO, filter.get(), companies, circuits, poles);
    }
}
