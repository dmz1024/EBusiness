package com.ediancha.edcbusiness.v1.helper;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.ediancha.edcbusiness.v1.view.RoundlProgresWithNum;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Admin on 2017/11/9.
 */

public class ProgressHelper {
    public static ProgressHelper getInstance() {
        return new ProgressHelper();
    }

    private CountDownTimer mTimer = new CountDownTimer(3000, 20) {
        @Override
        public void onTick(long l) {
            if (mListerner.onProgress(20)) {
                cancel();
            }
            ;
        }

        @Override
        public void onFinish() {

        }
    };


    private View mView;

    private TouchListerner mListerner;

    public ProgressHelper setListerner(TouchListerner listerner) {
        mListerner = listerner;
        return this;
    }

    float x, y;
    public ProgressHelper setView(View view) {
        mView = view;
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        mTimer.start();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (Math.abs((motionEvent.getX() - x)) > 10 || Math.abs((motionEvent.getY() - y)) > 5) {
                            mTimer.cancel();
                            mListerner.onProgress(0);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        mTimer.cancel();
                        mListerner.onProgress(0);
                        break;
                }
                return true;
            }
        });
        return this;
    }

    public interface TouchListerner {
        boolean onProgress(int progress);
    }

}
