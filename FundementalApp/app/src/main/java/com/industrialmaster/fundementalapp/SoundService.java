package com.industrialmaster.fundementalapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class SoundService extends Service {

    private static final String TAG = null;
    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.song);
        player.setLooping(true);
        player.setVolume(100,100);
    }

    public int onStartCommand(Intent intent, int flags, int startid){
        player.start();
        return Service.START_STICKY;
    }

    public void onDestroy(){
        player.stop();
        player.release();
    }
}
