package com.graydalf.earlyadopter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;

import com.wonderkiln.blurkit.BlurLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BlurLayout blurLayout = findViewById(R.id.blurLayout);

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
//        LinearInterpolator lir = new LinearInterpolator();
//        rotate.setInterpolator(lir);
        findViewById(R.id.centerBgIv).startAnimation(rotate);

        AppCompatSeekBar seekBar1 = findViewById(R.id.seekBar1);
        AppCompatSeekBar seekBar2 = findViewById(R.id.seekBar2);
        AppCompatSeekBar seekBar3 = findViewById(R.id.seekBar3);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("####", "seekBar1 "+i);
                blurLayout.setFPS(i);
                blurLayout.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("####", "seekBar2 "+(i*1.0f/100));
                blurLayout.setDownscaleFactor((i*1.0f/100));
                blurLayout.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("####", "seekBar3 "+i);
                blurLayout.setBlurRadius(i);
                blurLayout.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}
