package com.industrialmaster.sdhashing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generateHash(View view){
        EditText txt = findViewById(R.id.text1);
        EditText setHash = findViewById(R.id.txtSetHash);

        int codes[] = new int[txt.length()];

        for(int i = 0;i<codes.length;i++){
            codes[i] = (int)txt.getText().charAt(i);
        }

        int hash[] = new int[codes.length];

        for(int i=0 ;i<hash.length-1;i++){
            hash[i] = (((codes[i] - codes[i + 1])) % 255)+49;
        }
        hash[hash.length-1] = codes[codes.length-1];

        String s = "";
        for(int i=0;i<hash.length;i++){
            s += Character.toString((char)hash[i]);
        }
        setHash.setText(s);
    }
}
