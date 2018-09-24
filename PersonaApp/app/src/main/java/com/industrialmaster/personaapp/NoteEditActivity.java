package com.industrialmaster.personaapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class NoteEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
    }

    public void saveNote(View view){
        EditText et = findViewById(R.id.note_editor);
        String content = et.getText().toString();

        try{
            FileOutputStream fo = openFileOutput("notes.txt", Context.MODE_PRIVATE);
            fo.write(content.getBytes());
            fo.close();

            Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, NoteActivity.class);
            startActivity(intent);

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error writing to storage" , Toast.LENGTH_SHORT).show();
        }
    }
}
