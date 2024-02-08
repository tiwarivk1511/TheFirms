package com.android.thefirms.LoginScreens.RegisteredUserSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;

import com.android.thefirms.R;
import com.android.thefirms.databinding.ActivityUserSignupBinding;

public class UserSignupActivity extends AppCompatActivity {

    ActivityUserSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        String firstName = binding.firstnameTxt.getText().toString();
        String lastName = binding.lastnameTxt.getText().toString();
        String email = binding.emailTxt.getText().toString();
        String countryCode = binding.countryCodePicker.getSelectedCountryCode().toString();
        String phone = binding.phoneNoTxt.getText().toString();
        String password = binding.passwordEditTxt.getText().toString();
        String cnfpassword = binding.ConfirmPasswordEditTxt.getText().toString();

        if (TextUtils.isEmpty(firstName)) {
            binding.firstnameTxt.setError("Enter your first name");
        } else if (TextUtils.isEmpty(lastName)) {
            binding.lastnameTxt.setError("Enter your last name");
        } else if (TextUtils.isEmpty(email)) {
            binding.emailTxt.setError("Enter your email");
            // You can add more validation logic for email format if needed
        } else if (TextUtils.isEmpty(phone)) {
            binding.phoneNoTxt.setError("Enter your phone number");
        } else if (TextUtils.isEmpty(password)) {
            binding.passwordEditTxt.setError("Enter your password");
        } else if (TextUtils.isEmpty(cnfpassword) || !cnfpassword.equals(password)) {
            binding.ConfirmPasswordEditTxt.setError("Passwords are not matched");
        } else {

           String FullPhoneNumber = "+"+countryCode+phone;


            // If all validations pass, you can proceed with the signup logic
            // Call your signup method or start the signup activity here
            // For example:
            // signUp(firstName, lastName, email, countryCode, phone, password);
        }
    }
}