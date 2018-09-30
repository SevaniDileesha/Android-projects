package com.industrialmaster.quickapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }

    public void save(View view){
        EditText ed_name = findViewById(R.id.tast_name);
        EditText ed_date = findViewById(R.id.task_date);

        String name = ed_name.getText().toString();
        String date = ed_date.getText().toString();

        DBHelper dbHelper = new DBHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String query = "INSERT INTO tasks (name, date, complete) VALUES ('"+name+"', '"+date+"', false)";
        db.execSQL(query);
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }
}
