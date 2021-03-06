package com.example.omar.contactbook.ui.AddContact;

import com.example.omar.contactbook.data.Models.Category;

import java.util.List;

public interface AddContactMvpView {
    void getAllGroups(List<Category> categories);
    void validateContactInfo(String message, boolean isValid);
    void addContact(long id);
}
