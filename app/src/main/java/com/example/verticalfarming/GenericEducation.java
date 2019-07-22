package com.example.verticalfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GenericEducation extends AppCompatActivity {
    float rainfall[]={98.8f,123.8f,161.6f,24.2f,52f,58.2f,78.4f,203.4f,240.2f,159.7f,13.9f,35.1f};
    String monthName[]={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_education);
        setupPieChart();
    }
    private void setupPieChart(){
        List<PieEntry> pieEntries=new ArrayList<>();
        for(int i=0;i<rainfall.length;i++)
        {
            pieEntries.add(new PieEntry(rainfall[i],monthName[i]));
        }
        PieDataSet dataset=new PieDataSet(pieEntries,"RainFall in Bangalore");
        dataset.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data=new PieData(dataset);
        PieChart chart=(PieChart)findViewById(R.id.bangalorepiecharts);
        chart.setData(data);
        chart.invalidate();
    }
}
