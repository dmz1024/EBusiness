package com.ediancha.edcbusiness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Admin on 2017/11/7.
 */

public class RotateTextView extends android.support.v7.widget.AppCompatTextView {

    public RotateTextView(Context context) {
        super(context);
    }

    public RotateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 倾斜度45,上下左右居中
        int w=getMeasuredWidth();
        canvas.rotate(-45,w,w);
        // 绘制这个三角形,你可以绘制任意多边形
        Paint p1 = new Paint();
        p1.setColor(Color.RED);// 设置红色
        p1.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo((int)(w/3), (int)(w/3));// 此点为多边形的起点
        path.lineTo((int)(w*1.67), (int)(w/3));
        path.lineTo(w, w);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, p1);

        Paint p = new Paint();
        p.setColor(Color.WHITE);// 设置白色
        p.setTextSize((int)(w*0.23));//设置字体大小
        canvas.drawText(text, (int)(w*0.66), (int)(w*0.60), p);
        super.onDraw(canvas);
    }

    /** 要显示的文字 */
    private String text="新标签";
    public void setText(String text) {
        this.text=text;
        invalidate();//重绘刷新Textview内容
    }
}