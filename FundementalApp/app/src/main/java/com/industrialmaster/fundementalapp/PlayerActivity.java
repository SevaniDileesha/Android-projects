package com.industrialmaster.fundementalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    public void start(View view){
        Intent svc = new Intent(this, SoundService.class);
        startService(svc);
    }

    public void stop(View view){
        Intent svc = new Intent(this, SoundService.class);
        stopService(svc);
    }
}
