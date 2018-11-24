package com.example.omar.contactbook.ui.SplashScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.omar.contactbook.R;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenMvpView{
    Button buttonCategory;

    SplashScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        buttonCategory = findViewById(R.id.buttonCategory);

        presenter = new SplashScreenPresenter(this);

        buttonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getMessage();
            }
        });
    }

    @Override
    public void ShowMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
