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

public class PictureItem extends BaseItem implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mPictureVO, flags);
    }

    protected PictureItem(Parcel in) {
        this.mPictureVO = in.readParcelable(PictureVO.class.getClassLoader());
    }

    public static final Parcelable.Creator<PictureItem> CREATOR = new Parcelable.Creator<PictureItem>() {
        @Override
        public PictureItem createFromParcel(Parcel source) {
            return new PictureItem(source);
        }

        @Override
        public PictureItem[] newArray(int size) {
            return new PictureItem[size];
        }
    };
}
