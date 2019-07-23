package com.example.verticalfarming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class GenericEducation extends AppCompatActivity {

    ViewPager viewPager;
    GenericEducationAdapter adapter;
    List<GenericEducationModel> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.i("PRANJUL1", "balleballe1");
        setContentView(R.layout.activity_generic_education);
        //Log.i("PRANJUL2", "balleballe2");
        models = new ArrayList<>();
        models.add(new GenericEducationModel(R.drawable.zbrochure, "Hydroponics", "Hydroponics is a subset of hydroculture, which is a method of growing plants without soil by instead using mineral nutrient solutions in a water solvent."));
        models.add(new GenericEducationModel(R.drawable.zsticker, "Aeroponics", "Aeroponics is the process of growing plants in an air or mist environment without the use of soil or an aggregate medium (known as geoponics)."));
        models.add(new GenericEducationModel(R.drawable.zposter, "Aquaponics", "Aquaponics refers to any system that combines conventional aquaculture with hydroponics in a symbiotic environment. "));
        models.add(new GenericEducationModel(R.drawable.znamecard, "Cocoppeat", "Coir, or coconut fibre, is a natural fibre extracted from the husk of coconut and used in products such as floor mats, doormats, brushes and mattresses."));
        //Log.i("PRANJUL3", "balleballe3");
        adapter = new GenericEducationAdapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    }

