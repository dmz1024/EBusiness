package com.ediancha.edcbusiness.activity.my;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.NormalContant;
import com.ediancha.edcbusiness.dialog.AutherDialog;
import com.ediancha.edcbusiness.helper.ValidatorUtils;
import com.ediancha.edcbusiness.presenter.user.AuthorPresnter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/9/28.
 * <p>
 * 认证界面
 */
@Route(path = "/activity/my/auther")
public class AutherActivity extends NotNetBaseActivity implements AuthorPresnter.IAuthorView {


    @BindView(R.id.tv_info)
    TextView mTvInfo;
    @BindView(R.id.tv_name)
    EditText mTvName;
    @BindView(R.id.tv_card)
    EditText mTvCard;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;

    private AutherDialog mAutherDialog;


    AuthorPresnter mAuthorPresnter;

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("实名认证");
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_auther;
    }

    @Override
    protected void initData() {
        super.initData();
        mAuthorPresnter = new AuthorPresnter(this);
    }

    @OnClick({R.id.tv_submit})
    void click() {
        final String name = mTvName.getText().toString().trim();
        final String card = mTvCard.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(card)) {
            MyToast.warn("请输入详细信息!");
        } else if (!ValidatorUtils.isIDCard(card)) {
            MyToast.error("请输入正确身份证号码!");
        } else {
            mAutherDialog = new AutherDialog();
            mAutherDialog.show(ctx);
            mAutherDialog.setName(name)
                    .setCard(card)
                    .setOkClickListner(new AutherDialog.okClickListner() {
                        @Override
                        public void setOnOkListener() {
                            mAuthorPresnter.authentication(name, card, UserInfoUtil.getUserId(), UserInfoUtil.getToken());
                            mAutherDialog.dismiss();
                        }
                    });
        }
    }

    @Override
    public void successCode(BaseBean bean) {

        if (bean.getCode() == NormalContant.SUCCESS_CODE) {
            MyToast.normal("认证成功!");
            finish();
        }
    }
}
