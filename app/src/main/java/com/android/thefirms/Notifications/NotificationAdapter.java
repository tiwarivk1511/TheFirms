package com.android.thefirms.Notifications;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.thefirms.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationModel> notificationList;
    private Context context;

    public NotificationAdapter(List<NotificationModel> notificationList, Context context) {
        this.notificationList = notificationList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NotificationModel notification = notificationList.get(position);

        holder.titleTextView.setText(notification.getTitle());
        holder.messageTextView.setText(notification.getMessage());
        holder.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clear the current Notification from the list
                // Remove the notification from the list
                notificationList.remove(position);
                // Notify the adapter of the item removal
                notifyItemRemoved(position);
                // Notify the adapter that the dataset has changed
                notifyItemRangeChanged(position, notificationList.size());
            }
        });

        holder.notificationElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.messageTextView.setVisibility(View.VISIBLE);
            }
        });


        // Add animation
        setAnimation(holder.itemView);
    }
    // Animation method
    private void setAnimation(View viewToAnimate) {
        // You can use any animation you prefer. For example, here's a simple fade animation:
        viewToAnimate.setAlpha(0f);
        viewToAnimate.animate().alpha(1f).setDuration(500).start();
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        recyclerView.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView messageTextView;
        private ImageView clearBtn;

        private CardView notificationElement;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.notificationTitle);
            messageTextView = itemView.findViewById(R.id.notificationContent);
            clearBtn = itemView.findViewById(R.id.clear_notificationBtn);
            notificationElement = itemView.findViewById(R.id.notificationElement);
        }
    }
}
