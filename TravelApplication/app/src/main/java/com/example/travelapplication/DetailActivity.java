package com.example.travelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travelapplication.databinding.ActivityDetailBinding;
public class DetailActivity  extends AppCompatActivity {

    private TextView tvName_dt;
    private TextView tvNameProvince_dt;
    private TextView tvPrice_dt;
    private TextView tvDescribe_dt;
    private ImageView imgPic_dt;

    Button btnBackDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName_dt = (TextView) findViewById(R.id.textviewName_dt) ;
        tvNameProvince_dt = (TextView) findViewById(R.id.textviewNameProvince_dt) ;
        tvPrice_dt = (TextView) findViewById(R.id.textviewPrice_dt) ;
        tvDescribe_dt = (TextView) findViewById(R.id.textviewDescribe_dt) ;
        imgPic_dt = (ImageView) findViewById(R.id.imageViewPicture_dt) ;


        String name = getIntent().getStringExtra("Name");
        String nameProvince = getIntent().getStringExtra("NameProvince");
        String price = getIntent().getStringExtra("Price");
        String describe = getIntent().getStringExtra("Describe");
        int picture = getIntent().getIntExtra("Picture",0);

        imgPic_dt.setImageResource(picture);
        tvName_dt.setText(name);
        tvNameProvince_dt.setText(nameProvince);
        tvPrice_dt.setText(price);
        tvDescribe_dt.setText(describe);

        AnhXa();
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
    }
}
