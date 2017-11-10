package com.ediancha.edcbusiness.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.dmz.library.dmzapi.transformation.GlideRoundTransform;

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
    public static void loadImageRec(Context mContext, Object uri, ImageView target) {
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
    public static void loadImageOvel(Context mContext, Object uri, ImageView target) {
        Glide.with(mContext)
                .load(uri)
                .apply(new RequestOptions()
                        .circleCrop())
                .into(target);
    }


    public static void loadCircu(Context mContext, Object uri, ImageView target) {
        RequestBuilder<Bitmap> load = Glide.with(mContext).asBitmap().load(uri);
        load.into(new GlideRoundTransform(mContext, target));

    }

}