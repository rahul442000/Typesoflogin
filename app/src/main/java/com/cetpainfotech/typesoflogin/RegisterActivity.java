package com.cetpainfotech.typesoflogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText email,password;
    Button register,newaccount;
    SignInButton signInButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        signInButton=findViewById(R.id.gsignin);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        newaccount=findViewById(R.id.newaccount);
        register=findViewById(R.id.login);

        //to hide the unwanted button
        newaccount.setVisibility(View.GONE);
        signInButton.setVisibility(View.GONE);

        // to change the name login to register
        register.setText("Register");

        //to click on the register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent=new Intent (RegisterActivity.this,MainActivity.class);
                                    startActivity(intent);

                                } else{
                                }

                            }
                        });

            }
        });
    }
}
