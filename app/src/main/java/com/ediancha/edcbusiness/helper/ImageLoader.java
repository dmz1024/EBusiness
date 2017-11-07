package com.ediancha.edcbusiness.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Admin on 2017/11/3.
 */

public class ImageLoader {
    /**
     * 加载方形图片
     *
     * @param mContext
     * @param uri
     * @param target
     */
    public static void loadImageRec(Context mContext, String uri, ImageView target) {
        Glide.with(mContext)
                .load(uri)
                .into(target);
    }

    /**
     * 加载圆形图片
     * @param mContext
     * @param uri
     * @param target
     */
    public static void loadImageOvel(Context mContext, String uri, ImageView target) {
        Glide.with(mContext)
                .load(uri)
                .apply(new RequestOptions()
                        .circleCrop())
                .into(target);
    }
}