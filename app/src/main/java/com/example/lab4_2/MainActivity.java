package com.example.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout right = null;
    LinearLayout left = null;
    Button rightbtn = null;
    Animation translateLeft = null;
    Animation translateRight = null;
    boolean isrightPageState = false;  //page state
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        right = (LinearLayout) findViewById(R.id.right);
        translateLeft = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.anim_right);
        SlidingAnimationListener listener1 = new SlidingAnimationListener();
        SlidingAnimationListener listener2 = new SlidingAnimationListener();
        translateLeft.setAnimationListener(listener1);
        translateRight.setAnimationListener(listener2);
        rightbtn = findViewById(R.id.rightbtn);
        rightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isrightPageState) {
                    right.startAnimation(translateRight);
                } else {
                    right.setVisibility(View.VISIBLE);
                    right.startAnimation(translateLeft);
                }
            }
        });
    }
    class SlidingAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
        }
        @Override
        public void onAnimationEnd(Animation animation) {
            if (isrightPageState) {
                right.setVisibility(View.INVISIBLE);
                rightbtn.setText("OPEN PAGE");
                isrightPageState = false;
            } else {
                rightbtn.setText("Close Page");
                isrightPageState = true;
            }
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
