package com.navgurukul.hisaab.hisaab_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class RequestTransfer extends AppCompatActivity {
    Spinner spinner;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_transfer);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RequestTransfer.this,LandingPage.class));
            }
        });

        Spinner spinner2 = findViewById(R.id.need_money);
        String[] count = {"For whom do you need the money?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, count);
        spinner2.setAdapter(adapter);
    }
}
