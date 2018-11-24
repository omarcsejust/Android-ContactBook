package com.example.omar.contactbook.data.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "contact")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "contact_name")
    private String contactName;

    @ColumnInfo(name = "contact_number")
    private String contactNumber;

    @ColumnInfo(name = "email_id")
    private String emailId;

    public void setId(int id) {
        this.id = id;
    }

    public Contact(int id, String contactName, String contactNumber, String emailId) {
        this.id = id;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
    }

    public Contact(String contactName, String contactNumber, String emailId) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }
}
