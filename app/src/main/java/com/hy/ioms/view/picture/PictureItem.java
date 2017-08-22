package com.hy.ioms.view.picture;

import android.os.Parcel;
import android.os.Parcelable;

import com.hy.ioms.R;
import com.hy.ioms.model.vo.PictureVO;
import com.hy.ioms.view.ui.recycler.BaseItem;

/**
 * ${description}
 * Created by wsw on 2017/4/10.
 */

public class PictureItem extends BaseItem{
    private static final String TAG = "PictureItem";

    @Override
    public int getLayout() {
        return R.layout.item_picture;
    }

    public PictureItem(PictureVO pictureVO) {
        this.mPictureVO = pictureVO;
//        setOnClickListener(view -> {
//            ArrayList<PictureVO> pictureVOs = new ArrayList<>();
//            for (MultipleTypeAdapter.IItem iItem : multipleTypeAdapter.getData()) {
//                PictureItem item = (PictureItem) iItem;
//                pictureVOs.add(item.mPictureVO);
//            }
//
//            PictureDetailActivity.startActivity(view.getContext(), pictureVOs, pagingParams,
//                    multipleTypeAdapter.findPos(this), type, deviceId, deviceCode);
//        });
    }

    ///////////////////////////////////////
    // data model part
    private PictureVO mPictureVO;

    public String getUrl() {
        return mPictureVO.getThumbUrl();
    }

    public String getDate() {
        return mPictureVO.getDate();
    }

    public String getDeviceCode(){
        return mPictureVO.getDeviceCode();
    }

}
