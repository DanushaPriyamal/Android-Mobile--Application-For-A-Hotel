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

public class serviceReservationAdapter extends RecyclerView.Adapter<serviceReservationAdapter.serviceViewHolder> {
    private Context context;

    private List<serviceReservationJavaClass> serviceList;

    public serviceReservationAdapter(Context context, List<serviceReservationJavaClass> serviceList) {
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public serviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.service_item_layout, parent, false);
        return new serviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull serviceViewHolder holder, int position) {
        serviceReservationJavaClass service=serviceList.get(position);
        holder.type.setText(service.getServiceType());
        holder.price.setText(service.getServicePrice());
        holder.description.setText(service.getServiceDescription());

        Bitmap bitmap= BitmapFactory.decodeByteArray(service.getServiceImage(), 0, service.getServiceImage().length);
        holder.image.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public static class serviceViewHolder extends RecyclerView.ViewHolder{
        TextView type, price, description;

        ImageView image;
        public serviceViewHolder(@NonNull View itemView) {
            super(itemView);

            type=itemView.findViewById(R.id.serviceType);
            price=itemView.findViewById(R.id.servicePrice);
            description=itemView.findViewById(R.id.serviceDescription);
            image=itemView.findViewById(R.id.serviceImage);

        }
    }
}
