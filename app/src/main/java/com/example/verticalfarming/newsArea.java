package com.example.verticalfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class newsArea extends AppCompatActivity {

    RecyclerView recyclerView;
    newsadapter adapter;
    List<newscontents> list;
    private ShimmerFrameLayout shimmerFrameLayout;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_area);
        //initialization of all the views
        shimmerFrameLayout=findViewById(R.id.shimmer_news);
        nestedScrollView=findViewById(R.id.newsNestedScroll);
        appBarLayout=findViewById(R.id.newsAppBar);
        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        try{
            //DatabaseReference dbproducts= FirebaseDatabase.getInstance().getReference("https://verticalfarming.firebaseio.com/products");
            FirebaseDatabase dbproducts = FirebaseDatabase.getInstance();
            //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            //Log.d("myTagGGGGGGGGGGGGGGGGGGGGGGGG", dbproducts.getReference().toString());
            DatabaseReference myRef = dbproducts.getReference("products");
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        //looping all over the valuews in product and passing it to list
                        for (DataSnapshot productSnapshot:dataSnapshot.getChildren()){
                            newscontents p=productSnapshot.getValue(newscontents.class);
                            list.add(p);
                            flag++;
                            Log.i("flagin",Integer.toString(flag));
                        }

                        //adding shimmet before calling adapter
                        Log.i("flagout",Integer.toString(flag));
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        appBarLayout.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);

                        adapter=new newsadapter(newsArea.this,list);
                        recyclerView.setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        // for any exception occuring
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("PRANJUL", e.toString());
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmer();
    }
}
