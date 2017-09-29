package com.dmz.library.dmzapi.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.utils.AnimationUtil;
import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dengmingzhi on 2017/9/27.
 */

public class ChooseStringDialog extends NoTitleDialoggFragment implements ChooseStringView.IChooseCancel {
    private ChooseStringView csView;

    public static ChooseStringDialog getInstance() {
        return new ChooseStringDialog();
    }


    @Override
    protected int getRid() {
        return gravity == Gravity.CENTER ? 0 : R.layout.dialog_choose_string;
    }

    @Override
    protected View getmView() {
        return csView = new ChooseStringView(getContext());
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        if (gravity == Gravity.BOTTOM) {
            csView = view.findViewById(R.id.csView);
            csView.setRvBack("#ffffff");
            BottomSheetBehavior<ChooseStringView> from = BottomSheetBehavior.from(csView);

            from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View view, int newState) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        cancel();
                    }
                }

                @Override
                public void onSlide(@NonNull View view, float v) {

                }
            });
        } else if (gravity == Gravity.CENTER) {
            isShowCancel = false;
            textGravity = Gravity.LEFT | Gravity.CENTER;
            csView.setBackgroundResource(R.drawable.shape_fff_ra5);
        }

        csView.setiChooseItem(iChooseItem).setItemTitle(itemTitle).setiChooseCancel(this).setShowCancel(isShowCancel).setTextGravity(textGravity).setData(datas);
    }

    private ArrayList<ChooseStringView.IChooseString> datas = new ArrayList<>();

    public ChooseStringDialog setDatas(ArrayList<ChooseStringView.IChooseString> datas) {
        this.datas.addAll(datas);
        return this;
    }

    private int gravity = Gravity.BOTTOM;
    private int textGravity = Gravity.CENTER;
    private boolean isShowCancel = true;

    public ChooseStringDialog setShowCancel(boolean showCancel) {
        isShowCancel = showCancel;
        return this;
    }

    public ChooseStringDialog setTextGravity(int textGravity) {
        this.textGravity = textGravity;
        return this;
    }

    public ChooseStringDialog setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    @Override
    protected int getWPadding() {
        return gravity == Gravity.CENTER ? 300 : super.getWPadding();
    }

    @Override
    protected int getGravity() {
        return gravity;
    }

    private ChooseStringView.IChooseItem iChooseItem;
    private ChooseStringView.IChooseItemTitle itemTitle;

    public ChooseStringDialog setiChooseItem(ChooseStringView.IChooseItemTitle itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }

    public ChooseStringDialog setiChooseItem(ChooseStringView.IChooseItem iChooseItem) {
        this.iChooseItem = iChooseItem;
        return this;
    }

    @Override
    public void cancel() {
        dismiss();
    }

    public <T extends ChooseStringView.IChooseString> ChooseStringDialog addData(T data) {
        datas.add(data);
        return this;
    }

    public <T extends ChooseStringView.IChooseString> ChooseStringDialog addData(ArrayList<T> data) {
        datas.addAll(data);
        return this;
    }


    public ChooseStringDialog addData(String... title) {
        for (int i = 0; i < title.length; i++) {
            datas.add(new ChooseStringView.ChooseStringBean().setTitle(title[i]));
        }
        return this;
    }



}
