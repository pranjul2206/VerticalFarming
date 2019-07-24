package com.example.verticalfarming;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GenericEducationContentAdapter extends PagerAdapter {
    private List<GenericEducationContentModel> models;
    private Context context;

    public GenericEducationContentAdapter(List<GenericEducationContentModel> models, Context context) {
        this.models = models;
        this.context = context;
        Log.i("pconstructor",models.toString());
    }

    public int getCount() {
        return models.size();
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        Log.i("instantiateItem","instantiateItem");
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_generic_education_content_item, container, false);
        Log.i("pview",view.toString());

        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.typeimage);
        title = view.findViewById(R.id.typetitle);
        desc = view.findViewById(R.id.typedesc);


        //imageView.setImageResource(models.get(position).getImage());
        Picasso.get().load(models.get(position).getImage()).into(imageView);
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());
        Log.i("ptitle",models.get(position).getTitle().toString());
        Log.i("ptext",models.get(position).getTitle().toString());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, BasicHome.class);
//                intent.putExtra("param", models.get(position).getTitle());
//                context.startActivity(intent);
                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
