package com.android.thefirms.ratings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.android.thefirms.R;
import com.android.thefirms.databinding.ActivityRating3Binding;

public class RatingActivity3 extends AppCompatActivity {

    ActivityRating3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRating3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        Intent intent = getIntent();
        String projectName = intent.getStringExtra("projectName");
        String projectDescription = intent.getStringExtra("projectDescription");
        String cost = intent.getStringExtra("cost");
        String industry = intent.getStringExtra("industry");
        String projectStatus = intent.getStringExtra("projectStatus");
        String service = intent.getStringExtra("service");
        String reviewTitle = intent.getStringExtra("reviewTitle");
        String reviewDescription = intent.getStringExtra("reviewDescription");
        String likeMostAbout= intent.getStringExtra("likeMost");
        String likeLeastAbout = intent.getStringExtra("likeLeast");

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RatingActivity3.this,RatingActivity4.class);
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
        });
    }
}