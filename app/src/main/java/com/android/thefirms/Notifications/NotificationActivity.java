package com.android.thefirms.Notifications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.android.thefirms.R;
import com.android.thefirms.databinding.ActivityNotificationBinding;

import java.util.ArrayList; // Import ArrayList
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    ActivityNotificationBinding binding;
    private List<NotificationModel> notificationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        // Initialize notificationList
        notificationList = new ArrayList<>();
        // Create and set up the adapter
        NotificationAdapter adapter = new NotificationAdapter(notificationList, this);
        binding.notificationRecyclerView.setAdapter(adapter);



        binding.clearTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all notifications of the list
                notificationList.clear();
                // Notify the adapter of the change
                adapter.notifyDataSetChanged();
                onDetachedFromRecyclerView(binding.notificationRecyclerView);
            }
        });

    }


    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.clearAnimation();
    }

}
