package com.ediancha.edcbusiness.helper;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dengmingzhi on 2017/10/9.
 */

public class CodeHelper {
    private Context ctx;
    private View[] views;

    public CodeHelper(Context ctx, View... views) {
        this.ctx = ctx;
        this.views = views;
    }

    public void codeSuccess() {
        views[0].setEnabled(false);
        views[1].setVisibility(View.VISIBLE);
        timer.start();
    }

    private CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            ((TextView) views[1]).setText((int) (millisUntilFinished / 1000) + "S");
        }

        @Override
        public void onFinish() {
            views[0].setEnabled(true);
            views[1].setVisibility(View.GONE);
        }
    };

    public void close() {
        timer.cancel();
    }
}
