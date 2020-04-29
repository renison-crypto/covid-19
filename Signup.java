package com.example.movies40;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
    String userNames, passWords;
    Button b3;
    EditText ed1,ed2;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        b3 = findViewById(R.id.login_signup);
        ed1 = findViewById(R.id.username_signup);
        ed2 = findViewById(R.id.password_signup);


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userNames = ed1.getText().toString();
                passWords = ed2.getText().toString();
                Intent signupintent=new Intent(Signup.this,MainActivity.class); // redirecting to LoginActivity.

                SharedPreferences.Editor prefsEditor = getSharedPreferences("User", MODE_PRIVATE).edit();
                prefsEditor.putString("User", userNames);
                prefsEditor.putString("Password", passWords);
                prefsEditor.apply();

                startActivity(signupintent);
                finish();

            }
        });
    }
}
