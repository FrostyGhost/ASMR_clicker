package com.example.frostyghost.asmr_clicker;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_playground;
    private TextView tv_clickmeter;
    private int clickMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_playground = findViewById(R.id.iv_playground);
        tv_clickmeter = findViewById(R.id.tv_clickmeter);

        clickMeter=0;
        tv_clickmeter.setText(String.valueOf(clickMeter));

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.sponge_long_sound);

        //+animation
        iv_playground.setBackgroundResource(R.drawable.soap);
        final AnimationDrawable animationDrawable = (AnimationDrawable)iv_playground.getBackground();


        iv_playground.setClickable(true);
        iv_playground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                clickMeter++;
                tv_clickmeter.setText(String.valueOf(clickMeter));

                //animation
                animationDrawable.stop();
                animationDrawable.start();
                //TODO




            }
        });
    }

    public void onMenu(View view){
        startActivity(new Intent(this, ItemsMenuActivity.class));
    }
}
