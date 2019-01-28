package com.example.omar.contactbook.ui.AddContact;

import android.content.Context;

import com.example.omar.contactbook.data.Database.AppDatabase;
import com.example.omar.contactbook.data.Models.Category;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddContactPresenter {
    private AddContactMvpView mvpView;
    private AppDatabase appDatabase;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?");


    public AddContactPresenter(AddContactMvpView mvpView,Context context){
        this.mvpView = mvpView;
        appDatabase = AppDatabase.getAppDatabase(context);
    }

    public void actionGetAllCategories(){
        List<Category> categories = appDatabase.categoryDAO().getAllCategory();
        mvpView.getAllGroups(categories);
    }

    public void actionValidateContactInfo(String name, String phoneNumber, String email, int genderCode){
        if (genderCode == 0){
            mvpView.validateContactInfo("Please select a avatar!", false);
        }else if (name.isEmpty() || name.length()>40 || name.matches("[0-9]+") && !name.matches("[a-zA-Z]+")){
            mvpView.validateContactInfo("Name is not valid or you too long name!",false);
        }else if(!email.isEmpty() && (email.length()>60 || !AddContactPresenter.validateEmail(email))){
            mvpView.validateContactInfo("Please input a valid email!",false);
        }else if(phoneNumber.isEmpty() || phoneNumber.length()>30 || !AddContactPresenter.validatePhoneNumber(phoneNumber)){
            mvpView.validateContactInfo("Your given phone number is not valid!",false);
        }else {
            mvpView.validateContactInfo("All done.",true);
        }
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Matcher matcher = VALID_PHONE_NUMBER_REGEX .matcher(phoneNumber);
        return matcher.find();
    }
}
