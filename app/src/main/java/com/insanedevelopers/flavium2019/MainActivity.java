package com.insanedevelopers.flavium2019;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Handler handler=new Handler();
     TextView t1_hrs,t2_min,t3_sec;
     LinearLayout l1,l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        t1_hrs=findViewById(R.id.txt_hrs);
        t2_min=findViewById(R.id.txt_min);
        t3_sec=findViewById(R.id.txt_sec);
        //timer function called
        countdownstart();
    }
    //timer function definition
    void countdownstart()
    {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try{
                    Calendar cal = Calendar.getInstance();
                    Date d=cal.getTime();
                    DateFormat dateFormat=new SimpleDateFormat("HH:MM:SS");
                    String Formatteddate= dateFormat.format(d);
                    String time[] = Formatteddate.split(":");
                    if(Integer.parseInt(time[0])<18) {

                        int sec = Integer.valueOf(time[2]);
                        int min = Integer.valueOf(time[1]);
                        int hrs = Integer.valueOf(time[0]);
                        int diffsec = 60 - sec;
                        int diffmin = 60 - min;
                        int diffhrs = 18 - hrs;
                        t1_hrs.setText(String.valueOf(diffhrs));
                        t2_min.setText(String.valueOf(diffmin));
                        t3_sec.setText(String.valueOf(diffsec));
                    }
                    else
                    {
                        l1.setVisibility(View.GONE);
                        l2.setVisibility(View.GONE);
                        t1_hrs.setVisibility(View.GONE);
                        t2_min.setVisibility(View.GONE);
                        t3_sec.setVisibility(View.GONE);

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable,1*1000);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
