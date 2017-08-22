package vm;

import com.hy.ioms.model.interaction.DeviceDataInteraction;
import com.hy.ioms.model.vo.PictureVO;
import com.hy.ioms.view.device.DeviceListItem;

/**
 * Created by wsw on 2017/8/21.
 */

public class PicturePageViewModel extends BasePageDataViewModel<PictureVO, DeviceListItem>{
    private static final String TAG = "PicturePageViewModel";

    private DeviceDataInteraction deviceDataInteraction;


    @Override
    public void loadMore() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public DeviceListItem transform(PictureVO pictureVO) {
        return null;
    }
}
