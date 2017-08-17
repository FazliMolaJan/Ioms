package com.hy.ioms;

import android.util.Pair;

import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.dto.TreeNodeDTO;
import com.hy.ioms.model.dto.VideoSenderTaskDTO;
import com.hy.ioms.model.repository.DeviceDataRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
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

    /**
     * 测试获取设备
     *
     * @throws Exception
     */
    @Test
    public void testGetDevices() throws Exception {

        TestObserver testObserver = new TestObserver();

        login().andThen(deviceDataRepository.getDevices(2, 10, ""))
                .subscribe(testObserver);
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


    @Test
    public void testGetDeviceTree() throws Exception {
        login().andThen(iomsApi.getTreeNode())
                .subscribe(new SingleObserver<List<TreeNodeDTO>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<TreeNodeDTO> treeNodeDTOs) {
                        treeNodeAnalysis(treeNodeDTOs, new FilterDTO(2L, 0L, 0L, 0L), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                    }
                });
    }

    /**
     * 只考虑2级公司
     *
     * @param treeNodeDTOs
     * @return
     */
    private List<Pair<String, Integer>> getCompany(List<TreeNodeDTO> treeNodeDTOs) {
        List<Pair<String, Integer>> companies = new ArrayList<>();
        for (TreeNodeDTO treeNodeDTO : treeNodeDTOs) {
            if (treeNodeDTO.getChildren().size() > 0 && treeNodeDTO.getChildren().get(0).getType().equals("company")) {
                for (TreeNodeDTO nodeDTO : treeNodeDTO.getChildren()) {
                    companies.add(new Pair<>(nodeDTO.getName(), nodeDTO.getId()));
                }
            } else {
                companies.add(new Pair<>(treeNodeDTO.getName(), treeNodeDTO.getId()));
            }
        }
        return companies;
    }

    private List<Pair<String, Integer>> getCircuit(List<TreeNodeDTO> treeNodeDTOs, Integer companyId) {
        List<Pair<String, Integer>> circuits = new ArrayList<>();
        for (TreeNodeDTO treeNodeDTO : treeNodeDTOs) {
            if (treeNodeDTO.getChildren().size() > 0 && treeNodeDTO.getChildren().get(0).getType().equals("company")) {
                for (TreeNodeDTO company : treeNodeDTO.getChildren()) {
                    if (companyId == 0 || company.getId() == companyId) {
                        for (TreeNodeDTO circuit : company.getChildren()) {
                            circuits.add(new Pair<>(circuit.getName(), circuit.getId()));
                        }
                    }
                }
            } else {
                if (companyId == 0 || treeNodeDTO.getId() == companyId) {
                    for (TreeNodeDTO circuit : treeNodeDTO.getChildren()) {
                        circuits.add(new Pair<>(circuit.getName(), circuit.getId()));
                    }
                }
            }
        }
        return circuits;
    }

    private List<Pair<String, Integer>> getPole(List<TreeNodeDTO> treeNodeDTOs, Integer companyId, Integer circuitId) {
        List<Pair<String, Integer>> circuits = new ArrayList<>();
//        for (TreeNodeDTO treeNodeDTO : treeNodeDTOs) {
//            if (treeNodeDTO.getChildren().size() > 0 && treeNodeDTO.getChildren().get(0).getType().equals("company")) {
//                for (TreeNodeDTO company : treeNodeDTO.getChildren()) {
//                    if (companyId == 0 || company.getId() == companyId) {
//                        for (TreeNodeDTO circuit : company.getChildren()) {
//                        }
//                    }
//                }
//            } else {
//                if (companyId == 0 || treeNodeDTO.getId() == companyId) {
//                    for (TreeNodeDTO circuit : treeNodeDTO.getChildren()) {
//                        if ()
//
//
//                    }
//                }
//            }
//        }
        return circuits;
    }

    private void treeNodeAnalysis(List<TreeNodeDTO> treeNodeDTOs, FilterDTO filterDTO,
                                  List<Pair<String, Integer>> companyList,
                                  List<Pair<String, Integer>> circuitList,
                                  List<Pair<String, Integer>> poleList,
                                  List<Pair<String, Integer>> deviceList) {
        List<TreeNodeDTO> companies = new ArrayList<>();

        for (TreeNodeDTO treeNodeDTO : treeNodeDTOs) {
            if (treeNodeDTO.getChildren().size() > 0 && treeNodeDTO.getChildren().get(0).getType().equals("company")) {
                companies.addAll(treeNodeDTO.getChildren());
            } else {
                companies.add(treeNodeDTO);
            }
        }

        for (TreeNodeDTO company : companies) {
            companyList.add(new Pair<>(company.getName(), company.getId()));
            if (filterDTO.getCompanyId() == 0 || filterDTO.getCompanyId() == company.getId()) {
                for (TreeNodeDTO circuit : company.getChildren()) {
                    circuitList.add(new Pair<>(circuit.getName(), circuit.getId()));
                    if (filterDTO.getCircuitId() == 0 || filterDTO.getCircuitId() == circuit.getId()) {
                        for (TreeNodeDTO pole : circuit.getChildren()) {
                            poleList.add(new Pair<>(pole.getName(), pole.getId()));
                            if (filterDTO.getPoleId() == 0 || filterDTO.getPoleId() == pole.getId()) {
                                for (TreeNodeDTO device : pole.getChildren()) {
                                    deviceList.add(new Pair<>(device.getName(), device.getId()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}