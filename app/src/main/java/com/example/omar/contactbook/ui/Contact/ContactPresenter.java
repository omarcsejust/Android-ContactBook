package com.example.omar.contactbook.ui.Contact;

import android.content.Context;

import com.example.omar.contactbook.data.Database.AppDatabase;
import com.example.omar.contactbook.data.Models.Contact;

import java.util.List;

public class ContactPresenter {
    ContactMvpView mvpView;
    AppDatabase appDatabase;

    public ContactPresenter(Context context, ContactMvpView mvpView){
        this.mvpView = mvpView;
        appDatabase = AppDatabase.getAppDatabase(context);
    }

    public void actionGetAllContacts(){
        List<Contact> contacts = appDatabase.contactDAO().getAllContacts();
        mvpView.getAllContacts(contacts);
    }

    public void actionGetContactsByCategoryId(int cat_id){
        List<Contact> contacts = appDatabase.contactDAO().getContactsByCategoryId(cat_id);
        mvpView.getContactsByCategoryId(contacts);
    }
}
