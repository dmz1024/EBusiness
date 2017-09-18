package com.dmz.library.dmzapi.view.custom;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.R;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public class DmzBar extends FrameLayout implements View.OnClickListener {
    private LayoutInflater layoutInflater;
    private FrameLayout fgBarLeft;
    private ImageView ivBarLeft;
    private LinearLayout llBarRight;
    private TextView tvBarTitle;

    public DmzBar(Context context) {
        this(context, null);
    }

    public DmzBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        layoutInflater = ((AppCompatActivity) context).getLayoutInflater();
        layoutInflater.inflate(R.layout.view_dmz_bar, this);
        fgBarLeft = findViewById(R.id.fgBarLeft);
        ivBarLeft = findViewById(R.id.ivBarLeft);
        llBarRight = findViewById(R.id.llBarRight);
        tvBarTitle = findViewById(R.id.tvBarTitle);
        initView(context);
    }

    private void initView(Context context) {
        fgBarLeft.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        ((Activity) getContext()).finish();
    }


    public DmzBar setText(String text) {
        tvBarTitle.setText(text);
        return this;
    }

    public DmzBar setText(int id) {
        return setText(getContext().getString(id));
    }


}
