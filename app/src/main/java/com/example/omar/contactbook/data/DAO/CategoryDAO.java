package com.example.omar.contactbook.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.omar.contactbook.data.Models.Category;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert
    void addCategory(Category category);

    @Query("SELECT * FROM category")
    public List<Category> getAllCategory();

}
