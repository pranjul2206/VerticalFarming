package com.example.verticalfarming;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class foregroundprocess extends Service {
    public foregroundprocess() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("abc","started");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("abc","running");
                int j=0;
                while (j<=10){
                    Log.i("abc","running process j"+j);
                    try{
                        Log.i("abc","inside try");
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        Log.i("abc","error");
                        e.printStackTrace();
                    }
                    j++;
                }
            }
        });
        thread.start();
        return START_STICKY;
    }

    private void ShowNotifications() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"channelId");
        builder
                .setOngoing(true)
                .setSmallIcon(R.drawable.ic_menu_send)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Service is running background")
                .build();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopping the player when service is destroyed
        Log.i("abc","destroyed");
    }
}
