package com.example.deeksha.mycheck;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deeksha.mycheck.ConstantsFolder.Constants;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class FrenchColors extends AppCompatActivity implements TextToSpeech.OnInitListener {

    ImageView imageView1,cloud;
    EditText editText1,editText2;
    Button button2,button1;
    TextToSpeech ttobj;
    String toSpeak;
    int i=0;
    int index=0;
    String basic_beg = "How do we say \n \"";
    String basic_end ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_colors);
        Intent in = getIntent();
        index = in.getIntExtra("index",0);

        basic_end = Constants.Language_Name.language_name[index];
        editText1 = (EditText) findViewById(R.id.editText1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        cloud = (ImageView) findViewById(R.id.cloud);
        editText2 = (EditText) findViewById(R.id.editText2);
        button2 =(Button) findViewById(R.id.button2);
        button1 =(Button) findViewById(R.id.button1);
        ttobj=new TextToSpeech(this,this);
        ttobj.setLanguage(Locale.FRENCH);

        String total= basic_beg+Constants.Translations.COLORS.colors[0]+basic_end;
        editText1.setText(total, TextView.BufferType.EDITABLE);
        imageView1.setImageResource(Constants.Color_pics.color_pics[0]);
        button2.setBackgroundColor(Color.parseColor("#B0CBC4"));
        button2.setEnabled(false);
    }

    public void next(View v){
        button2.setEnabled(false);
        button1.setText("See!");
        i++;
        try {
            if(i==6)
                button2.setText("Back");
            else if(i==7) {
                Intent i = new Intent(FrenchColors.this, FrenchOptions.class);
                startActivity(i);
            }
            String total = basic_beg + Constants.Translations.COLORS.colors[i] + basic_end;
            Log.i("TAG", total);
            editText1.setText(total, TextView.BufferType.EDITABLE);
            imageView1.setImageResource(Constants.Color_pics.color_pics[i]);
            editText2.getText().clear();
            cloud.setImageResource(0);
            button2.setBackgroundColor(Color.parseColor("#B0CBC4"));
            button2.setEnabled(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void see(View v){
        toSpeak = editText2.getText().toString();
//        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null,null);
        }
        else{
            ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        }
        //ttobj.addSpeech(toSpeak,"com.example.deeksha.mycheck",0);

        final Handler handler = new Handler();
        Timer timer = new Timer();

        TimerTask picSwitch1 = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        cloud.setImageResource(R.drawable.cloud);
                    }
                });
            }
        };

        TimerTask picSwitch2 = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        // Log.i("TAG",Constants.Template.ANIMALS.animals[index][i]);
                        editText2.setText(Constants.Template.COLORS.colors[index][i]);

                        //Log.i("TAG2",Constants.Template.ANIMALS.animals[index][i]);
                        button1.setText("Wanna Listen?");
//                        button2.setAlpha(1f);
                        //Log.i("TAG2",Constants.Template.ANIMALS.animals[index][i]);

                        button2.setEnabled(true);
                        //Log.i("TAG2",Constants.Template.ANIMALS.animals[index][i]);

                        button2.setBackgroundColor(Color.parseColor("#00695C"));
                        // Log.i("TAG2",Constants.Template.ANIMALS.animals[index][i]);



                    }
                });
            }
        };
        timer.schedule(picSwitch1, 500);
        timer.schedule(picSwitch2, 900);
    }

    @Override
    public void onInit(final int status) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("TAG2",Integer.toString(index));
                if(status !=TextToSpeech.ERROR){
                    if(index==0)
                        ttobj.setLanguage(Locale.FRENCH);
                    else if(index==1)
                        ttobj.setLanguage(Locale.ENGLISH);
                    else if(index==2)
                    {
                        ttobj.setLanguage(Locale.ITALIAN);
                        Log.i("TAG2",Integer.toString(index));
                    }
                    else if(index==3)
                        ttobj.setLanguage(Locale.GERMAN);
                    else
                        Log.i("TAG","Error in language selection");
                    ttobj.setSpeechRate(1f);
                    ttobj.setPitch(1.2f);
                }
            }
        }).start();
    }
}