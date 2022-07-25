package com.example.novelscholar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureParams;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView i2,i3,i4;
TextView t; Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i2=(ImageView)findViewById(R.id.imageView2);
        i3=(ImageView)findViewById(R.id.imageView3);
        i4=(ImageView)findViewById(R.id.imageView4);
        t=(TextView)findViewById(R.id.textView);
        animation   = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        t.startAnimation(animation);
        i2.startAnimation(animation);
        i3.startAnimation(animation);
        i4.startAnimation(animation);
        final Intent intent=new Intent(this,MainActivity2.class);
        Thread timer=new Thread(){
            public void run(){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

}