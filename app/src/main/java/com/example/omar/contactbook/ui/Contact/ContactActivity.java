package com.example.omar.contactbook.ui.Contact;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Contact;
import com.example.omar.contactbook.ui.AddContact.AddContactActivity;

import java.util.List;

public class ContactActivity extends AppCompatActivity implements ContactMvpView{

    RecyclerView recyclerViewContacts;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton floatingActionButtonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        recyclerViewContacts = findViewById(R.id.recycler_view_contact);
        floatingActionButtonAddContact = findViewById(R.id.fab_add_contact);

        floatingActionButtonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactActivity.this,AddContactActivity.class);
                startActivity(intent);
            }
        });

        ContactPresenter presenter = new ContactPresenter(ContactActivity.this,this);

        //getting selected group id from group recycler view
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null)
        {
            //fetching all the contact of corresponding group id
            int groupId = (int) b.get("GROUP_ID");
            presenter.actionGetContactsByCategoryId(groupId);
        }

    }

    @Override
    public void getAllContacts(List<Contact> contacts) {
        //
    }

    @Override
    public void getContactsByCategoryId(List<Contact> contacts) {
        adapter=new ContactAdapter(ContactActivity.this,contacts);  // "this" is a context of current activity....
        layoutManager=new LinearLayoutManager(ContactActivity.this);
        recyclerViewContacts.setLayoutManager(layoutManager);
        recyclerViewContacts.setHasFixedSize(true);
        recyclerViewContacts.setAdapter(adapter);
    }
}
