package com.example.omar.contactbook.ui.Category;

import com.example.omar.contactbook.data.Models.Category;

import java.util.List;

public interface CategoryMvpView {
    void getCategoryList(List<Category> categories);
}
