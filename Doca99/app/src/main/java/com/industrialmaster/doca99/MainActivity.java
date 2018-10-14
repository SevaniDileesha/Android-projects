package com.industrialmaster.doca99;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import com.industrialmaster.doca99.tasks.DoctorListTask;
import com.industrialmaster.doca99.tasks.HospitalListTask;
import com.industrialmaster.doca99.tasks.SpecialityListTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    AutoCompleteTextView acSpeciality, acDoctor, acHospital;
    int sid,hid,did;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        acSpeciality = findViewById(R.id.acSpeciality);
        acDoctor = findViewById(R.id.acDoctor);
        acHospital = findViewById(R.id.acHospital);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final SpecialityListTask slt = new SpecialityListTask();
        final DoctorListTask dct = new DoctorListTask();
        final HospitalListTask hpt = new HospitalListTask();
        slt.execute(acSpeciality);
        dct.execute(acDoctor);
        hpt.execute(acHospital);

        acSpeciality.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int index, long l) {
                sid = slt.data.get(acSpeciality.getText().toString());
            }
        });

        acDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                did = dct.data.get(acDoctor.getText().toString());
            }
        });

        acHospital.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                hid = hpt.data.get(acHospital.getText().toString());
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_appointments) {
            // Handle the camera action
        } else if (id == R.id.nav_doctor) {

        } else if (id == R.id.nav_hospital) {

        } else if (id == R.id.nav_logout) {

        } else if (id == R.id.nav_speciality) {

        } else if (id == R.id.nav_profile) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void search(View view){

        Intent intent = new Intent(this, DoctorSessionActivity.class);
        intent.putExtra("sid",sid);
        intent.putExtra("sid",hid);
        intent.putExtra("sid",did);
        startActivity(intent);
    }

    public void clear(View view){
        hid = 0;
        sid = 0;
        did = 0;

        acSpeciality.setText("");
        acDoctor.setText("");
        acHospital.setText("");
    }
}
