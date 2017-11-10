package com.ediancha.edcbusiness.activity.walletbag;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.pay.PayInfoBean;
import com.ediancha.edcbusiness.bean.walletbean.ChargeBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.pay.IPayResultInterface;
import com.ediancha.edcbusiness.helper.pay.Pay;
import com.ediancha.edcbusiness.helper.share.Share;
import com.ediancha.edcbusiness.presenter.charge.ChargePresenter;
import com.ediancha.edcbusiness.presenter.charge.CheckPayPresenter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Admin on 2017/9/21.
 * 充值
 */
@Route(path = "/activity/walletbag/charge")
public class ChargeActivity extends SingleDataBaseActivity<ChargeBean, ChargeBean.Data> implements AdapterHelper.OnConvertInterface<ChargeBean.Moneys>, AdapterHelper.OnClickListener, ChargePresenter.IChargeView, CheckPayPresenter.ICheckPayView {

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

    private String cMoney;

    private ChargePresenter mChargePresenter;
    private CheckPayPresenter mCheckPayPresenter;

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
                .setParms("userId", "1");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, ChargeBean.Data bean) {

        mTvMoney.setText("账户常用余额" + bean.getSurplus() + "元");

        mAdapterHelper = AdapterHelper._instance(this, mRecy)._initData(bean.getMoneys()).setLayoutManager(new GridLayoutManager(this, 3))
                .setType(new AdapterHelper.ViewTypeInfo().setType(0).setConvertInterface(this).setRid(R.layout.item_charge).setOnClickListener(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setConvertInterface(this).setRid(R.layout.item_charge_input).setOnClickListener(this));

    }

    @Override
    protected void initData() {
        super.initData();
        mChargePresenter = new ChargePresenter(this);
        mCheckPayPresenter = new CheckPayPresenter(this);
    }

    @OnClick({R.id.tv_submit})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                ArrayList<ChargeBean.Moneys> datas = (ArrayList<ChargeBean.Moneys>) mAdapterHelper.getDatas();
                for (int i = 0; i < datas.size(); i++) {
                    if (datas.get(i).getCheck()) {
                        if ((datas.size() - 1) == i) {
                            datas.get(i).setcMoney(cMoney);
                        }
                        ChargeBean.Moneys moneys = datas.get(i);
                        mChargePresenter.Pay(moneys.getId(), mRbPay.isChecked() ? 1 : 2, moneys.rechargeAmount, "1");
                        LogUtil.e("充值" + datas.get(i).getId() + "money" + datas.get(i).getcMoney());
                    }
                }
                break;
            default:
        }
    }

    @Override
    public void convert(final int viewType, final ViewHolder holder, final ChargeBean.Moneys chargeBean, final int position) {
        holder.setVisible(R.id.iv_show, chargeBean.getCheck());
        holder.getView(R.id.rl).setBackgroundResource(chargeBean.getCheck() ? R.drawable.shape_circle_style : R.drawable.shape_circle_ra2);
        switch (viewType) {
            case 0:
                holder.setText(R.id.tv_cmoney, chargeBean.getcMoney()).setText(R.id.tv_zmoney, chargeBean.getsMoney());
                break;
            case 1:
                holder.setText(R.id.et_cmoney, TextUtils.isEmpty(cMoney) ? "" : cMoney);
                final EditText mEd = holder.getView(R.id.et_cmoney);
                mEd.setFocusable(true);
                mEd.requestFocus();
                mEd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClick(viewType, mAdapterHelper, position);
                    }
                });
                //将光标移到最后一位
                mEd.post(new Runnable() {
                    @Override
                    public void run() {
                        mEd.setSelection(mEd.getText().toString().trim().length());
                    }
                });
                mEd.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        cMoney = charSequence + "";
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });
                break;
            default:
        }
    }


    //adapter点击监听 check==0未选中，1选中
    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        ArrayList<ChargeBean.Moneys> datas = (ArrayList<ChargeBean.Moneys>) adapterHelper.getDatas();
        for (int i = 0; i < datas.size(); i++) {
            datas.get(i).setCheck(false);
        }
        datas.get(position).setCheck(true);

        mAdapterHelper.notifyDataSetChanged();
    }

    @Override
    public void successCode(final PayInfoBean bean) {

//        Share.getShare(1).start(this,bean);

        Pay.getPay(mRbPay.isChecked()?1:0)
                .setListener(new IPayResultInterface() {
                    @Override
                    public void onSuccess() {
                        mCheckPayPresenter.checkPay(bean.getInfo(),(mRbPay.isChecked()?1:2)+"");
                    }

                    @Override
                    public void onCancel() {
                        MyToast.warn("您取消了本次支付!");
                    }

                    @Override
                    public void onFaile(String msg) {
                        MyToast.warn("本次支付失败!");
                    }
                }).start(this, bean.getData());
    }


    @Override
    public void successCode() {
        MyToast.normal("支付成功!");
    }

    @Override
    public void failCode() {

    }
}