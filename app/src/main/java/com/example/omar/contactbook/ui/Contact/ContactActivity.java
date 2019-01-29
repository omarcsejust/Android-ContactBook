package com.example.omar.contactbook.ui.Contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Contact;

import java.util.List;

public class ContactActivity extends AppCompatActivity implements ContactMvpView{

    RecyclerView recyclerViewContacts;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        recyclerViewContacts = findViewById(R.id.recycler_view_contact);

        ContactPresenter presenter = new ContactPresenter(ContactActivity.this,this);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null)
        {
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
