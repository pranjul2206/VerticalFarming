package com.example.verticalfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GenericEducationContent extends AppCompatActivity {


    ViewPager viewPager;
    GenericEducationContentAdapter adapter;
    List<GenericEducationContentModel> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    String simage[]=new String[10];
    String stitle[]=new String[10];
    String sdesd[]=new String[10];
    private int i=0,flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_education_content);

        Log.i("PRANJUL1", "balleballe1");
        setContentView(R.layout.activity_generic_education);
        Log.i("PRANJUL2", "balleballe2");
        models = new ArrayList<>();


        try {
            FirebaseDatabase dbproducts = FirebaseDatabase.getInstance();
            DatabaseReference myRef = dbproducts.getReference("GeneralEducation/hydropoinics/types");
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {

                        for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                            simage[i] = productSnapshot.child("image").getValue().toString();;
                            sdesd[i] = productSnapshot.child("desc").getValue().toString();
                            stitle[i] = productSnapshot.child("name").getValue().toString();
                            models.add(new GenericEducationContentModel(simage[i], stitle[i], sdesd[i]));
                            i++;
                        }

                        adapter = new GenericEducationContentAdapter(models, GenericEducationContent.this);
                        viewPager = findViewById(R.id.viewPager);
                        viewPager.setAdapter(adapter);
                        viewPager.setPadding(130, 0, 130, 0);
                        Log.i("OUTSIDELOOP", Integer.toString(i));

                        Integer[] colors_temp = {
                                getResources().getColor(R.color.color1),
                                getResources().getColor(R.color.color2),
                                getResources().getColor(R.color.color3),
                                getResources().getColor(R.color.color4),
                                getResources().getColor(R.color.color1),
                                getResources().getColor(R.color.color2)
                        };

                        colors = colors_temp;

                        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                                    viewPager.setBackgroundColor(

                                            (Integer) argbEvaluator.evaluate(
                                                    positionOffset,
                                                    colors[position],
                                                    colors[position + 1]
                                            )
                                    );
                                } else {
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

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }
    }

