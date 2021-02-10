package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {
    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timer = findViewById(R.id.timer);

        //initially
        btnstop.setVisibility(View.GONE);

//        //create optional anim
//        btnstop.setAlpha(0);

        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "font/MMedium.ttf");

        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //give animation
                icanchor.startAnimation(roundingalone);

                btnstop.setVisibility(View.VISIBLE);
                btnstart.setVisibility(View.GONE);

//                //show stop button
//                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
//
//                //hide start button
//                btnstart.animate().alpha(0).setDuration(300).start();

                //start timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnstart.setVisibility(View.VISIBLE);
                btnstop.setVisibility(View.GONE);
//                //show start button
//                btnstart.animate().alpha(1).translationY(80).setDuration(300).start();
//
//                //hide stop button
//                btnstop.animate().alpha(0).setDuration(300).start();

                //stop animation
                icanchor.clearAnimation();

                //stop timer
                timer.stop();
            }
        });


    }



}