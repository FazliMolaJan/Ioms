package vm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.DeviceStatusVO;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;
import com.hy.ioms.view.IView;

import io.reactivex.annotations.NonNull;

/**
 * 设备信息获取ViewModel
 * Created by wsw on 2017/8/23.
 */

public class InformationViewModel implements IBaseDataViewModel {
    private static final String TAG = "InformationViewModel";

    private DeviceDataInteraction deviceDataInteraction;
    private IView view;
    private String deviceCode;
    public ObservableBoolean isLoading = new ObservableBoolean(false);
    public ObservableField<DeviceStatusVO> info = new ObservableField<>();

    public InformationViewModel(DeviceDataInteraction deviceDataInteraction, IView view) {
        this.deviceDataInteraction = deviceDataInteraction;
        this.view = view;
    }

    /**
     * 获取设备的Information
     */
    private void loadDeviceInformation() {
        deviceDataInteraction.getCurrentDeviceStatus(deviceCode)
                .doOnSubscribe(disposable -> isLoading.set(true))
                .compose(RxJavaUtils.single_io_main())
                .doFinally(() -> isLoading.set(false))
                .subscribe(new BaseSingleObserver<DeviceStatusVO>(view.getContext()) {
                    @Override
                    public void onSuccess(@NonNull DeviceStatusVO deviceStatusVO) {
                        info.set(deviceStatusVO);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        Log.e(TAG, "获取设备Information出错", throwable);
                    }
                });
    }

    @Override
    public void loadMore() {
        loadDeviceInformation();
    }

    @Override
    public void refresh() {
        loadDeviceInformation();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }
}
