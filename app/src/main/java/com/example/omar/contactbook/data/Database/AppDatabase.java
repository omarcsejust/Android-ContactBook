package com.example.omar.contactbook.data.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.omar.contactbook.data.DAO.CategoryDAO;
import com.example.omar.contactbook.data.DAO.ContactDAO;
import com.example.omar.contactbook.data.Models.Category;
import com.example.omar.contactbook.data.Models.Contact;

@Database(entities = {Category.class, Contact.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract CategoryDAO categoryDAO();
    public abstract ContactDAO contactDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "contact-book")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
