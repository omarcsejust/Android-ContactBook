package com.example.omar.contactbook.ui.MainMenu;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Database.AppDatabase;
import com.example.omar.contactbook.data.Models.Category;
import com.example.omar.contactbook.ui.Category.CategoryActivity;
import com.example.omar.contactbook.ui.CategorySetting.CategorySettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainMenuActivity extends AppCompatActivity implements MainMenuMvpView{

    CardView cardViewCreateGroup, cardViewSettingGroup, cardViewGroups;
    EditText editTextGetGroupName;
    Button buttonAddGroupName, buttonExitAddGroupDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        cardViewCreateGroup = findViewById(R.id.cv_create_group);
        cardViewSettingGroup = findViewById(R.id.cv_setting_groups);
        cardViewGroups = findViewById(R.id.cv_view_groups);

        final MainMenuPresenter presenter = new MainMenuPresenter(this,MainMenuActivity.this);

        /**
         * Add New Group Menu
         * implementing custom alert dialog for creating new group
         */
        cardViewCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainMenuActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.raw_group_create_dialog,null);
                editTextGetGroupName = mView.findViewById(R.id.edit_text_group_name);
                buttonAddGroupName = mView.findViewById(R.id.button_add_group_name);
                buttonExitAddGroupDialog = mView.findViewById(R.id.button_exit_add_group_dialog);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                //Prevent Android activity Dialog from closing on outside touch
                dialog.setCanceledOnTouchOutside(false);

                buttonAddGroupName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String groupName = editTextGetGroupName.getText().toString();
                        if (!groupName.isEmpty()){
                            Category category = new Category();
                            category.setCatName(groupName);
                            presenter.actionAddCategory(category);
                        }else {
                            //presenter.actionGetAllCategory();
                            Toast.makeText(MainMenuActivity.this,"Please Input a Group Name!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                buttonExitAddGroupDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });

        /**
         * All Group List
         * invoking all group list activity
         */
        cardViewGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        /**
         * Setting Group Menu
         * invoking category setting activity
         */
        cardViewSettingGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,CategorySettingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void addCategory(long rowId, String catName) {
        if (rowId>0){
            Toast.makeText(MainMenuActivity.this,"Enjoy! Group Created Successfully.",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainMenuActivity.this,"Sorry! It seems "+catName+" already exist!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getAllCategory(List<Category> categories) {
        for (int i=0;i<categories.size();i++){
            Category category = categories.get(i);
            Toast.makeText(MainMenuActivity.this,category.getCatName(),Toast.LENGTH_SHORT).show();
            Toast.makeText(MainMenuActivity.this,Integer.toString(category.getId()),Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(MainMenuActivity.this,"Size"+categories.size(),Toast.LENGTH_SHORT).show();
    }
}
