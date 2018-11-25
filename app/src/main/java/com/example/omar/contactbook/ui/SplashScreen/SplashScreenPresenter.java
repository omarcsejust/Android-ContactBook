package com.example.omar.contactbook.ui.SplashScreen;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.omar.contactbook.R;

public class SplashScreenPresenter {

    SplashScreenMvpView mvpView;

    public SplashScreenPresenter(SplashScreenMvpView splashScreenMvpView){
        this.mvpView = splashScreenMvpView;
    }

    public void getMessage(){
        mvpView.ShowMessage("Hello CallBack");
    }

    public void actionLoadAnimation(Context context){
        Animation animSliderInTop,animSliderInBottom;

        animSliderInTop = AnimationUtils.loadAnimation(context,R.anim.slide_in_top);
        animSliderInBottom = AnimationUtils.loadAnimation(context,R.anim.slide_in_bottom);
        mvpView.loadAnimation(animSliderInTop,animSliderInBottom);
    }

}
