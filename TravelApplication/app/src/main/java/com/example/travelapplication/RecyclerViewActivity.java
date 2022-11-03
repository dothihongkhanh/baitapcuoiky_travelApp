package com.example.travelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView ;
    ImageButton ibAdd;

    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel> options=
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("tour"),MainModel.class)
                        .build();

        mainAdapter=new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);

        ibAdd=(ImageButton) findViewById(R.id.button_add);
        ibAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddTourActivity.class));
            }
        });
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
                if(item.getItemId() == R.id.nav_notice){
                    Intent intent=new Intent(getApplicationContext(),RecyclerViewActivity.class);
                    startActivity(intent);
                }
                return true;

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.startListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String str) {
                txtSearch(str);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String str) {
                txtSearch(str);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);}
        private void txtSearch(String str){
            FirebaseRecyclerOptions<MainModel> options=
                    new FirebaseRecyclerOptions.Builder<MainModel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("tour").orderByChild("nameProvince").startAt(str).endAt(str +"\uf8ff"),MainModel.class)
                            .build();

            mainAdapter = new MainAdapter(options);
            mainAdapter.startListening();
            recyclerView.setAdapter(mainAdapter);

        }
    }
