package com.dmz.library.dmzapi.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmz.library.dmzapi.R;
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
        return R.layout.dialog_choose_string;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        csView = view.findViewById(R.id.csView);
        BottomSheetBehavior<ChooseStringView> from = BottomSheetBehavior.from(csView);
        csView.setiChooseItem(iChooseItem).setiChooseCancel(this);
        csView.setData(datas);
    }

    private ArrayList<ChooseStringView.IChooseString> datas = new ArrayList<>();

    public ChooseStringDialog setDatas(ArrayList<ChooseStringView.IChooseString> datas) {
        this.datas = datas;
        return this;
    }


    @Override
    protected int getGravity() {
        return Gravity.BOTTOM;
    }

    private ChooseStringView.IChooseItem iChooseItem;


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

    public ChooseStringDialog show(AppCompatActivity activity) {
        show(activity.getSupportFragmentManager(), "chooseDialog");
        return this;
    }


}
