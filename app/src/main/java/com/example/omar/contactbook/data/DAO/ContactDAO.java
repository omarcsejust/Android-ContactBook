package com.example.omar.contactbook.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.omar.contactbook.data.Models.Contact;

@Dao
public interface ContactDAO {

    @Insert
    void addContact(Contact contact);
}
