package com.navgurukul.hisaab.Expense;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class RequestBillPayment extends AppCompatActivity {

    Spinner spinner;
    Button button;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_bill_payment);

        //Back by Click...!
        back = findViewById(R.id.image1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RequestBillPayment.this,LandingPage.class));
                finish();
            }
        });

        //Upload Bill Photo...!
        button = findViewById(R.id.Bill);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);

            }
        });

        Spinner spinner = findViewById(R.id.Type_Bill);
        String[] count = {"Select type of the Bill", "Internet", "Electricity", "WaterBill", "Houserent"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, count);
        spinner.setAdapter(adapter);
    }
}
