package com.android.thefirms.WelcomeScreens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.thefirms.LoginOptionsActivity;
import com.android.thefirms.LoginScreens.RegisteredUserLogin.UserLoginActivity;
import com.android.thefirms.R;

import com.ncorti.slidetoact.SlideToActView;


public class ViewPager2Adapter  extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

    // Array of images
    // Adding images from drawable folder
    private int[] images = {R.drawable.welcome1, R.drawable.welcome2, R.drawable.welcome3};
    private int[] indicators = {R.drawable.indicator1,R.drawable.indicator2,R.drawable.indicator3};
    String first = "The Firms makes it easier to identify companies that fulfil your project specifications.";
    String second = "Browse, Compare, Shortlist, and Hire your ideal business partner with ease.";
    String third = "We feature top companies offering popular services to ensure you find the right partner for every project.";

    private String[] texts ={first,second,third};
    private Context ctx;

    // Constructor of our ViewPager2Adapter class
    ViewPager2Adapter(Context ctx) {
        this.ctx = ctx;
    }

    // This method returns our layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.welcome_screen_layout, parent, false);
        return new ViewHolder(view);
    }

    // This method binds the screen with the view
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // This will set the images in imageview
        holder.images.setImageResource(images[position]);
        holder.text.setText(texts[position]);
        holder.indicators.setImageResource(indicators[position]);


        if (position == 2) {
            holder.nextBtn.setVisibility(View.INVISIBLE);
            holder.slide.setVisibility(View.VISIBLE);
            holder.slide.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
                @Override
                public void onSlideComplete(@NonNull SlideToActView slideToActView) {
                    // Launch RegisteredUserActivity
                    Intent intent = new Intent(ctx, LoginOptionsActivity.class);
                    ctx.startActivity(intent);

                    // Finish the current activity
                    if (ctx instanceof Activity) {
                        ((Activity) ctx).finish();
                    }
                }
            });
        } else {
            // If not on the third screen, hide the SlideToActView
            holder.nextBtn.setVisibility(View.VISIBLE);
            holder.slide.setVisibility(View.INVISIBLE);
        }

        holder.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = position+1;
                bindViewHolder(holder,p);
            }
        });
    }

    // This Method returns the size of the Array
    @Override
    public int getItemCount() {
        return images.length;
    }

    // The ViewHolder class holds the view
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images,indicators;
        TextView text;
        TextView nextBtn;

        SlideToActView slide;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.welcomeImg);
            indicators = itemView.findViewById(R.id.indincator);
            text = itemView.findViewById(R.id.welcomeTxt);
            nextBtn = itemView.findViewById(R.id.nextBtn);
            slide = itemView.findViewById(R.id.swipe_btn);

        }
    }
}
