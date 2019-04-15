package com.wapexp.www.khuramdesign;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectZone extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout jDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_nav);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        try {
             setSupportActionBar(toolbar);
        }catch (Exception e){}


        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_Select_Zone()).commit();
        }catch (Exception e){}

        jDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, jDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        jDrawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation code item clicks here.
        int id = item.getItemId();

       if (id == R.id.select_zone) {
            try {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_Select_Zone()).commit();
            }catch (Exception e){}
        } else  if (id == R.id.scan) {
           try {
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_Scan()).commit();
           }catch (Exception e){}
       } else if (id == R.id.info) {
           try {
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_Info()).commit();
           }catch (Exception e){}
        } else if (id == R.id.all_users) {
           try {
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Fragment_All_User()).commit();
           }catch (Exception e){}

        } else if(id == R.id.exit){
           finish();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}


