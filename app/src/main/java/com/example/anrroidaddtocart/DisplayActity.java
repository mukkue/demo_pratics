package com.example.anrroidaddtocart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplayActity extends AppCompatActivity {

    SqlitedatabaseDemo sqlitedatabaseDemo;
    ArrayList<ModelClass>arrayList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_actity);
        recyclerView=findViewById(R.id.recyclerviewdemo);
        arrayList=new ArrayList<>();
        sqlitedatabaseDemo=new SqlitedatabaseDemo(getApplicationContext());

        Cursor cc= sqlitedatabaseDemo.DisplayCartitems();
        cc.moveToFirst();
        do{

          ModelClass mm=new ModelClass();

          String id=cc.getString(0);
          String name=cc.getString(1);
          String price=cc.getString(2);
          mm.setId(Integer.parseInt(id));
          mm.setName(name);
          mm.setPrice(Integer.parseInt(price));
           arrayList.add(mm);
            CustomRecyclerviewAdapter cc1=new CustomRecyclerviewAdapter(getApplicationContext(),arrayList);


            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(cc1);


      }while (cc.moveToNext());


    }
}