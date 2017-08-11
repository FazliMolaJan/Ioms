package com.hy.ioms;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.repository.DeviceDataRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.TestObserver;

/**
 * Created by wsw on 2017/8/3.
 */
public class DeviceDataRepositoryTest extends BaseTest {

    DeviceDataRepository deviceDataRepository;

    @Before
    public void setUp() {
        init();
        deviceDataRepository = new DeviceDataRepository(iomsApi);
    }

    @Test
    public void getDevices() throws Exception {
        login().andThen(deviceDataRepository.getDevices(0, 10, ""))
                .subscribe(new SingleObserver<Page<DeviceDTO>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Page<DeviceDTO> deviceDTOPage) {
                        System.out.println(deviceDTOPage.getTotalNumber());
                        System.out.println(deviceDTOPage.getCurrentPage());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

}