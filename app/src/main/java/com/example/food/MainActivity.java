package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
Button login;
Button Signup;
TextView textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        login=findViewById(R.id.buttonlogin);
        textview2=findViewById(R.id.textView2);
        Signup=findViewById(R.id.Signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Login Page Opens", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,SigninActivity.class);
                startActivity(intent);
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,SignUp_Activity.class);
                startActivity(intent);
            }
        });


        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FoodCounter.class));
            }
        });


        
    }
    
    
    
}