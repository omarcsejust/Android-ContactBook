package com.example.omar.contactbook.ui.AddContact;

import android.content.Context;

import com.example.omar.contactbook.data.Database.AppDatabase;
import com.example.omar.contactbook.data.Models.Category;

import java.util.List;

public class AddContactPresenter {
    private AddContactMvpView mvpView;
    private AppDatabase appDatabase;

    public AddContactPresenter(AddContactMvpView mvpView,Context context){
        this.mvpView = mvpView;
        appDatabase = AppDatabase.getAppDatabase(context);
    }

    public void actionGetAllCategories(){
        List<Category> categories = appDatabase.categoryDAO().getAllCategory();
        mvpView.getAllGroups(categories);
    }
}
