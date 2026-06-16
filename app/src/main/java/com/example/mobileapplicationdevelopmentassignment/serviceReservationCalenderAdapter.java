package com.example.mobileapplicationdevelopmentassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class serviceReservationCalenderAdapter extends RecyclerView.Adapter<serviceReservationCalenderAdapter.serviceReservationCalenderViewHolder> {
    public Context context;

    public List<serviceReservationCalenderJavaClass> serviceReservationList;

    public serviceReservationCalenderAdapter(Context context, List<serviceReservationCalenderJavaClass> serviceReservationList) {
        this.context = context;
        this.serviceReservationList = serviceReservationList;
    }

    @NonNull
    @Override
    public serviceReservationCalenderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.service_reserving_details, parent, false);
        return new serviceReservationCalenderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull serviceReservationCalenderViewHolder holder, int position) {
        serviceReservationCalenderJavaClass srcjc=serviceReservationList.get(position);
        holder.type.setText(srcjc.getServiceType());
        holder.date.setText(srcjc.getReservationDate());
        holder.time.setText(srcjc.getReservationTime());
    }

    @Override
    public int getItemCount() {
        return serviceReservationList.size();
    }

    public static class serviceReservationCalenderViewHolder extends RecyclerView.ViewHolder{
        TextView type, date, time;

        public serviceReservationCalenderViewHolder(View itemView){
            super(itemView);

            type=itemView.findViewById(R.id.serviceType);
            date=itemView.findViewById(R.id.reservationDate);
            time=itemView.findViewById(R.id.reservationTime);
        }
    }
}
