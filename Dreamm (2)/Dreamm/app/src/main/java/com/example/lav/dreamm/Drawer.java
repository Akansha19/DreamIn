package com.example.lav.dreamm;

import android.media.ImageReader;
import android.net.Uri;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.util.ArrayList;

public class Drawer extends AppCompatActivity {
    private DrawerLayout m;
    private ActionBarDrawerToggle t;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);


        m = (DrawerLayout) findViewById(R.id.drawer);
        t = new ActionBarDrawerToggle(this, m, R.string.open, R.string.close);
        m.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //start fragments//
        getSupportActionBar().setTitle("Home");
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main, new Home());
        fragmentTransaction.commit();
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){

                    case R.id.about:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main,new About());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About us");
                        item.setChecked(true);
                        m.closeDrawers();
                        break;
                    case R.id.demo:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main,new Demo());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Demo");
                        item.setChecked(true);
                        m.closeDrawers();
                        break;
                    case R.id.gallery:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main,new Gallery());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Gallery");
                        item.setChecked(true);
                        m.closeDrawers();
                        break;
                    case R.id.contact:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main,new Contact());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Contact us");
                        item.setChecked(true);
                        m.closeDrawers();
                        break;

                }
                return false;
            }
        });



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

