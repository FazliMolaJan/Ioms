package vm;

import android.databinding.ObservableInt;
import android.databinding.ObservableLong;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.DeviceVO;
import com.hy.ioms.model.vo.PictureVO;
import com.hy.ioms.model.vo.SpinItemVO;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.device.DeviceListItem;
import com.hy.ioms.view.picture.PictureItem;
import com.hy.ioms.view.ui.recycler.FooterItem;
import com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.CIRCUIT;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.COMPANY;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.DEVICE;
import static com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter.POLE;

/**
 * 图片数据vm
 * Created by wsw on 2017/8/21.
 */

public class PicturePageViewModel extends BasePageDataViewModel<PictureVO, PictureItem> {
    private static final String TAG = "PicturePageViewModel";

    public static final int SCHEDULED = 0;
    public static final int MANUAL = 1;

    private DeviceDataInteraction deviceDataInteraction;
    private IView view;
    private FooterItem footerItem;
    private FilterDTO filterDTO;
    public ObservableInt type = new ObservableInt(SCHEDULED);
    public AdapterView.OnItemSelectedListener onItemSelected;


    @Override
    public PictureItem transform(PictureVO pictureVO) {
        return new PictureItem(pictureVO);
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


    public PicturePageViewModel(DeviceDataInteraction deviceDataInteraction,
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
                    case SCHEDULED:
                        type.set(SCHEDULED);
                        break;
                    case MANUAL:
                        type.set(MANUAL);
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
    private Single<Page<PictureVO>> getPictures(int page, int itemsPerPage, String sort, Long companyId,
                                                Long circuitId, Long poleId, Long deviceId,
                                                String startTime, String endTime) {
        Single<Page<PictureVO>> single;
        if (type.get() == SCHEDULED) {
            single = getScheduledTaskPictures(page, itemsPerPage, sort, companyId, circuitId, poleId, deviceId, startTime, endTime);
        } else {
            single = getManualPictures(page, itemsPerPage, sort, companyId, circuitId, poleId, deviceId, startTime, endTime);
        }
        return single;
    }

    /**
     * 获取设备手动拍照图片
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
    private Single<Page<PictureVO>> getScheduledTaskPictures(int page, int itemsPerPage, String sort, Long companyId,
                                                             Long circuitId, Long poleId, Long deviceId,
                                                             String startTime, String endTime) {
        return deviceDataInteraction.getScheduledTaskPictures(page, itemsPerPage, sort, companyId,
                circuitId, poleId, deviceId, startTime, endTime);
    }

    /**
     * 获取设备手动拍照图片
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
    private Single<Page<PictureVO>> getManualPictures(int page, int itemsPerPage, String sort, Long companyId,
                                                      Long circuitId, Long poleId, Long deviceId,
                                                      String startTime, String endTime) {
        return deviceDataInteraction.getManualPictures(page, itemsPerPage, sort,
                companyId, circuitId, poleId, deviceId, startTime, endTime);
    }

    @Override
    public void loadMore() {
        currentState.set(IView.LOADING);
        loadPageData(getPictures(pagingParams.queryPage + 1, pagingParams.itemsPerPage, pagingParams.sort, filterDTO
                        .getCompanyId(), filterDTO.getCircuitId(), filterDTO.getPoleId(), filterDTO.getDeviceId(),
                filterDTO.getStartTime(), filterDTO.getEndTime()),
                getPictureObserver());
    }

    @Override
    public void refresh() {
        currentState.set(IView.REFRESHING);
        loadPageData(getPictures(Config.DEFAULT_QUERY_PAGE, pagingParams.itemsPerPage, pagingParams.sort, filterDTO
                        .getCompanyId(), filterDTO.getCircuitId(), filterDTO.getPoleId(), filterDTO.getDeviceId(),
                filterDTO.getStartTime(), filterDTO.getEndTime()),
                getPictureObserver());
    }

    /**
     * 获取设备最后的处理者
     */
    private BaseSingleObserver<List<PictureItem>> getPictureObserver() {
        return new BaseSingleObserver<List<PictureItem>>(view.getContext()) {
            @Override
            public void onSuccess(@NonNull List<PictureItem> pictureItems) {
                datas.addAll(pictureItems);
                Log.d(TAG, "onSuccess: " + getCurrentState());
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                Log.e(TAG, "获取图片出错", throwable);
            }
        };
    }

}
