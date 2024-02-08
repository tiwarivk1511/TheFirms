package com.android.thefirms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.android.thefirms.LoginScreens.RegisteredUserLogin.UserLoginActivity;
import com.android.thefirms.databinding.ActivityLoginOptionsBinding;

public class LoginOptionsActivity extends AppCompatActivity {

    ActivityLoginOptionsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));


        binding.userLoginBtn.setOnClickListener(v -> {
            String account = "UserAc";
            Intent intent = new Intent(LoginOptionsActivity.this, UserLoginActivity.class);
            intent.putExtra("UserAc",account);
            startActivity(intent);
        });

        binding.organizationLoginBtn.setOnClickListener(v -> {
            String conAcc = "comp_ac";
            Intent intent = new Intent(LoginOptionsActivity.this, UserLoginActivity.class);
            intent.putExtra("comp_ac",conAcc);
            startActivity(intent);
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginOptionsActivity.this, SignupOptionsActivity.class));
            }
        });

    }
}