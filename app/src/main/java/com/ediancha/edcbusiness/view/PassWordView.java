package com.ediancha.edcbusiness.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Admin on 2017/10/11.
 */

@SuppressLint("AppCompatCustomView")
public class PassWordView extends EditText {

    private Paint mMainPaint;
    private Paint mCirclePaint;
    private Paint mLinePaint;

    private int mMaxLenth=6;//长度
    private int width;
    private int height;

    public PassWordView(Context context) {
        super(context);
    }

    public PassWordView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PassWordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }



    private void initPaint(){
        mCirclePaint=new Paint();
        mCirclePaint.setStyle(Paint.Style.FILL);
        mLinePaint=new Paint();
        mMainPaint=new Paint();
        mCirclePaint.setColor(Color.parseColor("#333"));
        mLinePaint.setColor(Color.parseColor("#999"));
        mMainPaint.setColor(Color.parseColor("#999"));
    }


}
