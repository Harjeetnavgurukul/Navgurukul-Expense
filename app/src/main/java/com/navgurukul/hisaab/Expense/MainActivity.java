package com.navgurukul.hisaab.Expense;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    RelativeLayout rellay1, rellay2;
    Button buttonLogin;
    private EditText editTextemail, editTextpasswrod;
    private ProgressBar progressBar;
    private FirebaseAuth Auth;
    private TextView textViewSign, textViewForgot;

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

        //find Id..!
        editTextemail = findViewById(R.id.email_floating_lyout);
        editTextpasswrod = findViewById(R.id.pass_floating_lyout);
        buttonLogin = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progress);
        Auth = FirebaseAuth.getInstance();
        textViewSign = findViewById(R.id.SignUp);
        textViewForgot = findViewById(R.id.Forgot);

        //button set on click listener..!
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = editTextemail.getText().toString().trim();
                final String Password = editTextpasswrod.getText().toString().trim();
                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(MainActivity.this, "Please enter the password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(MainActivity.this, "Please enter the email", Toast.LENGTH_SHORT).show();
                }

                //get user email and password and signIn...!
                Auth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.VISIBLE);
                        if (!task.isSuccessful()) {
                            if (Password.length() < 6) {
                                editTextpasswrod.setError("Minimum password 6 char");
                            } else {
                                startActivity(new Intent(MainActivity.this, LandingPage.class));
                                finish();
                            }
                        }
                    }
                });
                //set click litisner go this activity to signUp activity...!
                textViewSign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
                        finish();
                    }
                });
                //set click litisner go this activity to forgot activity...!
                textViewForgot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this,ForgotPassword.class));
                        finish();
                    }
                });
            }
        });

//You and Fredrick are good friends. Yesterday, Fredrick received  credit cards from ABCD Bank. He wants to verify whether his credit card numbers are valid or not. You happen to be great at regex so he is asking for your help!
//
//A valid credit card from ABCD Bank has the following characteristics:
//
//► It must start with a ,  or .
//► It must contain exactly  digits.
//► It must only consist of digits (-).
//► It may have digits in groups of , separated by one hyphen "-".
//► It must NOT use any other separator like ' ' , '_', etc.
//► It must NOT have  or more consecutive repeated digits.
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