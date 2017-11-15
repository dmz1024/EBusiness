package com.ediancha.edcbusiness.v1.activity.space;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/11/14.
 */

@Route(path = "/v1/activity/space/openinput")
public class OpenInputActivity extends NotNetBaseActivity {

    @BindView(R.id.et_input)
    EditText mEtInput;
    @BindView(R.id.tv_open)
    TextView mTvOpen;
    @BindView(R.id.img_open)
    ImageView mImgOpen;
    @BindView(R.id.tv_status)
    TextView mTvStatus;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_inputnumber;
    }

    private boolean isLight;

    @OnClick({R.id.tv_open, R.id.ln_open,R.id.tv_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_open:
                break;
            case R.id.ln_open:
                try {
                    CodeUtils.isLightEnable(!isLight);
                    isLight = !isLight;
                    mTvStatus.setText(isLight ? "关闭手电筒" : "打开手电筒");
                    mImgOpen.setImageResource(isLight ? R.mipmap.sd_open_icon : R.mipmap.sd_closs_icon);
                } catch (Exception e) {
                    MyToast.error("没有摄像头权限");
                }
                break;
            case R.id.tv_back:
                finish();
                break;
        }
    }

}
