package com.example.travelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity  extends AppCompatActivity {

    TextView tvName_dt;
    TextView tvNameProvince_dt;
    TextView tvPrice_dt;
    TextView tvDescribe_dt;
    ImageView imgPic_dt;

    Button btnBackDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        AnhXa();

        String name = getIntent().getStringExtra("Name");
        String nameProvince = getIntent().getStringExtra("NameProvince");
        String price = getIntent().getStringExtra("Price");
        String describe = getIntent().getStringExtra("Describe");
        int picture = getIntent().getIntExtra("Picture",0);

        tvName_dt.setText(name);
        tvNameProvince_dt.setText(nameProvince);
        tvPrice_dt.setText(price);
        tvDescribe_dt.setText(describe);
        imgPic_dt.setImageResource(picture);

        btnBackDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(DetailActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

    }
    public void AnhXa(){
        btnBackDetail = (Button) findViewById(R.id.buttonBackDetail);
        tvName_dt = (TextView) findViewById(R.id.textviewName_dt) ;
        tvNameProvince_dt = (TextView) findViewById(R.id.textviewNameProvince_dt) ;
        tvPrice_dt = (TextView) findViewById(R.id.textviewPrice_dt) ;
        tvDescribe_dt = (TextView) findViewById(R.id.textviewDescribe_dt) ;
        imgPic_dt = (ImageView) findViewById(R.id.imageViewPicture_dt) ;
    }
}
