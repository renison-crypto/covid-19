package com.example.movies40;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.login);
        b2 = findViewById(R.id.signup);
        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.password);

        SharedPreferences prefs = getSharedPreferences("User", MODE_PRIVATE);
        final String userName = prefs.getString("User", null);
        final String password = prefs.getString("Password", null);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) ||(ed1.getText().toString().equals(userName)&&
                        ed2.getText().toString().equals(password))) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,TrackCovid19.class); // redirecting to LoginActivity.
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong  Credentials",Toast.LENGTH_SHORT).show();

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Signup.class); // redirecting to LoginActivity.
                startActivity(intent);

            }
        });

//
    }
}
