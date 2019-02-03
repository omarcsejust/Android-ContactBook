package com.example.omar.contactbook.ui.ContactDetails;

import android.content.Context;

import com.example.omar.contactbook.data.Database.AppDatabase;

public class ContactDetailsPresenter {

    private ContactDetailsMvpView mvpView;
    private AppDatabase appDatabase;

    public ContactDetailsPresenter(Context context, ContactDetailsMvpView mvpView){
        this.mvpView = mvpView;
        appDatabase = AppDatabase.getAppDatabase(context);
    }

    public void actionGetCategoryName(int catId){
        String categoryName = appDatabase.categoryDAO().getCategoryNameById(catId);
        mvpView.getCategoryNameById(categoryName);
    }

}
