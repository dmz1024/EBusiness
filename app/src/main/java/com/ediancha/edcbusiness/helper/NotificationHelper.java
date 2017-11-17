package com.ediancha.edcbusiness.helper;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.activity.my.PersonCenterActivity;

import java.io.InputStream;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Admin on 2017/10/16.
 */

public class NotificationHelper {

    private Context mContext;
    private Notification build;

    public NotificationHelper(Context mContext) {
        this.mContext = mContext;
    }


    public void initNotification(Class clazz, String title, String text, int resId,int rightResId,int id) {
        Intent intent = new Intent(mContext, clazz);
        PendingIntent pendingIntent = PendingIntent.getActivities(mContext, 1, new Intent[]{intent}, 0);
        NotificationManager systemService = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(mContext);

        InputStream inputStream = mContext.getResources().openRawResource(rightResId);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        builder.setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setTicker("您有一条新的消息!")
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(resId)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setLargeIcon(bitmap);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            build = builder.build();
        }
        build.tickerText=title;
        systemService.notify(id, build);
    }

}
