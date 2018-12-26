package com.cetpainfotech.typesoflogin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ImageView image;
    TextView appname;
    Animation animation,animation1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        appname=findViewById(R.id.appname);
        image=findViewById(R.id.image);
        // to load animation
        animation = AnimationUtils
                .loadAnimation(this,R.anim.a);
        animation1= AnimationUtils
                .loadAnimation(this, R.anim.b);
        //to load the animation to textview
        appname.startAnimation(animation);
        //to load the different animation to imageview from b file

        image.startAnimation(animation1);
        //to hid ethe action bar
        getSupportActionBar().hide();
        //to hide status bar for x coordinate and y coordinate
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //to switch the activity automatically after 3 sec
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //to perform the background operation
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                //no back track
                finish();
            }
        },3000);
    }
}
