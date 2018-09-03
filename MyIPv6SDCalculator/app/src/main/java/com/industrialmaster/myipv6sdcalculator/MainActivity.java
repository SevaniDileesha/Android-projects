package com.industrialmaster.myipv6sdcalculator;

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

    public void calculateIPv6(View view){
        EditText mac = findViewById(R.id.MACAddress);
        EditText ipv = findViewById(R.id.LOAddress);

        String s = mac.getText().toString();

        int f = Integer.parseInt(Character.toString(s.charAt(1)));
        f +=2;

        String newName = s.substring(0,1)+Integer.toString(f)+s.substring(2);

        String set[] = newName.split(":");

        String build = set[0]+set[1]+":"+set[2]+"ff"+":fe"+set[3]+":"+set[4]+set[5];

        ipv.setText(build);

    }
}
