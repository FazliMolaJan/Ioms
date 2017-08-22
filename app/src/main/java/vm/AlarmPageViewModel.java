package vm;

import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.AlarmVO;
import com.hy.ioms.model.vo.SpinItemVO;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.alarm.AlarmItem;
import com.hy.ioms.view.ui.recycler.FooterItem;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

/**
 * Created by wsw on 2017/8/22.
 */

public class AlarmPageViewModel extends BasePageDataViewModel<AlarmVO, AlarmItem> {
    private static final String TAG = "AlarmPageViewModel";

    public static final int FIRE = 0;
    public static final int BREAK = 1;

    private DeviceDataInteraction deviceDataInteraction;
    private IView view;
    private FooterItem footerItem;
    private FilterDTO filterDTO;
    public ObservableInt type = new ObservableInt(FIRE);
    public AdapterView.OnItemSelectedListener onItemSelected;

    @Override
    public AlarmItem transform(AlarmVO alarmVO) {
        return new AlarmItem(alarmVO);
    }

    public FooterItem getFooterItem() {
        return footerItem;
    }

    public FilterDTO getFilterDTO() {
        return filterDTO;
    }

    public void setFilterDTO(FilterDTO filterDTO) {
        this.filterDTO = filterDTO;
    }

    public AlarmPageViewModel(DeviceDataInteraction deviceDataInteraction,
                              PagingParams pagingParams, FooterItem footerItem, IView view, FilterDTO filterDTO) {
        this.deviceDataInteraction = deviceDataInteraction;
        this.pagingParams = pagingParams;
        this.view = view;
        this.footerItem = footerItem.setState(FooterItem.LOADING);
        this.filterDTO = filterDTO;

        onItemSelected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SpinItemVO spinItemVO = (SpinItemVO) adapterView.getItemAtPosition(position);
                switch (spinItemVO.getId()) {
                    case FIRE:
                        type.set(FIRE);
                        break;
                    case BREAK:
                        type.set(BREAK);
                        break;
                    default:
                        break;
                }
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    /**
     * 获取图片,同时设置设备的总个数
     *
     * @param page         第几页数据
     * @param itemsPerPage 每页个数
     * @param sort         排序
     * @param companyId    公司Id
     * @param circuitId    线路Id
     * @param poleId       杆塔Id
     * @param deviceId     设备id
     * @param startTime    开始时间,为空则是全查
     * @param endTime      结束时间,默认为当天
     */
    private Single<Page<AlarmVO>> getAlarms(int page, int itemsPerPage, String sort, Long companyId,
                                            Long circuitId, Long poleId, Long deviceId,
                                            String startTime, String endTime) {
        Single<Page<AlarmVO>> single;
        if (type.get() == FIRE) {
            single = getFireAlarms(page, itemsPerPage, sort, companyId, circuitId, poleId,
                    deviceId, startTime, endTime);
        } else {
            single = getBreakAlarms(page, itemsPerPage, sort, companyId, circuitId, poleId,
                    deviceId, startTime, endTime);
        }
        return single;
    }

    /**
     * 获取设备外破报警
     *
     * @param page         第几页数据
     * @param itemsPerPage 每页个数
     * @param sort         排序
     * @param companyId    公司Id
     * @param circuitId    线路Id
     * @param poleId       杆塔Id
     * @param deviceId     设备id
     * @param startTime    开始时间,为空则是全查
     * @param endTime      结束时间,默认为当天
     */
    private Single<Page<AlarmVO>> getBreakAlarms(int page, int itemsPerPage, String sort, Long companyId, Long circuitId, Long poleId, Long deviceId, String startTime, String endTime) {
        return deviceDataInteraction.getBreakAlarm(page, itemsPerPage, sort, companyId, circuitId,
                poleId, deviceId, startTime, endTime);
    }

    /**
     * 获取设备山火报警
     *
     * @param page         第几页数据
     * @param itemsPerPage 每页个数
     * @param sort         排序
     * @param companyId    公司Id
     * @param circuitId    线路Id
     * @param poleId       杆塔Id
     * @param deviceId     设备id
     * @param startTime    开始时间,为空则是全查
     * @param endTime      结束时间,默认为当天
     */
    private Single<Page<AlarmVO>> getFireAlarms(int page, int itemsPerPage, String sort, Long companyId, Long circuitId, Long poleId, Long deviceId, String startTime, String endTime) {
        return deviceDataInteraction.getFireAlarm(page, itemsPerPage, sort, companyId, circuitId,
                poleId, deviceId, startTime, endTime);

    }


    @Override
    public void loadMore() {
        currentState.set(IView.LOADING);
        loadPageData(getAlarms(pagingParams.queryPage + 1, pagingParams.itemsPerPage, pagingParams
                        .sort, filterDTO
                        .getCompanyId(), filterDTO.getCircuitId(), filterDTO.getPoleId(), filterDTO.getDeviceId(),
                filterDTO.getStartTime(), filterDTO.getEndTime()),
                getAlarmObserver());
    }

    @Override
    public void refresh() {
        currentState.set(IView.REFRESHING);
        loadPageData(getAlarms(Config.DEFAULT_QUERY_PAGE, pagingParams.itemsPerPage, pagingParams.sort, filterDTO
                        .getCompanyId(), filterDTO.getCircuitId(), filterDTO.getPoleId(), filterDTO.getDeviceId(),
                filterDTO.getStartTime(), filterDTO.getEndTime()),
                getAlarmObserver());
    }

    /**
     * 获取设备最后的处理者
     */
    private BaseSingleObserver<List<AlarmItem>> getAlarmObserver() {
        return new BaseSingleObserver<List<AlarmItem>>(view.getContext()) {
            @Override
            public void onSuccess(@NonNull List<AlarmItem> pictureItems) {
                datas.addAll(pictureItems);
                Log.d(TAG, "onSuccess: " + getCurrentState());
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                Log.e(TAG, "获取报警出错", throwable);
            }
        };
    }
}
