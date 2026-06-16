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

public class manageServiceReservationsAdapter extends RecyclerView.Adapter<manageServiceReservationsAdapter.serviceReservationViewHolder> {
    private Context context;

    private List<manageServiceReservationJavaClass> manageServiceList;

    private luxeVistaDB luxeVistaDB;

    public manageServiceReservationsAdapter(Context context, List<manageServiceReservationJavaClass> manageServiceList) {
        this.context = context;
        this.manageServiceList = manageServiceList;
        this.luxeVistaDB =new luxeVistaDB(context);
    }

    @NonNull
    @Override
    public serviceReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.manage_service_reservation_details, parent, false);
        return new serviceReservationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull manageServiceReservationsAdapter.serviceReservationViewHolder holder, int position) {
        manageServiceReservationJavaClass msrjc=manageServiceList.get(position);
        holder.ID.setText(String.valueOf(msrjc.getReservationID()));
        holder.Type.setText(msrjc.getReservationType());
        holder.fullName.setText(msrjc.getReservationFullName());
        holder.email.setText(msrjc.getReservationEmail());
        holder.date.setText(msrjc.getReservationDate());
        holder.time.setText(msrjc.getReservationTime());

        holder.deleteReservationBtn.setOnClickListener(v ->{
            int idPass=msrjc.getReservationID();
            if(luxeVistaDB.deleteReservation(idPass)){
                Toast.makeText(context, "Reservation deleted", Toast.LENGTH_SHORT).show();
                manageServiceList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, manageServiceList.size());
            }else{
                Toast.makeText(context, "Reservation deletion isn't successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return manageServiceList.size();
    }

    public static class serviceReservationViewHolder extends RecyclerView.ViewHolder{
        TextView ID, Type, fullName, email, date, time;

        Button deleteReservationBtn;

        public serviceReservationViewHolder(@NonNull View itemView) {
            super(itemView);

            ID=itemView.findViewById(R.id.serviceReservationID);
            Type=itemView.findViewById(R.id.serviceReservationType);
            fullName=itemView.findViewById(R.id.serviceReservationFullName);
            email=itemView.findViewById(R.id.serviceReservationEmail);
            date=itemView.findViewById(R.id.serviceReservationDate);
            time=itemView.findViewById(R.id.serviceReservationTime);
            deleteReservationBtn=itemView.findViewById(R.id.deleteReservationBtn);
        }
    }
}
