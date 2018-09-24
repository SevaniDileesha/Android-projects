package com.industrialmaster.personaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void save(View view){
        EditText edName = findViewById(R.id.name);
        EditText edEmail = findViewById(R.id.email);
        EditText edPhone = findViewById(R.id.phone);

        SharedPreferences profile = getSharedPreferences("profile", MODE_PRIVATE);
        SharedPreferences.Editor editor =  profile.edit();
        editor.putString("NAME", edName.getText().toString());
        editor.putString("EMAIL", edEmail.getText().toString());
        editor.putString("PHONE", edPhone.getText().toString());

        editor.commit();

        Toast.makeText(this, "Success!!!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void exit(View view){
        finish();
        System.exit(0);
    }
}
