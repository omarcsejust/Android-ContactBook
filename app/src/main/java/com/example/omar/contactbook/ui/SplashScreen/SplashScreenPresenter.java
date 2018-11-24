package com.example.omar.contactbook.ui.SplashScreen;

public class SplashScreenPresenter {

    SplashScreenMvpView mvpView;

    public SplashScreenPresenter(SplashScreenMvpView splashScreenMvpView){
        this.mvpView = splashScreenMvpView;
    }

    public void getMessage(){
        mvpView.ShowMessage("Hello CallBack");
    }

}
