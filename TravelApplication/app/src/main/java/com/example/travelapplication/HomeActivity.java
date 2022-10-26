package com.example.travelapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;
import tour.Tour;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvCategory = findViewById(R.id.recyclerView_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();

        List<Tour> listTour = new ArrayList<>();
        listTour.add(new Tour("Ba Na Hills", "Đà Nẵng", "100 0000 VND","\"Đến với Sun World Ba Na Hills, du khách có cơ hội được thăm quan và trải nghiệm những công trình và điểm đến độc đáo, có một không hai.",R.drawable.banahill));
        listTour.add(new Tour("Phố cổ Hội An", "Quảng Nam", "800 000 VND","Hội An là một thành phố thuộc tỉnh Quảng Nam có nhiều khu phố cổ được xây từ thế kỷ 16 và vẫn còn tồn tại gần như nguyên vẹn đến nay. ", R.drawable.hoian));
        listTour.add(new Tour("Cầu Rồng", "Đà Nẵng", "100 000 VND", "Là cây cầu hình con rồng phun lửa và nước lên cao, là cây cầu huyền thoại bắc qua cái sông Hàn để mọi người với thể lưu thông tiện lợi hơn.",R.drawable.caurong));
        listTour.add(new Tour("Núi thần tài", "Đà Nẵng", "300 000 VND","Suối khoáng nóng tại Núi Thần Tài được khởi nguồn từ đỉnh thiêng Bà Nà và được bao bọc hai bên bởi đồi Thanh Long, đồi Bạch Hổ và phát lộ tại long huyệt thôn Phú Túc.", R.drawable.nuithantai));
        listTour.add(new Tour("Cố đô Huế", "Huế", "950 000 VND","Quần thể di tích Cố đô Huế nằm dọc hai bên bờ sông Hương thuộc thành phố Huế và một vài vùng phụ cận thuộc tỉnh Thừa Thiên Huế" ,R.drawable.codohue));
        listTour.add(new Tour("Biển Mỹ Khê", "Đà Nẵng", "200 000 VND","Bãi Biển Mỹ Khê nổi tiếng với cát trắng mịn, sóng biển ôn hòa, nước ấm quanh năm cùng hàng dừa thơ mộng, đẹp tuyệt vời bao quanh." ,R.drawable.bienmk));

        listTour.add(new Tour("Ba Na Hills", "Đà Nẵng", "100 0000 VND","\"Đến với Sun World Ba Na Hills, du khách có cơ hội được thăm quan và trải nghiệm những công trình và điểm đến độc đáo, có một không hai.",R.drawable.banahill));
        listTour.add(new Tour("Phố cổ Hội An", "Quảng Nam", "800 000 VND","Hội An là một thành phố thuộc tỉnh Quảng Nam có nhiều khu phố cổ được xây từ thế kỷ 16 và vẫn còn tồn tại gần như nguyên vẹn đến nay. ", R.drawable.hoian));
        listTour.add(new Tour("Cầu Rồng", "Đà Nẵng", "100 000 VND", "Là cây cầu hình con rồng phun lửa và nước lên cao, là cây cầu huyền thoại bắc qua cái sông Hàn để mọi người với thể lưu thông tiện lợi hơn.",R.drawable.caurong));
        listTour.add(new Tour("Núi thần tài", "Đà Nẵng", "300 000 VND","Suối khoáng nóng tại Núi Thần Tài được khởi nguồn từ đỉnh thiêng Bà Nà và được bao bọc hai bên bởi đồi Thanh Long, đồi Bạch Hổ và phát lộ tại long huyệt thôn Phú Túc.", R.drawable.nuithantai));
        listTour.add(new Tour("Cố đô Huế", "Huế", "950 000 VND","Quần thể di tích Cố đô Huế nằm dọc hai bên bờ sông Hương thuộc thành phố Huế và một vài vùng phụ cận thuộc tỉnh Thừa Thiên Huế" ,R.drawable.codohue));
        listTour.add(new Tour("Biển Mỹ Khê", "Đà Nẵng", "200 000 VND","Bãi Biển Mỹ Khê nổi tiếng với cát trắng mịn, sóng biển ôn hòa, nước ấm quanh năm cùng hàng dừa thơ mộng, đẹp tuyệt vời bao quanh." ,R.drawable.bienmk));

        listCategory.add(new Category("du lich 1",listTour));
        listCategory.add(new Category("du lich 2",listTour));
        listCategory.add(new Category("du lich 3",listTour));
        listCategory.add(new Category("du lich 4",listTour));

        return listCategory;
    }
}