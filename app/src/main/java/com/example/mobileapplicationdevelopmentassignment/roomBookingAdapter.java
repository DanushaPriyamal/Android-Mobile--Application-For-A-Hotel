package com.example.mobileapplicationdevelopmentassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class roomBookingAdapter extends RecyclerView.Adapter<roomBookingAdapter.RoomViewHolder> {
    private Context context;

    private List<roomBookJavaClass> roomList;

    public roomBookingAdapter(Context context, List<roomBookJavaClass> roomList) {
        this.context = context;
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_item_layout, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        roomBookJavaClass room=roomList.get(position);
        holder.type.setText(room.getRoomType());
        holder.price.setText(room.getRoomPrice());
        holder.description.setText(room.getRoomDescription());
        holder.availability.setText(room.getRoomAvailability());

        Bitmap bitmap= BitmapFactory.decodeByteArray(room.getRoomImage(), 0, room.getRoomImage().length);
        holder.image.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder{
        TextView type, price, description, availability;

        ImageView image;

        public RoomViewHolder(View itemView) {
            super(itemView);

            type = itemView.findViewById(R.id.roomType);
            price = itemView.findViewById(R.id.roomPrice);
            description = itemView.findViewById(R.id.roomDescription);
            image = itemView.findViewById(R.id.roomImage);
            availability=itemView.findViewById(R.id.roomAvailableOrNot);
        }
    }
}
