package com.example.deeksha.mycheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2 extends AppCompatActivity {
    ImageView img1,img2,img3,img4;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img1=(ImageView)findViewById(R.id.franceimg);
        img2=(ImageView)findViewById(R.id.spainimg);
        img3=(ImageView)findViewById(R.id.italyimg);
        img4=(ImageView)findViewById(R.id.germanimg);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    i=new Intent(Main2.this,FrenchOptions.class);
                    i.putExtra("index",0);
                    startActivity(i);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(Main2.this,FrenchOptions.class);
                i.putExtra("index",1);
                startActivity(i);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(Main2.this,FrenchOptions.class);
                i.putExtra("index",2);
                startActivity(i);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(Main2.this,FrenchOptions.class);
                i.putExtra("index",3);
                startActivity(i);
            }
        });
    }
}