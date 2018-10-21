package com.industrialmaster.doca99;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class BookActivity extends AppCompatActivity {

    EditText name,phone,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.patient_name);
        phone = findViewById(R.id.contact_number);
        email = findViewById(R.id.email_address);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void confirm(View view){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final int sessionID = bundle.getInt("id");

        final String nm = name.getText().toString();
        final String ph = phone.getText().toString();
        final String em = email.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://idexserver.tk/im/channel/book/add.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(BookActivity.this,"Saved !", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BookActivity.this,"Error !", Toast.LENGTH_SHORT).show();
                    }
                }
                ){
            protected Map<String, String> getParams(){
                Map<String, String> param = new HashMap<>();
                param.put("name", nm);
                param.put("phone",ph);
                param.put("email",em);
                param.put("session_id",""+sessionID);

                return param;
            }
        };

        queue.add(request);

    }
}
