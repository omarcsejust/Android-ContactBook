package com.example.omar.contactbook.ui.MainMenu;

import com.example.omar.contactbook.data.Models.Category;

import java.util.ArrayList;
import java.util.List;

public interface MainMenuMvpView {
    void addCategory(long rowId, String catName);

    void getAllCategory(List<Category> categories);
}
