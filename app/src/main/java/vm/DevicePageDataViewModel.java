package vm;

import android.util.Log;

import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.device.DeviceListItem;
import com.hy.ioms.view.ui.recycler.FooterItem;

import java.util.List;
import java.util.Set;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;


/**
 * 设备数据vm
 * Created by wsw on 2017/8/2.
 */

public class DevicePageDataViewModel extends BasePageDataViewModel<DeviceVO, DeviceListItem> implements IBaseDataViewModel {
    private static final String TAG = "DevicePageDataViewModel";
    private DeviceDataInteraction deviceDataInteraction;
    private IView view;
    private FooterItem footerItem;
    private FilterDTO filterDTO;

    public DevicePageDataViewModel(DeviceDataInteraction deviceDataInteraction,
                                   PagingParams pagingParams, FooterItem footerItem, IView view, FilterDTO filterDTO) {
        this.deviceDataInteraction = deviceDataInteraction;
        this.pagingParams = pagingParams;
        this.view = view;
        this.footerItem = footerItem.setState(FooterItem.LOADING);
        this.filterDTO = filterDTO;
    }

    /**
     * 获取设备,同时设置设备的总个数
     *
     * @param page         第几页
     * @param itemsPerPage 每页的个数
     * @param sort         排序
     * @param companyId    公司Id,默认为0
     * @param circuitId    线路Id,默认为0
     * @param poleId       杆塔Id,默认为0
     */
    private Single<Page<DeviceVO>> getDevices(int page, int itemsPerPage, String sort, Long companyId, Long circuitId,
                                              Long poleId) {
        return deviceDataInteraction.getDevices(page, itemsPerPage, sort, companyId, circuitId, poleId)
                .zipWith(deviceDataInteraction.getOnlineDeviceSet(), this::setDeviceOnlineState);
    }

    /**
     * 加载更多设备
     */
    @Override
    public void loadMore() {
        currentState.set(IView.LOADING);
        loadPageData(getDevices(pagingParams.queryPage + 1, pagingParams.itemsPerPage, pagingParams.sort, filterDTO
                        .getCompanyId(), filterDTO.getCircuitId(), filterDTO.getPoleId()),
                getDeviceObserver());
    }

    /**
     * 刷新设备数据
     */
    @Override
    public void refresh() {
        currentState.set(IView.REFRESHING);
        loadPageData(getDevices(Config.DEFAULT_QUERY_PAGE, pagingParams.itemsPerPage, pagingParams.sort, filterDTO
                        .getCompanyId(), filterDTO.getCircuitId(), filterDTO.getPoleId()),
                getDeviceObserver());
    }

    @Override
    public DeviceListItem transform(DeviceVO deviceVO) {
        return new DeviceListItem(deviceVO);
    }

    /**
     * 设置设备的在线状态
     *
     * @param deviceVOPage 设备vo分页对象
     * @param onlineSet    在线列表
     */
    private Page<DeviceVO> setDeviceOnlineState(@NonNull Page<DeviceVO> deviceVOPage, @NonNull Set<String> onlineSet) {
        for (DeviceVO deviceVO : deviceVOPage.getContent()) {
            if (onlineSet.contains(deviceVO.getCode())) {
                deviceVO.setOnline(true);
            } else {
                deviceVO.setOnline(false);
            }
        }
        return deviceVOPage;
    }

    /**
     * 在deviceVo->deviceItem之前,查询每一个的报警个数
     *
     * @param deviceVO 设备vo
     */
    @Override
    public void beforeTransformSingleData(@NonNull DeviceVO deviceVO) {
        deviceDataInteraction.getDeviceAlarmCount(deviceVO.getId(), deviceVO.getProjectType())
                .compose(RxJavaUtils.single_io_main())
                .subscribe(new BaseSingleObserver<Integer>(view.getContext()) {
                    @Override
                    public void onSuccess(@NonNull Integer integer) {
                        deviceVO.setAlarmCount(integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
//        deviceVO.setAlarmCount(0);
    }

    /**
     * 获取设备最后的处理者
     */
    private BaseSingleObserver<List<DeviceListItem>> getDeviceObserver() {
        return new BaseSingleObserver<List<DeviceListItem>>(view.getContext()) {
            @Override
            public void onSuccess(@NonNull List<DeviceListItem> deviceViewModels) {
                datas.addAll(deviceViewModels);
                Log.d(TAG, "onSuccess: " + getCurrentState());
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                Log.e(TAG, "获取设备出错", throwable);
            }
        };
    }

    public FooterItem getFooterItem() {
        return this.footerItem;
    }

    public FilterDTO getFilterDTO() {
        return filterDTO;
    }

    public void setFilterDTO(FilterDTO filterDTO) {
        this.filterDTO = filterDTO;
    }
}
