package com.example.omar.contactbook.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.omar.contactbook.data.Models.Contact;

import java.util.List;

@Dao
public interface ContactDAO {

    @Insert
    void addContact(Contact contact);

    @Query("select * from contact")
    List<Contact> getAllContacts();
}
