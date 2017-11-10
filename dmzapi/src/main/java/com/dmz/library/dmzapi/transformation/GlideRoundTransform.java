package com.dmz.library.dmzapi.transformation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.security.MessageDigest;

/**
 * Created by dengmingzhi on 2017/11/9.
 */

public class GlideRoundTransform extends BitmapImageViewTarget {
    private Context context;
    private ImageView imageView;
    private float radius;

    public GlideRoundTransform(Context context, ImageView view, float radius) {
        super(view);
        this.context = context;
        this.imageView = view;
        this.radius = radius;
    }

    public GlideRoundTransform(Context context, ImageView view) {
        this(context, view, 10);
    }

    /**
     * 重写 setResource（），生成圆角的图片
     *
     * @param resource
     */
    @Override
    protected void setResource(Bitmap resource) {
        RoundedBitmapDrawable bitmapDrawable = RoundedBitmapDrawableFactory.create(this.context.getResources(), resource);
        /**
         *   设置图片的shape为圆形.
         *
         *   若是需要制定圆角的度数，则调用setCornerRadius（）。
         */
        bitmapDrawable.setCircular(true);
        bitmapDrawable.setCornerRadius(radius);
        this.imageView.setImageDrawable(bitmapDrawable);
    }
}
