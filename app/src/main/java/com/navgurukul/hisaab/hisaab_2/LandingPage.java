package com.navgurukul.hisaab.hisaab_2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.Calendar;

public class LandingPage extends AppCompatActivity {


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        editText = findViewById(R.id.EditText);
        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);


        //Open gallery by click button....!
        button = findViewById(R.id.Bill);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);

            }
        });

        nv = (NavigationView) findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_status) {
                    startActivity(new Intent(LandingPage.this, User_Status.class));
                } else if (id == R.id.nav_bill) {
                    startActivity(new Intent(LandingPage.this, RequestBillPayment.class));
                } else if (id == R.id.nav_transfer) {
                    startActivity(new Intent(LandingPage.this, RequestTransfer.class));
                } else if (id == R.id.nav_payment) {
                    startActivity(new Intent(LandingPage.this, ViewPayments.class));
                } else if (id == R.id.nav_signOut) {
                    startActivity(new Intent(LandingPage.this, MainActivity.class));
                }
                return true;

            }
        });

        //form code..................
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        String[] count = {"Choose campus", "Bangalore", "Dharamshala"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, count);
        spinner.setAdapter(adapter);


        String[] count1 = {"who made the expense"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, count1);
        spinner1.setAdapter(adapter1);


        String[] count2 = {"Category", "Groceries", "Transportation", "Vegetable", "Milk", "Egg & Bread",
                "Tech Expense", "NG Fixe/Maintenance", "Medical Expense", "Other", "Household items", "Added to PayTM", "Money Given by NG",
                "Cooking Gas (Cylinder)", "Utility Bills", "Withdraw Amount"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, count2);
        spinner2.setAdapter(adapter2);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    //show Datepicker...!
    public void rate(int year, int month, int day){
        String month_string= Integer.toString(month+1);
        String day_string=Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        editText.setText(dateMessage);
        }

    public void Datepickkrlo(View view){
        LandingFragment fd=new LandingFragment();
        fd.show(getSupportFragmentManager(),"date");
    }

}
