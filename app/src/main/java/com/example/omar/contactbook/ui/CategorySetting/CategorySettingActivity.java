package com.example.omar.contactbook.ui.CategorySetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Category;
import java.util.List;

public class CategorySettingActivity extends AppCompatActivity implements CategorySettingMvpView{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_setting);
        recyclerView = findViewById(R.id.rv_category_setting);

        CategorySettingPresenter presenter = new CategorySettingPresenter(this,CategorySettingActivity.this);
        presenter.actionGetAllCategory();
    }

    @Override
    public void getAllCategory(List<Category> categories) {
        adapter=new CategorySettingAdapter(CategorySettingActivity.this,categories);  // "this" is a contect of current activity....
        layoutManager=new LinearLayoutManager(CategorySettingActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
