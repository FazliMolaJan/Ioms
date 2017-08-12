package vm;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;
import com.hy.ioms.view.IView;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;


/**
 * 设备数据vm
 * Created by wsw on 2017/8/2.
 */

public class DevicePageDataViewModel extends BasePageDataViewModel<DeviceVO, DeviceViewModel> implements IBaseDataViewModel {
    private DeviceDataInteraction deviceDataInteraction;
    private IView view;

    public DevicePageDataViewModel(DeviceDataInteraction deviceDataInteraction,
                                   PagingParams pagingParams, IView view) {
        this.deviceDataInteraction = deviceDataInteraction;
        this.pagingParams = pagingParams;
        this.view = view;
    }

    public Single<Page<DeviceVO>> getDevices() {
        return deviceDataInteraction.getDevices(pagingParams)
                .compose(RxJavaUtils.single_io_main());
    }

    /**
     * 加载更多设备
     */
    @Override
    public void loadMore() {
        currentState.set(IView.LOADING);
        loadPageData(getDevices(), new BaseSingleObserver<List<DeviceViewModel>>(view.getContext()) {
            @Override
            public void onSuccess(@NonNull List<DeviceViewModel> deviceViewModels) {
                dataList.addAll(deviceViewModels);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }
        });
    }

    /**
     * 刷新设备数据
     */
    @Override
    public void refresh() {
        currentState.set(IView.REFRESHING);
        loadPageData(getDevices(), new BaseSingleObserver<List<DeviceViewModel>>(view.getContext()) {
            @Override
            public void onSuccess(@NonNull List<DeviceViewModel> deviceViewModels) {
                dataList.clear();
                dataList.addAll(deviceViewModels);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }
        });
    }

    @Override
    public void beforeLoadMore() {
        super.beforeLoadMore();
    }

    @Override
    public void beforeRefresh() {
        super.beforeRefresh();
    }

    @Override
    public void afterLoadMore() {
        super.afterLoadMore();
    }

    @Override
    public void afterRefresh() {
        super.afterRefresh();
    }

    @Override
    public DeviceViewModel transform(DeviceVO deviceVO) {
        return new DeviceViewModel(deviceVO);
    }
}
