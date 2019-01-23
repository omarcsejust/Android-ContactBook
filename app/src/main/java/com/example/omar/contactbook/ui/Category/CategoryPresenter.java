package com.example.omar.contactbook.ui.Category;

import android.content.Context;

import com.example.omar.contactbook.data.Database.AppDatabase;
import com.example.omar.contactbook.data.Models.Category;

import java.util.List;

public class CategoryPresenter {

    private CategoryMvpView mvpView;
    private AppDatabase appDatabase;

    public CategoryPresenter(CategoryMvpView mvpView, Context context){
        this.mvpView = mvpView;
        appDatabase = AppDatabase.getAppDatabase(context);
    }

    public void actionGetCategoryList(){
        List<Category> categories = appDatabase.categoryDAO().getAllCategory();
        mvpView.getCategoryList(categories);
    }
}
