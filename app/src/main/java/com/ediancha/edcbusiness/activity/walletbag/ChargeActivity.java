package com.ediancha.edcbusiness.activity.walletbag;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.ChargeBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Admin on 2017/9/21.
 * 充值
 */
@Route(path = "/activity/walletbag/charge")
public class ChargeActivity extends SingleDataBaseActivity<ChargeBean, ChargeBean.Data> implements AdapterHelper.OnConvertInterface<ChargeBean.Moneys>, AdapterHelper.OnClickListener {

    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.rb_wechat)
    RadioButton mRbWechat;
    @BindView(R.id.rb_pay)
    RadioButton mRbPay;
    @BindView(R.id.rg_pay)
    RadioGroup mRgPay;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;
    AdapterHelper mAdapterHelper;


    @Override
    protected void initDataBuilder() {
        mBuilder.setCanRefresh(true).setSuccessRid(R.layout.activity_charge);
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("充值");
    }

    @Override
    protected void initDmzBuilder() {

        dBuilder.setaClass(ChargeBean.class)
                .setUrl(ApiContant.CHARGE)
                .setParms("userId","1");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, ChargeBean.Data bean) {
        mAdapterHelper = AdapterHelper._instance(this, mRecy)._initData(bean.getMoneys()).setLayoutManager(new GridLayoutManager(this, 3))
                .setType(new AdapterHelper.ViewTypeInfo().setType(0).setConvertInterface(this).setRid(R.layout.item_charge).setOnClickListener(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setConvertInterface(this).setRid(R.layout.item_charge_input).setOnClickListener(this));

    }

    @OnClick({R.id.tv_submit})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:

                break;
        }
    }

    @Override
    public void convert(final int viewType, final ViewHolder holder, final ChargeBean.Moneys chargeBean, final int position) {
        holder.getConvertView().setBackgroundResource(chargeBean.getCheck()? R.drawable.shape_circle_style :R.drawable.shape_circle_ra2);
        holder.setVisible(R.id.iv_show,chargeBean.getCheck());
        switch (viewType) {
            case 0:
                holder.setText(R.id.tv_cmoney, chargeBean.getcMoney()).setText(R.id.tv_zmoney,chargeBean.getsMoney());
                break;
            case 1:
                EditText mEd = holder.getView(R.id.et_cmoney);
                mEd.setFocusable(true);
                mEd.requestFocus();
                mEd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClick(viewType, mAdapterHelper,position);
                    }
                });

                break;
        }
    }




    //adapter点击监听 check==0未选中，1选中
    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        ArrayList<ChargeBean.Moneys> datas = (ArrayList<ChargeBean.Moneys>) adapterHelper.getDatas();
        for (int i = 0; i <datas.size() ; i++) {
            datas.get(i).setCheck(false);
        }
        datas.get(position).setCheck(true);

        LogUtil.e("xxxxxxxxxx");
        mAdapterHelper.notifyDataSetChanged();
    }
}