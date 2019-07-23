package com.example.verticalfarming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //all variables pointing to different views here
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private ImageView imageView;
    private RelativeLayout splashscreen;
    private Button back;
    private Button next;
    private int mcurrentpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, GenericEducation.class);
        this.startActivity(intent);

        //this section for linking variable to actual views

        mSlideViewPager=(ViewPager)findViewById(R.id.slideViewPager);
        mDotLayout=(LinearLayout)findViewById(R.id.dotsLayout);
        sliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        imageView=(ImageView)findViewById(R.id.imgview);
        splashscreen=(RelativeLayout)findViewById(R.id.SplashSlide);
        back=(Button)findViewById(R.id.nextbtn);
        next=(Button)findViewById(R.id.backbtn);
        addDotsIndicator(0);

        //call to pagechange listner

        mSlideViewPager.addOnPageChangeListener(viewListner);

        //two onclick for next and back button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mcurrentpage<3) {
                    mSlideViewPager.setCurrentItem(mcurrentpage+1);
                }
                else {
                    Intent intent = new Intent(view.getContext(), BasicHome.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mcurrentpage-1);
            }
        });


    }

    //this function is for changing the background colour w.r.t gif and changing page value

    public void addDotsIndicator(int i){
        switch (i){
            case 0: imageView.setImageResource(R.drawable.one);
                    splashscreen.setBackgroundColor(getResources().getColor(R.color.gif1));
                    break;
            case 1: imageView.setImageResource(R.drawable.two);
                    splashscreen.setBackgroundColor(getResources().getColor(R.color.gif2));
                    break;
            case 2: imageView.setImageResource(R.drawable.three);
                    splashscreen.setBackgroundColor(getResources().getColor(R.color.gif3));
                    break;
            case 3: imageView.setImageResource(R.drawable.four);
                    splashscreen.setBackgroundColor(getResources().getColor(R.color.gif4));
                    break;
        }
    }

    //listening the viewpager for any change in page

    ViewPager.OnPageChangeListener viewListner=new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mcurrentpage=position;

            //making buttons visible and invisible depending upon the position of the page
            if(position==0){
                next.setEnabled(true);
                back.setEnabled(false);
                back.setVisibility(View.INVISIBLE);
                next.setText("NEXT");
            }
            else if(position==3){
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                next.setText("FINISH");
                back.setText("BACK");
            }
            else{
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                next.setText("NEXT");
                back.setText("BACK");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
