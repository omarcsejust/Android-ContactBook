package com.example.omar.contactbook.data.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "call-history")
public class CallHistory {
    @PrimaryKey(autoGenerate = true)
    private int id;


}
