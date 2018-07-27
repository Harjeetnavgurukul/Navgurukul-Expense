package com.navgurukul.hisaab.hisaab_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RequestTransfer extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_transfer);

        Spinner spinner2 = findViewById(R.id.need_money);
        String[] count = {"For whom do you need the money?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, count);
        spinner2.setAdapter(adapter);
    }
}
