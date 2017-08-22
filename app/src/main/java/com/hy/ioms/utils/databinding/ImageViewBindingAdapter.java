package com.hy.ioms.utils.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hy.ioms.R;

/**
 * Created by wsw on 2017/8/21.
 */

public class ImageViewBindingAdapter {

    @BindingAdapter({"image"})
    public static void imageLoader(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .error(R.drawable.ic_error_red_24dp)
                .into(imageView);
    }
}
