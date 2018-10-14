package com.industrialmaster.doca99;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.industrialmaster.doca99.tasks.DoctorSessionListTask;

public class DoctorSessionActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_session);

        lv = findViewById(R.id.doctorSession);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int sid = bundle.getInt("sid");
        int did = bundle.getInt("did");
        int hid = bundle.getInt("hid");
        DoctorSessionListTask dslt = new DoctorSessionListTask(sid,did,hid);
        dslt.execute(lv);
    }
}
