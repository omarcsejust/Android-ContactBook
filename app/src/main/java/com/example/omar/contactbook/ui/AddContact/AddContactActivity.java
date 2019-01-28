package com.example.omar.contactbook.ui.AddContact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Category;
import com.example.omar.contactbook.data.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddContactActivity extends AppCompatActivity implements AddContactMvpView{

    RadioGroup radioGroupGenderSelect;
    Button buttonAddContact;
    Spinner spinnerGroups;
    EditText editTextName, editTextEmai, editTextPhoneNumber;

    private String name;
    private String email;
    private int genderCode; // 5=male 3=female
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        radioGroupGenderSelect = findViewById(R.id.radio_group_gender);
        buttonAddContact = findViewById(R.id.button_add_contact);
        spinnerGroups = findViewById(R.id.spinner_groups);
        editTextName = findViewById(R.id.edit_text_name);
        editTextEmai = findViewById(R.id.edit_text_email);
        editTextPhoneNumber = findViewById(R.id.edit_text_number);

        final AddContactPresenter presenter = new AddContactPresenter(this,AddContactActivity.this);
        presenter.actionGetAllCategories();

        // button click event for adding new contact
        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextName.getText().toString();
                email = editTextEmai.getText().toString();
                phoneNumber = editTextPhoneNumber.getText().toString();
                genderCode = getGenderCode();
                presenter.actionValidateContactInfo(name,phoneNumber,email,genderCode);
                Toast.makeText(AddContactActivity.this,Integer.toString(genderCode),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getGenderCode(){
        int mGenderCode;
        if (radioGroupGenderSelect.getCheckedRadioButtonId() == R.id.radio_button_male){
            mGenderCode = 5;
        }else if (radioGroupGenderSelect.getCheckedRadioButtonId() == R.id.radio_button_female){
            mGenderCode = 3;
        }else {
            mGenderCode = 0;
        }

        return mGenderCode;
    }

    @Override
    public void getAllGroups(List<Category> categories) {
        ArrayList<String> category = new ArrayList<>();
        for (int i=0; i<categories.size(); i++){
            String cat_name = categories.get(i).getCatName();
            category.add(cat_name);
        }
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(AddContactActivity.this,android.R.layout.simple_spinner_item,category);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerGroups.setAdapter(dataAdapter);
    }

    @Override
    public void validateContactInfo(String message, boolean isValid) {
        if (!isValid){
            Toast.makeText(AddContactActivity.this,message,Toast.LENGTH_SHORT).show();
        }else {
            Contact contact = new Contact();
            contact.setContactName(name);
            contact.setContactNumber(phoneNumber);
            contact.setEmailId(email);
            contact.setGenderId(genderCode);

        }
    }
}
