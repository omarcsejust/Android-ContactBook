package com.example.omar.contactbook.ui.OnBoarding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.ui.AddContact.AddContactActivity;
import com.example.omar.contactbook.ui.MainMenu.MainMenuActivity;

public class OnBoardingActivity extends AppCompatActivity {
    Button btnMainMenu, buttonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        btnMainMenu = findViewById(R.id.button_main_menu);
        buttonAddContact = findViewById(R.id.button_add_contact);

        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoardingActivity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });

        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoardingActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
