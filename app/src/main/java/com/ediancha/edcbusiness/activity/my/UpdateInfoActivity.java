package com.ediancha.edcbusiness.activity.my;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.NormalContant;
import com.ediancha.edcbusiness.helper.ValidatorUtils;
import com.ediancha.edcbusiness.presenter.my.UpdateNamePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/10/10.
 */
@Route(path = "/activity/my/updateInfo")
public class UpdateInfoActivity extends NotNetBaseActivity implements UpdateNamePresenter.IUpDateNameView {

    @Autowired
    String title;
    @BindView(R.id.dmzBar)
    DmzBar mDmzBar;
    @BindView(R.id.et_key)
    EditText mEtKey;

    String key;

    private UpdateNamePresenter mUpdateNamePresenter;
    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        mUpdateNamePresenter=new UpdateNamePresenter(this);
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText(title)
                .addItemView(new DmzBar.DmzBarItemInfo().setTitle("确定"))
                .setOnItemOnClickListener(new DmzBar.OnItemOnClickListener() {
                    @Override
                    public void itemClick(int index) {
                        key = mEtKey.getText().toString().trim();
                        if (TextUtils.isEmpty(key) || !(ValidatorUtils.isUserName(key))){
                            MyToast.error("请输入正确的昵称!");
                        }else {
                            mUpdateNamePresenter.UpdateName(key,UserInfoUtil.userPhoto);
                        }
                    }
                });
    }

    @Override
    protected int getRid() {
        return R.layout.activity_updatainfo;
    }

    @Override
    public void responseCode(BaseBean bean) {
        if (bean.getCode()== NormalContant.SUCCESS_CODE){
            Intent intent = new Intent();
            intent.putExtra(NormalContant.KEY,key);
            setResult(NormalContant.RESULT_NAME_CODE,intent);
            finish();
        }
    }
}
