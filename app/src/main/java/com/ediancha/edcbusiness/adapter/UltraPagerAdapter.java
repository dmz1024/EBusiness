package com.ediancha.edcbusiness.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.ediancha.edcbusiness.R;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/9/28.
 */
public class UltraPagerAdapter extends PagerAdapter {

    ArrayList<String> mRrr;
    Context mContext;

    public UltraPagerAdapter(Context mContext, ArrayList<String> mRrr) {
        this.mContext = mContext;
        this.mRrr = mRrr;
    }

    @Override
    public int getCount() {
        return mRrr != null ? mRrr.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        String s = mRrr.get(position);
        ImageView linearLayout = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.item_vp_children, null);

        Glide.with(mContext)
                .load(s)
                .into(linearLayout);
        container.addView(linearLayout);
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView view = (ImageView) object;
        container.removeView(view);
    }
}
