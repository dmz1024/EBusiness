package com.ediancha.edcbusiness.dialog;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.SoftwareBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.helper.CodeHelper;
import com.ediancha.edcbusiness.presenter.user.CodePresenter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/10/11.
 */

public class IndetifyCodeDialog extends NoTitleDialoggFragment implements AdapterHelper.OnConvertInterface, AdapterHelper.OnClickListener, CodePresenter.ICodeView {


    TextView[] mPassWord = new TextView[6];
    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.tvCode)
    TextView mTvCode;
    @BindView(R.id.tvCodeTime)
    TextView mTvCodeTime;

    private String strPass;
    private int currentIndex = -1;
    private UpDatePasswordListener mPasswordListener;
    AdapterHelper adapterHelper;
    CodeHelper mCodeHelper;

    private ArrayList<SoftwareBean> mDatas = new ArrayList<>();
    private CodePresenter mCodePresenter;

    @Override
    protected void initData(View view) {
        super.initData(view);

        mCodePresenter = new CodePresenter(this);
        mCodeHelper=new CodeHelper(getContext(),mTvCode,mTvCodeTime);
        mPassWord[5].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().trim().length() > 0) {
                    strPass = "";
                    for (int i = 0; i < 6; i++) {
                        strPass += mPassWord[i].getText().toString().trim();
                    }
                    mPasswordListener.updatePassword(strPass);
                }
            }
        });
    }

    public IndetifyCodeDialog setPasswordListener(UpDatePasswordListener passwordListener) {
        mPasswordListener = passwordListener;
        return this;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        initPass(view);
        initRecyclerView();
    }

    @Override
    protected int getRid() {
        return R.layout.dialog_indetifycode;
    }


    private void initPass(View view) {
        mPassWord[0] = view.findViewById(R.id.pass1);
        mPassWord[1] = view.findViewById(R.id.pass2);
        mPassWord[2] = view.findViewById(R.id.pass3);
        mPassWord[3] = view.findViewById(R.id.pass4);
        mPassWord[4] = view.findViewById(R.id.pass5);
        mPassWord[5] = view.findViewById(R.id.pass6);
    }

    @Override
    protected int getGravity() {
        return Gravity.BOTTOM;
    }

    private void initRecyclerView() {

        for (int i = 1; i <= 9; i++) {
            mDatas.add(new SoftwareBean().setKey(i + ""));
        }
        mDatas.add(new SoftwareBean().setKey(""));
        mDatas.add(new SoftwareBean().setKey("0"));
        mDatas.add(new SoftwareBean().setKey("X"));

        adapterHelper = AdapterHelper._instance(getContext(), mRecy)._initData(mDatas).setLayoutManager(new GridLayoutManager(getContext(), 3))
                .setType(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_software).setConvertInterface(this).setOnClickListener(this));
    }


    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        SoftwareBean data = (SoftwareBean) iType;
        holder.setText(R.id.tv_key, data.getKey());
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        SoftwareBean datas = adapterHelper.getT(position);
        if (position < 11 && position != 9) {    //点击0~9按钮
            if (currentIndex >= -1 && currentIndex < 5) {      //判断输入位置
                mPassWord[++currentIndex].setText(datas.getKey());
            }
        } else {
            if (position == 11) {      //点击退格键
                if (currentIndex - 1 >= -1) {      //判断是否删除完毕
                    mPassWord[currentIndex--].setText("");
                }
            }
        }
    }
    @OnClick({R.id.tvCode})
    void onClick(View view){
        switch (view.getId()){
            case R.id.tvCode:
                mCodePresenter.getCode(UserInfoUtil.getUserPhone(),1);
                break;
        }
    }
    @Override
    public void codeSuccess() {
        mCodeHelper.codeSuccess();
    }



    public interface UpDatePasswordListener {
        void updatePassword(String pass);
    }
}
