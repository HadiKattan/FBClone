package com.example.customadapter_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText userEmail,userPass;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        initWidgets();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmail.getText().toString();
                String pass = userPass.getText().toString();
                createUser(email,pass);
            }
        });
    }

    private void createUser(String email, String pass) {
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else Toast.makeText(SignUpActivity.this, "Unable to create user", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initWidgets() {
        mAuth = FirebaseAuth.getInstance();
        userEmail = (EditText) findViewById(R.id.userSignEmail);
        userPass = (EditText) findViewById(R.id.userSignPass);
        btnSignUp = (Button) findViewById(R.id.btnSign);
    }
}