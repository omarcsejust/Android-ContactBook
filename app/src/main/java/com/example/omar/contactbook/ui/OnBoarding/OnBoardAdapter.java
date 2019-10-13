package com.example.omar.contactbook.ui.OnBoarding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.omar.contactbook.R;

public class OnBoardAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public OnBoardAdapter(Context mContext){
        this.context = mContext;
    }

    public int[] slideIcons = {R.drawable.icon_group, R.drawable.icon_group, R.drawable.icon_group};

    public String[] slideTitle = {"This is title 1", "This is title 2", "This is title 3"};

    public String[] slideDescription = {"This is Description 1", "This is Description 2", "This is Description 3"};

    @Override
    public int getCount() {
        return slideIcons.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.on_boarding_slide_layout,container,false);

        ImageView imageViewSlideIcon = view.findViewById(R.id.iv_slider_logo);
        TextView textViewSliderTitle = view.findViewById(R.id.tv_slider_title);
        TextView textViewSliderDescription = view.findViewById(R.id.tv_slider_description);

        imageViewSlideIcon.setImageResource(slideIcons[position]);
        textViewSliderTitle.setText(slideTitle[position]);
        textViewSliderDescription.setText(slideDescription[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
