package com.example.anrroidaddtocart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SqlitedatabaseDemo sqlitedatabaseDemo;
EditText ed1,ed2,ed3;
Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlitedatabaseDemo=new SqlitedatabaseDemo(MainActivity.this);
        ed1=findViewById(R.id.editTextNumber2);
        ed2=findViewById(R.id.editTextTextPersonName2);
        ed3=findViewById(R.id.editTextNumber3);
        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DisplayActity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id=ed1.getText().toString();
                int ii=Integer.parseInt(id);
                String pname=ed2.getText().toString();
                String price=ed3.getText().toString();
                int pp=Integer.parseInt(price);
                sqlitedatabaseDemo.InsertData(ii,pname,pp);
                Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();

            }
        });
    }
}