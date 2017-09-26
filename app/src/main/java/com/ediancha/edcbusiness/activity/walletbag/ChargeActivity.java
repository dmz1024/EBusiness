package com.ediancha.edcbusiness.activity.walletbag;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
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
    protected void initDmzBuilder() {

        dBuilder.setaClass(ChargeBean.class)
                .setUrl(ApiContant.CHARGE)
                .setParms("type", "7");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, ChargeBean.Data bean) {
        addDatas(bean.getMoneys());
    }


    @OnClick({R.id.tv_submit})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                Log.d("你好", "ddd");
                break;
        }
    }

    private void addDatas(ArrayList<ChargeBean.Moneys> datas) {
        mAdapterHelper = AdapterHelper._instance(this, mRecy)._initData(datas).setLayoutManager(new GridLayoutManager(this, 3))
                .setType(new AdapterHelper.ViewTypeInfo().setType(0).setConvertInterface(this).setRid(R.layout.item_charge).setOnClickListener(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setConvertInterface(this).setRid(R.layout.item_charge_input).setOnClickListener(this));
    }

    @Override
    public void convert(int viewType, final ViewHolder holder, final ChargeBean.Moneys chargeBean, final int position) {
        switch (viewType) {
            case 0:
                holder
                        .setText(R.id.tv_cmoney, chargeBean.getcMoney())
                        .setText(R.id.tv_zmoney, chargeBean.getsMoney());//test
                LinearLayout view = holder.getView(R.id.cv_bg);
                TextView cMoney = holder.getView(R.id.tv_cmoney);

                cMoney.setTextColor(chargeBean.getCheck() == 1 ? getResources().getColor(R.color.color_f00) : getResources().getColor(R.color.color_333));
                view.setBackgroundDrawable(chargeBean.getCheck() == 1 ? getResources().getDrawable(R.drawable.shape_circle_style) : getResources().getDrawable(R.drawable.shape_circle_ra2));
                holder.getView(R.id.iv_show).setVisibility(chargeBean.getCheck() == 1 ? View.VISIBLE : View.INVISIBLE);

                break;
            case 1:
                final EditText etCMoney = holder.getView(R.id.et_cmoney);
                holder.setText(R.id.tv_zmoney, chargeBean.getsMoney());
                if (chargeBean.getwMoney() != null) {
                    etCMoney.setText(chargeBean.getwMoney());
                } else {
                    etCMoney.setHint(chargeBean.getcMoney());
                }
                etCMoney.setTextColor(chargeBean.getCheck() == 1 ? getResources().getColor(R.color.color_f00) : getResources().getColor(R.color.color_333));
                holder.getView(R.id.cv_bg).setBackgroundDrawable(chargeBean.getCheck() == 1 ? getResources().getDrawable(R.drawable.shape_circle_style) : getResources().getDrawable(R.drawable.shape_circle_ra2));
                holder.getView(R.id.iv_show).setVisibility(chargeBean.getCheck() == 1 ? View.VISIBLE : View.INVISIBLE);

                etCMoney.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        etCMoney.setTextColor(getResources().getColor(R.color.color_f00));
                        holder.getView(R.id.cv_bg).setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_circle_style));
                        if (etCMoney != null) {
                            ArrayList<ChargeBean.Moneys> datas = (ArrayList<ChargeBean.Moneys>) mAdapterHelper.getDatas();
                            for (int i = 0; i < datas.size(); i++) {
                                if (position == i) {
                                    ChargeBean.Moneys moneys = datas.get(i);
                                    moneys.setCheck(1);
                                } else {
                                    ChargeBean.Moneys moneys = datas.get(i);
                                    moneys.setCheck(0);
                                }
                            }
                            mAdapterHelper.notifyDataSetChanged();
                        }
                    }
                });
                etCMoney.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        chargeBean.setwMoney(charSequence.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                break;
        }
    }

    //adapter点击监听 check==0未选中，1选中
    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        ArrayList<ChargeBean.Moneys> datas = null;
        datas = (ArrayList<ChargeBean.Moneys>) adapterHelper.getDatas();
        for (int i = 0; i < datas.size(); i++) {
            if (position == i) {
                datas.get(i).check = 1;
            } else {
                datas.get(i).check = 0;
            }
        }
        addDatas(datas);
        mAdapterHelper.notifyDataSetChanged();
    }


}