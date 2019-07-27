package com.example.verticalfarming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CropHandholding extends AppCompatActivity {

    CardView citygreensUniversity,strawberry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_handholding);
        citygreensUniversity=findViewById(R.id.citygreensuniversity);
        strawberry=findViewById(R.id.strawberry);
        citygreensUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CityGreensUniversity.class);
                view.getContext().startActivity(intent);
            }
        });

        strawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CropHandholdingContent.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}
