package com.ediancha.edcbusiness.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Log;

import com.ediancha.edcbusiness.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Admin
 * @date 2017/11/3
 * 富文本显示
 */

public class TextStylesHelper {

    /**
     * 背景文字
     *
     * @param msg
     * @param color
     * @param start
     * @param end
     * @return
     */
    public SpannableString backgroundColorText(String msg, int color, int start, int end) {
        SpannableString spanString = new SpannableString(msg);
        BackgroundColorSpan span = new BackgroundColorSpan(color);
        spanString.setSpan(span, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }

    /**
     * 图文
     *
     * @return
     */
    public SpannableString imageText(Context context,String uri, String msg, int start, int end) {
        SpannableString spanString = new SpannableString("0123");
        Drawable d = loadImageFromNetwork(uri);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        spanString.setSpan(span, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return spanString;
    }

    /**
     * @param urlpath
     * @return Bitmap
     * 根据图片url获取图片对象
     */
    public static Bitmap getBitMBitmap(String urlpath) {
        Bitmap map = null;
        try {
            URL url = new URL(urlpath);
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream in;
            in = conn.getInputStream();
            map = BitmapFactory.decodeStream(in);
            // TODO Auto-generated catch block
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    Drawable drawable = null;
    private Drawable loadImageFromNetwork(final String imageUrl) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    // 可以在这里通过文件名来判断，是否本地有此图片
                    drawable = Drawable.createFromStream(
                            new URL(imageUrl).openStream(), "image.jpg");
                } catch (IOException e) {
                    Log.d("test", e.getMessage());
                }
                if (drawable == null) {
                    Log.d("test", "null drawable");
                } else {
                    Log.d("test", "not null drawable");
                }
            }
        }).start();
        return drawable;
    }
}
