package com.example.mobileapplicationdevelopmentassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class notificationPageAdapter extends RecyclerView.Adapter<notificationPageAdapter.NotificationViewHolder> {
    private Context context;

    private List<notificationPageJavaClass> notificationList;

    public notificationPageAdapter(Context context, List<notificationPageJavaClass> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.notification_page_details, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull notificationPageAdapter.NotificationViewHolder holder, int position) {
        notificationPageJavaClass npjc=notificationList.get(position);
        holder.topic.setText(npjc.getTopic());
        holder.description.setText(npjc.getDescription());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static  class NotificationViewHolder extends RecyclerView.ViewHolder{
        TextView topic, description;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);

            topic=itemView.findViewById(R.id.notificationTopic);
            description=itemView.findViewById(R.id.notificationDescription);
        }
    }
}
