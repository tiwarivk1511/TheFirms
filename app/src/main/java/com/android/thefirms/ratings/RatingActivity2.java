package com.android.thefirms.ratings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.android.thefirms.R;
import com.android.thefirms.databinding.ActivityRating2Binding;

public class RatingActivity2 extends AppCompatActivity {

    ActivityRating2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =ActivityRating2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));

        // Retrieve data from previous activity
        Intent intent = getIntent();
        String projectName = intent.getStringExtra("projectName");
        String projectDescription = intent.getStringExtra("projectDescription");
        String cost = intent.getStringExtra("cost");
        String industry = intent.getStringExtra("industry");
        String projectStatus = intent.getStringExtra("projectStatus");


        binding.projectDetailNextCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String service = binding.serviceSearch.getText().toString();
                String reviewTitle = binding.titleEditTxt.getText().toString();
                String reviewDescription = binding.detailEditTxt.getText().toString();
                String likeMostAbout=binding.aboutEditTxt.getText().toString();
                String likeLeastAbout = binding.leastAboutEditTxt.getText().toString();

                // Data validation
                if (TextUtils.isEmpty(service)) {
                    binding.serviceSearch.setError("Please enter a service");

                } else if (TextUtils.isEmpty(reviewTitle)) {
                    binding.titleEditTxt.setError("Please enter a review title");

                } else if (TextUtils.isEmpty(reviewDescription)) {
                    binding.detailEditTxt.setError("Please enter a review description");

                } else if (TextUtils.isEmpty(likeMostAbout)) {
                    binding.aboutEditTxt.setError("Please specify what you like most");

                } else if (TextUtils.isEmpty(likeLeastAbout)) {
                    binding.leastAboutEditTxt.setError("Please specify what you like least");

                }
                else{
                    //send all of the data to the NextScreen
                    Intent intent = new Intent(RatingActivity2.this, RatingActivity3.class);
                    intent.putExtra("projectName",projectName);
                    intent.putExtra("projectDescription",projectDescription);
                    intent.putExtra("cost",cost);
                    intent.putExtra("industry",industry);
                    intent.putExtra("projectStatus",projectStatus);
                    intent.putExtra("service",service);
                    intent.putExtra("reviewTitle",reviewTitle);
                    intent.putExtra("reviewDescription",reviewDescription);
                    intent.putExtra("likeMost",likeMostAbout);
                    intent.putExtra("likeLeast",likeLeastAbout);
                    startActivity(intent);
                }

            }
        });
    }
}