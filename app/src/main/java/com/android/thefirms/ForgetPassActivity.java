package com.android.thefirms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.android.thefirms.databinding.ActivityForgetPassBinding;


public class ForgetPassActivity extends AppCompatActivity {

    ActivityForgetPassBinding binding;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));


        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFailedPopup();
            }
        });

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = binding.emailInputTxt.getText().toString();
                if (TextUtils.isEmpty(email)){
                    binding.emailInputTxt.setError("Enter your registered E-mail");
                } else {
                    // Call your API to send the password reset email
                    sendPasswordResetEmail(email);
                }
            }
        });
    }

    private void sendPasswordResetEmail(String email) {
        // TODO: Implement your API call here using Retrofit or any other networking library
        // For demonstration purposes, let's assume a successful response from the API
        showSuccessPopup();
        // For demonstration purposes, let's assume a failed response from the API
    }

    private void showSuccessPopup() {
        // Create a dialog and set its custom layout
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.forget_popup_success);

        // Customize the content of the custom layout
        LottieAnimationView anim = dialog.findViewById(R.id.statusImg);
        TextView titleTextView = dialog.findViewById(R.id.PopupHeading);
        TextView messageTextView = dialog.findViewById(R.id.instructionTxt);
        Button okButton = dialog.findViewById(R.id.okBtn);

        anim.setAnimation(R.raw.success_anim);
        anim.playAnimation();
        titleTextView.setText("Reset link sent");
        messageTextView.setText("We have sent a reset password link"+"\n to example@gmail.com to get you"+"\n back into your account" );

        // Set a listener for the OK button to dismiss the dialog
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // Show the custom dialog
        dialog.show();
    }


    private void showFailedPopup(){
        // Create a dialog and set its custom layout
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.forget_popup_success);

        // Customize the content of the custom layout
        LottieAnimationView anim = dialog.findViewById(R.id.statusImg);
        TextView titleTextView = dialog.findViewById(R.id.PopupHeading);
        TextView messageTextView = dialog.findViewById(R.id.instructionTxt);
        Button okButton = dialog.findViewById(R.id.okBtn);

        anim.setAnimation(R.raw.error_anim);
        anim.playAnimation();
        titleTextView.setText("Reset link failed!");
        messageTextView.setText("Something wents Wrong!" );

        // Set a listener for the OK button to dismiss the dialog
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // Show the custom dialog
        dialog.show();
    }

}
