package com.example.verticalfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class newsArea extends AppCompatActivity {

    RecyclerView recyclerView;
    newsadapter adapter;
    List<newscontents> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_area);
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
                        for (DataSnapshot productSnapshot:dataSnapshot.getChildren()){
                            newscontents p=productSnapshot.getValue(newscontents.class);
                            list.add(p);
                        }
                        adapter=new newsadapter(newsArea.this,list);
                        recyclerView.setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("PRANJUL", e.toString());
        }

        adapter=new newsadapter(this,list);
        recyclerView.setAdapter(adapter);
    }
}
