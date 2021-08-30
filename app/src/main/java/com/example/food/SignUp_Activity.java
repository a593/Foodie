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

public class SignUp_Activity extends AppCompatActivity {
    TextView textView3,textview7;
    EditText Name,Phone,Email,Password;
    Button button31;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);
        getSupportActionBar().setTitle("Sign up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView3=findViewById(R.id.textView3);
        textview7=findViewById(R.id.textView7);
       Name=findViewById(R.id.Name);
        Phone=findViewById(R.id.Phone);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        button31=findViewById(R.id.button31);
        fAuth=FirebaseAuth.getInstance();
//        if(fAuth.getCurrentUser()!=null)
//        {
//            startActivity(new Intent(getApplicationContext(),FoodCounter.class));
//            finish();
//
//        }

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
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUp_Activity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),FoodCounter.class));
                            finish();
                        } else{
                            Toast.makeText(SignUp_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        textview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SigninActivity.class));
            }
        });




    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}