package com.hy.ioms;

import com.hy.ioms.model.Page;
import com.hy.ioms.model.dto.DeviceDTO;
import com.hy.ioms.model.dto.VideoSenderTaskDTO;
import com.hy.ioms.model.repository.DeviceDataRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;

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

    /**
     * 测试获取设备
     *
     * @throws Exception
     */
    @Test
    public void testGetDevices() throws Exception {

        TestObserver testObserver = new TestObserver();

        login().andThen(deviceDataRepository.getDevices(0, 10, ""))
                .subscribe(testObserver);

        testObserver.assertComplete();


    }

    /**
     * 测试获取计划任务图片
     *
     * @throws Exception
     */
    @Test
    public void testGetScheduledTaskPictures() throws Exception {

        TestObserver testObserver = new TestObserver();

        login().andThen(deviceDataRepository.getScheduledTaskPictures(Long.parseLong("1"), 0, 10, ""))
                .subscribe(testObserver);

        testObserver.assertComplete();


    }

    /**
     * 测试获取手动拍照图片
     *
     * @throws Exception
     */
    @Test
    public void testGetManualPictures() throws Exception {

        TestObserver testObserver = new TestObserver();

        login().andThen(deviceDataRepository.getManualPictures(Long.parseLong("1"), 0, 10, ""))
                .subscribe(testObserver);

        testObserver.assertComplete();


    }


    /**
     * 测试获取在线设备
     *
     * @throws Exception
     */
    @Test
    public void testGetOnlineDeviceSet() throws Exception {

        TestObserver testObserver = new TestObserver();

        login().andThen(deviceDataRepository.getOnlineDeviceSet())
                .subscribe(testObserver);

        testObserver.assertComplete();


    }


    /**
     * 测试获取当前设备状态
     *
     * @throws Exception
     */
    @Test
    public void testGetCurrentDeviceStatus() throws Exception {

        TestObserver testObserver = new TestObserver();

        login().andThen(deviceDataRepository.getCurrentDeviceStatus("HY_OLMS_YS_000023"))
                .subscribe(testObserver);

        testObserver.assertComplete();


    }

    /**
     * 测试获取视频设备状态
     *
     * @throws Exception
     */
    @Test
    public void testGetVideoSenderTask() throws Exception {

        TestObserver testObserver = new TestObserver();

        login().andThen(iomsApi.getVideoSenderTask("HY_OLMS_YS_000023"))
                .subscribe(new SingleObserver<VideoSenderTaskDTO>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull VideoSenderTaskDTO videoSenderTaskDTO) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                            e.printStackTrace();
                    }
                });

//        testObserver.assertComplete();


    }


}