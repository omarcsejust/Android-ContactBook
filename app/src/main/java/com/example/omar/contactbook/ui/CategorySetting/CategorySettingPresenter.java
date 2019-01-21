package com.example.omar.contactbook.ui.CategorySetting;

import android.content.Context;

import com.example.omar.contactbook.data.Database.AppDatabase;
import com.example.omar.contactbook.data.Models.Category;

import java.util.List;

public class CategorySettingPresenter {

    private CategorySettingMvpView mvpView;
    private AppDatabase appDatabase;

    public CategorySettingPresenter(CategorySettingMvpView mvpView, Context context){
        this.mvpView = mvpView;
        appDatabase = AppDatabase.getAppDatabase(context);
    }

    public void actionGetAllCategory(){
        List<Category> categories = appDatabase.categoryDAO().getAllCategory();
        mvpView.getAllCategory(categories);
    }

}
