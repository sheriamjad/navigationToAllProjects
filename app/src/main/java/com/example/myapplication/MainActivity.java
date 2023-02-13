package com.example.myapplication;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    //TextView tv;

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        //to manage toggle
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.git_commands:
                        String url="https://github.com/sheriamjad/GitDetailWebPage_A-1.git";
                        Intent intent= new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                        break;

                    case R.id.quran_app:
                        String url2="https://github.com/sheriamjad/QuranApp_A-2.git";
                        Intent intent2= new Intent(Intent.ACTION_VIEW);
                        intent2.setData(Uri.parse(url2));
                        startActivity(intent2);
                        break;

                    case R.id.salah_tracker:
                        String url3="https://github.com/SabaInam7/Group1-TrackerSalah/tree/main/app";
                        Intent intent3= new Intent(Intent.ACTION_VIEW);
                        intent3.setData(Uri.parse(url3));
                        startActivity(intent3);
                        break;
                    case R.id.hifz_app:
                        String url4="https://github.com/sheriamjad/HifzApp/tree/main/app";
                        Intent intent4= new Intent(Intent.ACTION_VIEW);
                        intent4.setData(Uri.parse(url4));
                        startActivity(intent4);
                        break;

                }

                return true;
            }
        });

    }
}

//        try {
//            JSONArray obj= new JSONArray(loadJSONfromAssets());
//            //implementation of loop for getting ayat list data
//            for(int i=0;i<obj.length();i++){
//                JSONObject ayatDetail=obj.getJSONObject(i);
//
//                Log.d("TAG", ayatDetail.getString("number"));
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
//    private String loadJSONfromAssets() {
//        String json = null;
//        try {
//            InputStream is = getAssets().open("QuranMetaData.json");
//            int size = is.available();
//
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return json;
//    }
//}