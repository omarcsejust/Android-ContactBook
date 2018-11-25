package com.example.omar.contactbook.ui.SplashScreen;

import android.view.animation.Animation;

public interface SplashScreenMvpView {
    public void ShowMessage(String msg);

    public void loadAnimation(Animation animSliderInTop, Animation animSliderInBottom);
}
