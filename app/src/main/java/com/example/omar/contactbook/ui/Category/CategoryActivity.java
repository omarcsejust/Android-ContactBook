package com.example.omar.contactbook.ui.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Category;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryMvpView{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.rv_category);

        CategoryPresenter presenter = new CategoryPresenter(this,CategoryActivity.this);
        presenter.actionGetCategoryList();
    }

    @Override
    public void getCategoryList(List<Category> categories) {
        layoutManager = new GridLayoutManager(CategoryActivity.this,2);
        adapter = new CategoryAdapter(CategoryActivity.this,categories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
