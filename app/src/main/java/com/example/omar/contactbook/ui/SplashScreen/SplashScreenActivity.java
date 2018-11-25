package com.example.omar.contactbook.ui.SplashScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.omar.contactbook.R;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenMvpView{

    SplashScreenPresenter presenter;
    ImageView imageViewPhoneIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageViewPhoneIcon = findViewById(R.id.img_phone);

        presenter = new SplashScreenPresenter(this);

        presenter.actionLoadAnimation(this);


    }

    @Override
    public void ShowMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadAnimation(Animation animSliderInTop, Animation animSliderInBottom) {
        imageViewPhoneIcon.startAnimation(animSliderInTop);
    }
}
