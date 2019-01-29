package com.example.omar.contactbook.ui.Contact;

import com.example.omar.contactbook.data.Models.Contact;

import java.util.List;

public interface ContactMvpView {
    void getAllContacts(List<Contact> contacts);
    void getContactsByCategoryId(List<Contact> contacts);
}
