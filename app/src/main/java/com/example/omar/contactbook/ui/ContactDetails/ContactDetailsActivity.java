package com.example.omar.contactbook.ui.ContactDetails;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Contact;

public class ContactDetailsActivity extends Activity implements ContactDetailsMvpView {

    ImageView imageViewCall, imageViewEditContact, imageViewAddFavoriteContact, imageViewDeleteContact;
    TextView textViewGroupName, textViewContactNumber;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contact_details);

        imageViewCall = findViewById(R.id.iv_call);
        imageViewEditContact = findViewById(R.id.iv_edit_contact);
        imageViewAddFavoriteContact = findViewById(R.id.iv_add_favorite_contact);
        imageViewDeleteContact = findViewById(R.id.iv_delete_contact);

        textViewContactNumber = findViewById(R.id.text_view_phone_number);
        textViewGroupName = findViewById(R.id.text_view_contact_group_name);

        collapsingToolbarLayout = findViewById(R.id.collapsing_tool_bar_layout);

        ContactDetailsPresenter presenter  = new ContactDetailsPresenter(ContactDetailsActivity.this,this);

        Intent intent = getIntent();
        Contact contact = (Contact) intent.getSerializableExtra("CONTACT");

        // set contact name
        collapsingToolbarLayout.setTitle(contact.getContactName());

        //set contact number
        textViewContactNumber.setText(contact.getContactNumber());

        //set group name
        presenter.actionGetCategoryName(contact.getCategoryId());
    }

    @Override
    public void getCategoryNameById(String categoryName) {
        textViewGroupName.setText(categoryName);
    }
}
