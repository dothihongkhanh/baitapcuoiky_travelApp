package com.example.travelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //phan biet dang o Flagment nao
    private static  final  int FRAGMENT_HOME = 0;
    private static  final  int FRAGMENT_SETTINGLANG = 1;
    private static  final  int FRAGMENT_CHANGEPASS = 2;
    private static  final  int FRAGMENT_APPINFO = 3;

    BottomNavigationView bottomNavigationView ;

    private int currentFragment = FRAGMENT_HOME;
    private DrawerLayout drawerLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        //add toolbar, bat su kien khi click vao 3 dau gach
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //bat su kien khi click vao item
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        //replaceFracment(new homefragmet()); //vao phat la ra home
        //navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);// vao phat la ra home -> item home da duoc chon
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.nav_profile){
                    Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent);
                }
                if(item.getItemId() == R.id.nav_home1){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }


                return true;
                /*int id= item.getItemId();
                if(id==R.id.nav_home1){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else if(id==R.id.nav_profile){
                    Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent);
                }*/
                //dong drawer lai
                //return true;
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.nav_home){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);


        }else if(id==R.id.nav_SettingLanguage){
            if(currentFragment != FRAGMENT_SETTINGLANG){
                //replaceFracment(new SettingLangFragment());
                currentFragment = FRAGMENT_SETTINGLANG;
            }
        }else if(id==R.id.nav_ChangePassword){

        }else if(id==R.id.nav_AppInfo){

        }else if(id==R.id.nav_Logout){
            Intent intent=new Intent(getApplicationContext(),StartActivity.class);
            startActivity(intent);
        }
        //dong drawer lai
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //khi click vao nut back cua device
    @Override
    public void onBackPressed() {
        //neu drawer dang mo thi dong drawer
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed(); //thoat app
        }
    }
    private void replaceFracment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment); //content_frame: la id cua layout ma ta se replace fragment vao
        transaction.commit();
    }


}
