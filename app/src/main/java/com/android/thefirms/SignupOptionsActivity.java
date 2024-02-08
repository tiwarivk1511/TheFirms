package com.android.thefirms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.thefirms.LoginScreens.RegisteredUserSignUp.UserSignupActivity;
import com.android.thefirms.databinding.ActivitySignupOptionsBinding;

public class SignupOptionsActivity extends AppCompatActivity {

    ActivitySignupOptionsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        binding.userSignupBtn.setOnClickListener(v -> {
            String account = "UserAc";
            Intent intent = new Intent(SignupOptionsActivity.this, UserSignupActivity.class);
            intent.putExtra("UserAc",account);
            startActivity(intent);
        });

        binding.organizationSignupBtn.setOnClickListener(v -> {
//            String conAcc = "comp_ac";
//            Intent intent = new Intent(SignupOptionsActivity.this, .class);
//            intent.putExtra("comp_ac",conAcc);
//            startActivity(intent);

            Toast.makeText(SignupOptionsActivity.this, "This service will start soon", Toast.LENGTH_SHORT).show();
        });

        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupOptionsActivity.this, LoginOptionsActivity.class));
            }
        });

    }
}