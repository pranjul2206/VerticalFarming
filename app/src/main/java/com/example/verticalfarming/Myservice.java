package com.example.verticalfarming;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class Myservice extends Service {
    public Myservice() {
    }

    private MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("abc","here");

//        ShowNotifications();
//        player = MediaPlayer.create(this,
//                Settings.System.DEFAULT_RINGTONE_URI);
//        player.setLooping(true);
//        player.start();
        Log.i("abc","started");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("abc","running");
                int i=0;
                while (i<=100){
                    Log.d("abc","running process"+(i+1));
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    i++;
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
        player.stop();
    }
}
