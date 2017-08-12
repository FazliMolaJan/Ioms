package vm;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.utils.rx.BaseObserver;

import io.reactivex.Observable;

/**
 * ${description}
 * Created by wsw on 2017/8/12.
 */

public class DeviceViewModel extends BaseObservable {
    ObservableField<DeviceVO> voObservableField = new ObservableField<>();

    public DeviceViewModel(DeviceVO deviceVO) {
        voObservableField.set(deviceVO);
    }
}
