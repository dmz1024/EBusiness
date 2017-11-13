package com.ediancha.edcbusiness.v1.activity.order;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.TimeFormatUtils;
import com.ediancha.edcbusiness.v1.dialog.DepositDialog;
import com.ediancha.edcbusiness.v1.helper.ProgressHelper;
import com.ediancha.edcbusiness.v1.view.RoundlProgresWithNum;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 进行中订单
 *
 * @author Admin
 * @date 2017/11/9
 */
@Route(path = "/v1/activity/order/ordering")
public class OrderingActivity extends NotNetBaseActivity {


    @BindView(R.id.dmzBar)
    DmzBar mDmzBar;
    @BindView(R.id.tv_userlong)
    TextView mTvUserlong;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_end)
    TextView mTvEnd;
    @BindView(R.id.img_lock)
    ImageView mImgLock;
    @BindView(R.id.progress)
    RoundlProgresWithNum mProgress;
    @BindView(R.id.rl_press)
    RelativeLayout mRlPress;

    @Override
    protected void initView() {
        super.initView();
        mProgress.setMax(2000);

        mCountDownTimer.start();
        ProgressHelper.getInstance().setListerner(new ProgressHelper.TouchListerner() {
            @Override
            public boolean onProgress(int progress) {
                if (progress != 0) {
                    if (mProgress != null) {
                        progress(mProgress.getProgress() + 20);
                        if (mProgress.getProgress() >= mProgress.getMax()) {
                            MyToast.normal("完成");
                            mImgLock.setImageDrawable(getResources().getDrawable(R.mipmap.suo_open_icon));

                            progress(0);
                            return true;
                        }
                    }
                } else {
                    progress(0);
                }

                return false;
            }
        }).setView(mRlPress);
    }

    private void progress(int progress) {
        if (Build.VERSION.SDK_INT >= 24) {
            mProgress.setProgress(progress, true);
        } else {
            mProgress.setProgress(progress);
        }
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("进行中");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_ordering;
    }


    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.start();
        }
    }


    private CountDownTimer mCountDownTimer = new CountDownTimer(10 * 60 * 60 * 1000, 1000) {
        @Override
        public void onTick(long l) {
            long hour = l/(60*60*1000);
            long minute = (l - hour*60*60*1000)/(60*1000);
            long second = (l - hour*60*60*1000   - minute*60*1000)/1000;
            if (mTvTime != null) {
                mTvTime.setText(hour + ":" + minute + ":" + second);
            }
        }

        @Override
        public void onFinish() {

        }
    };


}
