package com.industrialmaster.sampleui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void profileFrame(View view){

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}