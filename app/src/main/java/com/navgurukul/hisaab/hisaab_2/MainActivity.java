package com.navgurukul.hisaab.hisaab_2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    RelativeLayout rellay1, rellay2;
    Button button;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.GONE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LandingPage.class));
            }
        });

//
//
//        TextView txt = findViewById(R.id.txt_navgurukul);
//        TextView txt2 = findViewById(R.id.txt_expence);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Decker.ttf");
//
//        txt.setTypeface(custom_font);
//        txt2.setTypeface(custom_font);

        rellay1 = (RelativeLayout) findViewById(R.id.relative_1);
        rellay2 = (RelativeLayout) findViewById(R.id.relative_2);

        handler.postDelayed(runnable, 4000);

    }
}