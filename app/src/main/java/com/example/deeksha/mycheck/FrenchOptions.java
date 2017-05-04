package com.example.deeksha.mycheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import com.example.deeksha.mycheck.ConstantsFolder.Constants;

import org.w3c.dom.Text;

public class FrenchOptions extends AppCompatActivity {
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_options);

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
        ImageView basic1 = (ImageView)findViewById(R.id.basic1);
        ImageView phrase1 = (ImageView)findViewById(R.id.phrase1);
        ImageView animal1 = (ImageView)findViewById(R.id.animal1);
        ImageView color1 = (ImageView)findViewById(R.id.color1);
        ImageView food1 = (ImageView)findViewById(R.id.food1);

        Intent in= getIntent();
        index=in.getIntExtra("index",0);
        imageView1.setImageResource(Constants.Flag_pics.flag_pics[index]);
        textView1.setText(Constants.Language_Intro.language_intro[index], TextView.BufferType.EDITABLE);

        basic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        "Basics",
//                        Toast.LENGTH_SHORT
//                ).show();

                Intent i = new Intent(FrenchOptions.this, FrenchBasics.class);
                i.putExtra("index",index);
                startActivity(i);
            }
        });

        phrase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        "Phrases",
//                        Toast.LENGTH_SHORT
//                ).show();
                Intent i = new Intent(FrenchOptions.this, FrenchPhrases.class);
                i.putExtra("index",index);
                startActivity(i);
            }
        });

        animal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        "Animals",
//                        Toast.LENGTH_SHORT
//                ).show();
                Intent i = new Intent(FrenchOptions.this, FrenchAnimals.class);
                i.putExtra("index",index);
                startActivity(i);
            }
        });

        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        "Colors",
//                        Toast.LENGTH_SHORT
//                ).show();
              Intent i = new Intent(FrenchOptions.this, FrenchColors.class);
                i.putExtra("index",index);
                startActivity(i);
            }
        });

        food1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        "Food",
//                        Toast.LENGTH_SHORT
//                ).show();
                Intent i = new Intent(FrenchOptions.this, FrenchFood.class);

                i.putExtra("index",index);
                startActivity(i);
            }
        });
    }
}
