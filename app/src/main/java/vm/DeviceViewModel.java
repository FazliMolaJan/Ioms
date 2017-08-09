package vm;

import android.content.Context;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.service.DeviceDataService;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by wsw on 2017/8/2.
 */

public class DeviceViewModel {

    @Inject
    DeviceDataService deviceDataService;

    @Inject
    PagingParams pagingParams;

    Context context;


    public void getDevices() {
        deviceDataService.getDevices(pagingParams.currentPage + 1, pagingParams.itemsPerPage,
                pagingParams.sort)
                .compose(RxJavaUtils.single_io_main())
                .subscribe(new BaseSingleObserver<Page<DeviceVO>>(context) {

                    @Override
                    public void onSuccess(@NonNull Page<DeviceVO> deviceVOPage) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }


}
