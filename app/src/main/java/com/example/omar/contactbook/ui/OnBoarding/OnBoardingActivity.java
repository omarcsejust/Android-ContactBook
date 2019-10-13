package com.example.omar.contactbook.ui.OnBoarding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.Button;

import com.example.omar.contactbook.R;

public class OnBoardingActivity extends Activity {

    private OnBoardAdapter onBoardAdapter;
    private ViewPager viewPagerOnBoarding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_on_boarding);

        viewPagerOnBoarding = findViewById(R.id.view_pager_on_boarding);
        onBoardAdapter = new OnBoardAdapter(this);

        viewPagerOnBoarding.setAdapter(onBoardAdapter);


    }

}
