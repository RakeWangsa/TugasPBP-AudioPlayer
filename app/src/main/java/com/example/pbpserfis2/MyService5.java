package com.example.pbpserfis2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService5 extends Service {
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this, R.raw.music5);
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}