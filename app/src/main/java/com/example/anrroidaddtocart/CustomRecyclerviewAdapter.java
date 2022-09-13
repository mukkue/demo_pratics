package com.example.anrroidaddtocart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerviewAdapter extends RecyclerView.Adapter<CustomRecyclerviewAdapter.MyViewHolder> {

    Context context;
    ArrayList<ModelClass>arrayList;
    String qty[]={"1","2","3"};


   public CustomRecyclerviewAdapter( Context context, ArrayList<ModelClass>arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_recyclerview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(""+arrayList.get(position).getId());
        holder.textView2.setText(arrayList.get(position).getName());
        holder.textView3.setText(""+arrayList.get(position).getPrice());
        holder.spinner.setAdapter(new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,qty));
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(context, ""+qty[i], Toast.LENGTH_SHORT).show();

                SqlitedatabaseDemo sqlitedatabaseDemo=new SqlitedatabaseDemo(context);
                String qq=qty[i];
                int q=Integer.parseInt(qq);
                int price=arrayList.get(holder.getAdapterPosition()).getPrice();
                int totalp=q*price;
               // Toast.makeText(context, ""+totalp, Toast.LENGTH_SHORT).show();
                holder.textView3.setText(""+totalp);

                sqlitedatabaseDemo.updatepriceandQuanity(""+totalp,arrayList.get(position).getId());

               // sqlitedatabaseDemo.deletTablerow(arrayList.get(holder.getAdapterPosition()).getId());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView,textView2,textView3;
        Spinner spinner;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.textView2 = (TextView) itemView.findViewById(R.id.textView2);
            this.textView3= (TextView) itemView.findViewById(R.id.textView3);
            this.spinner=itemView.findViewById(R.id.spinner);


        }
    }
}
