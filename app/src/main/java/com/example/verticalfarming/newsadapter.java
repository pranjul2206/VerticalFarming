package com.example.verticalfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class newsadapter extends RecyclerView.Adapter<newsadapter.newsViewHolder> {

        //creating context for layout reference and list for layout array
        Context context;
        List<newscontents> newscontentsList;

        //constructor
    public newsadapter(Context context, List<newscontents> newscontentsList) {
        this.context = context;
        this.newscontentsList = newscontentsList;
    }
    // all three methods of recycle view
    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.news_layout_recycle,parent,false);
        newsViewHolder newsviewholder=new newsViewHolder(view);
        return newsviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder holder, int position) {
        newscontents nc=newscontentsList.get(position);
        holder.heading.setText(nc.getTitle());
        holder.desc.setText(nc.getDesc());
        //using picasso for getting image thhrough url
        Picasso.get().load(nc.getImage()).into(holder.image);
        //holder.image.setImageDrawable(context.getResources().getDrawable(nc.getImage()));
    }

    @Override
    public int getItemCount() {
        return newscontentsList.size();
    }

    class newsViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView heading;
        TextView desc;
        //so that we can get the reference only once
        public newsViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.newsimage);
            heading=(TextView) itemView.findViewById(R.id.newsheading);
            desc=(TextView)itemView.findViewById(R.id.newscontent);
        }
    }
}
