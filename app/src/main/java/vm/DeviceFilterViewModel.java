package vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.hy.ioms.BR;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.dto.TreeNodeDTO;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.SpinItemVO;
import com.hy.ioms.utils.TreeNodeUtils;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.device.DeviceFilterBottomSheetDialogFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * ${description}
 * Created by wsw on 2017/8/16.
 */

public class DeviceFilterViewModel extends BaseObservable {

    private DeviceDataInteraction deviceDataInteraction;
    private IView view;

    private ObservableField<FilterDTO> filter = new ObservableField<>();
    public ObservableList<TreeNodeDTO> treeNodeDTO = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> companies = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> circuits = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> poles = new ObservableArrayList<>();
    public ObservableList<SpinItemVO> devices = new ObservableArrayList<>();

    public ObservableBoolean loading = new ObservableBoolean(true);

    public DeviceFilterViewModel(DeviceDataInteraction deviceDataInteraction, IView view) {
        this.deviceDataInteraction = deviceDataInteraction;
        this.view = view;
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

    public void reset() {
//        filter.set(new FilterDTO());
//        refreshFilter();
    }

    public void refreshFilter() {
        TreeNodeUtils.treeNodeAnalysis(treeNodeDTO, filter.get(), companies, circuits, poles);
        System.out.println(poles.size());
    }

    public ObservableField<FilterDTO> getFilter() {
        return filter;
    }

    public void setFilter(ObservableField<FilterDTO> filter) {
        this.filter = filter;
    }
}
