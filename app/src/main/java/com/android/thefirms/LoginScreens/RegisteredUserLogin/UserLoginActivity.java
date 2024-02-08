package com.android.thefirms.LoginScreens.RegisteredUserLogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.thefirms.ForgetPassActivity;
import com.android.thefirms.SignupOptionsActivity;
import com.android.thefirms.databinding.ActivityUserLoginBinding;
import com.android.thefirms.registered_user.RegisteredUserActivity;

import java.util.Objects;

public class UserLoginActivity extends AppCompatActivity {

    ActivityUserLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding.createAccountTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLoginActivity.this,SignupOptionsActivity.class));
            }
        });

        binding.forgetTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLoginActivity.this, ForgetPassActivity.class));
            }
        });
        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Objects.requireNonNull(binding.emailInputTxt.getText()).toString().trim();
                String password = Objects.requireNonNull(binding.passwordInput.getText()).toString().trim();

                if (email.isEmpty()) {
                    binding.emailInputTxt.setError("Enter the E-mail");
                } else if (password.isEmpty()) {
                    binding.passwordInput.setError("Enter Your Password");
                } else {
                    try {
                        startActivity(new Intent(UserLoginActivity.this, RegisteredUserActivity.class));
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(UserLoginActivity.this, "Error starting activity", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
