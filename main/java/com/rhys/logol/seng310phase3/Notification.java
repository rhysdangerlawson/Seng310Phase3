package com.rhys.logol.seng310phase3;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class Notification extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        first();
        startActivity(new Intent(this,CalenderActivity.class));
    }

    public void showNotification(View v) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.defaultprofilepicture);
        builder.setContentTitle("TimeTracker");
        builder.setContentText("A reminder: You have golf with Sherry in 20 minutes!");
        Intent intent = new Intent(this,CalenderActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(CalenderActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());
        first();
    }

    public void first(){
        new CountDownTimer(40000, 1000) { //40000 milli seconds is total time, 1000 milli seconds is time interval

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                showNotification(findViewById(R.id.activity_calender));
            }
        }.start();
    }
}
