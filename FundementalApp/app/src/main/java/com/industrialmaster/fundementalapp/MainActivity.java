package com.industrialmaster.fundementalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Created...", Toast.LENGTH_SHORT).show();
    }

    public void onStart(){
        super.onStart();
        Toast.makeText(this, "started...", Toast.LENGTH_SHORT).show();
    }

    public void onResume(){
        super.onResume();
        Toast.makeText(this, "resumed...", Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Toast.makeText(this, "paused...", Toast.LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();
        Toast.makeText(this, "stopped...", Toast.LENGTH_SHORT).show();
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "destroyed...", Toast.LENGTH_SHORT).show();
    }

    public void onRestart(){
        super.onRestart();
        Toast.makeText(this, "restarted...", Toast.LENGTH_SHORT).show();
    }

    public void player(View view){
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }

    public void downloader(View view){
        Intent intent = new Intent(this, DownloaderActivity.class);
        startActivity(intent);
    }
}
