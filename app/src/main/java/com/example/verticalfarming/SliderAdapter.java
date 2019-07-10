package com.example.verticalfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    //constructor for saving the context of the activity passed

    public SliderAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    //stores the integer for all gifs

    public int[] slide_images={
            R.drawable.indoorfarming,
            R.drawable.healthyfood,
            R.drawable.trackactivity,
            R.drawable.chat
    };

    //stores all the headings

    public String[] slide_headings={
            "INDOOR FARMING",
            "HEALTHY FOOD",
            "TRACK ACTIVITIES",
            "CHAT CONNECTIVITY"
    };

    //stores all the discritions

    public String[] slide_descs={
            "Indoor farming is a method of growing crops or plants, either on large or small scale, entirely indoors .This app allows wide variety of plants ,  fruits, vegetables, and herbs to grow inside",
            "Our app solves a major food problem by helping users to farming natural and healthy food indoors",
            "Track your plant activities through notifications, set reminders so that your plant doesn't remain thirsty",
            "Get Realtime information, update and support through inbuilt chatting functionality"
    };


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //applying gif,heading,desc to the layout

        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView=(ImageView)view.findViewById(R.id.slide_image);
        TextView slideHeading=(TextView)view.findViewById(R.id.slide_heading);
        TextView slideDescription=(TextView)view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
