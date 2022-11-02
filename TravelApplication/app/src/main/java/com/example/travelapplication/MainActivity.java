package com.example.travelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView ;
    private ListView lvDestination;
    ArrayList<Destination> destinationArrayList;
    DestinationAdapter destinationAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        destinationAdapter = new DestinationAdapter(this,R.layout.list_destination, destinationArrayList);
        lvDestination.setAdapter(destinationAdapter);

        lvDestination.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showInforDestination(i);
                return false;
            }
        });

        lvDestination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteSach(i);
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

    private void AnhXa() {
        lvDestination = (ListView) findViewById(R.id.listviewDestination);
        destinationArrayList = new ArrayList<>();
        destinationArrayList.add(new Destination("Ba Na Hills", "1.000.000 VND", "picture","Đến với Sun World Ba Na Hills, du khách có cơ hội được thăm quan và trải nghiệm những công trình và điểm đến độc đáo, có một không hai. ", R.drawable.banahill));
        destinationArrayList.add(new Destination("Phố cổ Hội An", "800.000 VND", "Quảng Nam","Hội An là một thành phố thuộc tỉnh Quảng Nam có nhiều khu phố cổ được xây từ thế kỷ 16 và vẫn còn tồn tại gần như nguyên vẹn đến nay. ", R.drawable.hoian));
        destinationArrayList.add(new Destination("Cầu Rồng", "100.000 VND", "Đà Nẵng", "Là cây cầu hình con rồng phun lửa và nước lên cao, là cây cầu huyền thoại bắc qua cái sông Hàn để mọi người với thể lưu thông tiện lợi hơn.",R.drawable.caurong));
        destinationArrayList.add(new Destination("Núi thần tài", "300.000 VND", "Đà Nẵng","Suối khoáng nóng tại Núi Thần Tài được khởi nguồn từ đỉnh thiêng Bà Nà và được bao bọc hai bên bởi đồi Thanh Long, đồi Bạch Hổ và phát lộ tại long huyệt thôn Phú Túc.", R.drawable.nuithantai));
        destinationArrayList.add(new Destination("Cố đô Huế", "950.000 VND", "Huế","Quần thể di tích Cố đô Huế nằm dọc hai bên bờ sông Hương thuộc thành phố Huế và một vài vùng phụ cận thuộc tỉnh Thừa Thiên Huế" ,R.drawable.codohue));
        destinationArrayList.add(new Destination("Biển Mỹ Khê", "200.000 VND", "Đà Nẵng","Bãi Biển Mỹ Khê nổi tiếng với cát trắng mịn, sóng biển ôn hòa, nước ấm quanh năm cùng hàng dừa thơ mộng, đẹp tuyệt vời bao quanh." ,R.drawable.bienmk));

    }

    private void showInforDestination(int position){
        Destination destination = destinationArrayList.get(position);

        Intent i = new Intent(this, DetailActivity.class);

        i.putExtra("Name",destination.getName());
        i.putExtra("NameProvince",destination.getNameProvince());
        i.putExtra("Price",destination.getPrice());
        i.putExtra("Describe",destination.getDescribe());
        i.putExtra("Picture", destination.getPicture());

        startActivity(i);
    }

    private void deleteSach(final int position){
        new AlertDialog.Builder(this)
                .setTitle("Delete TOUR")
                .setMessage("Do you want delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        destinationArrayList.remove(position);
                        destinationAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", null)
                .show();
    }


}