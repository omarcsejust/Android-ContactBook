package com.example.omar.contactbook.ui.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.ui.MainMenu.MainMenuActivity;
import com.example.omar.contactbook.ui.OnBoarding.OnBoardingActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity implements SplashScreenMvpView{

    SplashScreenPresenter presenter;
    ImageView imageViewPhoneIcon;
    TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        //Remove notification bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageViewPhoneIcon = findViewById(R.id.img_phone);
        textViewWelcome = findViewById(R.id.welcome_text);

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
        textViewWelcome.startAnimation(animSliderInBottom);

        //final Intent onBoardingActivity = new Intent(this,OnBoardingActivity.class);
        final Intent onBoardingActivity = new Intent(this,MainMenuActivity.class);

        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(onBoardingActivity);
                finish();
                //Log.d("MainActivity:", "onCreate: waiting 5 seconds for MainActivity... loading PrimaryActivity.class");
            }
        }, 5000 );

    }
}
