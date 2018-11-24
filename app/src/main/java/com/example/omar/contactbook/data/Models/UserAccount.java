package com.example.omar.contactbook.data.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user-account")
public class UserAccount {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "password")
    private String password;
}
