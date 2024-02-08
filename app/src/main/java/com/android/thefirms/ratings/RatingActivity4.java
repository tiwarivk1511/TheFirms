package com.android.thefirms.ratings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.android.thefirms.R;
import com.android.thefirms.databinding.ActivityRating2Binding;
import com.android.thefirms.databinding.ActivityRating4Binding;

public class RatingActivity4 extends AppCompatActivity {

    ActivityRating4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRating4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        binding.verifySubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReviewerName = binding.userNameEditTxt.getText().toString();
                String ReviewerCompany = binding.CompanyEditTxt.getText().toString();
                String ReviewerDesignation = binding.positionEditTxt.getText().toString();
                String ReviewerLocation = binding.locationAutoCompletedTxt.getText().toString();
                String ReviewerWebsite = binding.websiteLinkEditTxt.getText().toString();
                String ReviewerEmail = binding.businessEmailTxtView.getText().toString();

                // Check if the ReviewerName is empty
                if (ReviewerName.trim().isEmpty()) {
                    binding.userNameEditTxt.setError("Please enter your name");

                }
                // Check if the ReviewerCompany is empty
                else if (ReviewerCompany.trim().isEmpty()) {
                    binding.CompanyEditTxt.setError("Please enter your company name");

                }
                // Check if the ReviewerDesignation is empty
                else if (ReviewerDesignation.trim().isEmpty()) {
                    binding.positionEditTxt.setError("Please enter your designation");

                }
                // Check if the ReviewerLocation is empty
                else if (ReviewerLocation.trim().isEmpty()) {
                    binding.locationAutoCompletedTxt.setError("Please enter your location");

                }
                // Check if the ReviewerWebsite is empty or not a valid URL (assuming it should be a URL)
                else if (ReviewerWebsite.trim().isEmpty() || !android.util.Patterns.WEB_URL.matcher(ReviewerWebsite).matches()) {
                    binding.websiteLinkEditTxt.setError("Please enter a valid website URL");

                }
                // Check if the ReviewerEmail is empty or not a valid email address
                else if (ReviewerEmail.trim().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(ReviewerEmail).matches()) {
                    binding.businessEmailTxtView.setError("Please enter a valid email address");

                }
                else {
                    //code to submit the data
                }
            }
        });
    }
}