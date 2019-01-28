package com.example.omar.contactbook.ui.MainMenu;

import android.content.Context;

import com.example.omar.contactbook.data.Database.AppDatabase;
import com.example.omar.contactbook.data.Models.Category;
import java.util.List;

public class MainMenuPresenter {
    private MainMenuMvpView mvpView;
    private AppDatabase appDatabase;

    public MainMenuPresenter(MainMenuMvpView mainMenuMvpView,Context context){
        this.mvpView = mainMenuMvpView;
        appDatabase = AppDatabase.getAppDatabase(context);
    }


    public void actionAddCategory(Category category){
        long rowId = appDatabase.categoryDAO().addCategory(category);
        mvpView.addCategory(rowId, category.getCatName());
    }

    public void actionGetAllCategory(){
        List<Category> categories = appDatabase.categoryDAO().getAllCategory();
        mvpView.getAllCategory(categories);
    }

}
