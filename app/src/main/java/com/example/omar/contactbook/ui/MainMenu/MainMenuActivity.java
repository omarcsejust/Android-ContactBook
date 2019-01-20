package com.example.omar.contactbook.ui.MainMenu;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.omar.contactbook.R;

public class MainMenuActivity extends AppCompatActivity {

    CardView cardViewCreateGroup;
    EditText editTextGetGroupName;
    Button buttonAddGroupName, buttonExitAddGroupDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        cardViewCreateGroup = findViewById(R.id.cv_create_group);

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

                buttonAddGroupName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String groupName = editTextGetGroupName.getText().toString();
                        if (!groupName.isEmpty()){
                            Toast.makeText(MainMenuActivity.this,groupName,Toast.LENGTH_SHORT).show();
                        }else {
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
    }
}
