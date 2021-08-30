package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    Button button31;
    EditText Email,Password;
    FirebaseAuth fAuth;
    TextView textView7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportActionBar().setTitle("Sign in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button31=findViewById(R.id.button31);
        textView7=findViewById(R.id.textView7);
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SigninActivity.this, "Logged in", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(SigninActivity.this,FoodCounter.class);
                startActivity(intent);
            }
        });
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        fAuth=FirebaseAuth.getInstance();

        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=Email.getText().toString().trim();
                String password=Password.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Email.setError("Email is not valid");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    Password.setError("Password is required");
                    return;
                }
                if(password.length()<6)
                {
                    Password.setError("Password must be >=6 characters ");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful())
                       {
                           Toast.makeText(SigninActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),FoodCounter.class));
                       }
                       else{
                           Toast.makeText(SigninActivity.this, "Error", Toast.LENGTH_SHORT).show();

                       }
                    }
                });

            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp_Activity.class));
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}