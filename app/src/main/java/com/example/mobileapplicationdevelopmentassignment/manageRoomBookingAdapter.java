package com.example.mobileapplicationdevelopmentassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class manageRoomBookingAdapter extends RecyclerView.Adapter<manageRoomBookingAdapter.RoomViewHolder> {

    private Context context;

    private List<manageRoomBookingsJavaClass> bookingList;

    private luxeVistaDB db;

    public manageRoomBookingAdapter(Context context, List<manageRoomBookingsJavaClass> bookingList) {
        this.context = context;
        this.bookingList = bookingList;
        this.db=new luxeVistaDB(context);
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.room_booking_details, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull manageRoomBookingAdapter.RoomViewHolder holder, int position) {
        manageRoomBookingsJavaClass mrbj=bookingList.get(position);
        holder.id.setText(String.valueOf(mrbj.getRoomBookingId()));
        holder.fullName.setText(mrbj.getRoomBookingFullName());
        holder.email.setText(mrbj.getRoomBookingEmail());
        holder.type.setText(mrbj.getBookingRoomType());

        holder.deleteBtn.setOnClickListener(v -> {
            int idPass = mrbj.getRoomBookingId();
            String roomTypePass=mrbj.getBookingRoomType();
            if (db.deleteBooking(idPass)) {
                Toast.makeText(context, "Booking deleted", Toast.LENGTH_SHORT).show();
                bookingList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, bookingList.size());

                db.updateRoomAvailability(roomTypePass, "Available");
            } else {
                Toast.makeText(context, "Delete failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder{
        TextView id, fullName, email, type;

        Button deleteBtn;

        public RoomViewHolder(View itemView){
            super(itemView);

            id=itemView.findViewById(R.id.roomID);
            fullName=itemView.findViewById(R.id.fullName);
            email=itemView.findViewById(R.id.email);
            type=itemView.findViewById(R.id.roomType);
            deleteBtn=itemView.findViewById(R.id.deleteBtn);
        }
    }
}
