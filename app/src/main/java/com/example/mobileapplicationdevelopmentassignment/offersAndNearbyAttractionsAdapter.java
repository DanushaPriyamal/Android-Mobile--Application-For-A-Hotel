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

public class offersAndNearbyAttractionsAdapter extends RecyclerView.Adapter<offersAndNearbyAttractionsAdapter.oanViewHolder> {
    public Context context;

    public List<offersAndNearbyAttractionsJavaClass> oanList;

    public offersAndNearbyAttractionsAdapter(Context context, List<offersAndNearbyAttractionsJavaClass> oanList) {
        this.context = context;
        this.oanList = oanList;
    }

    @NonNull
    @Override
    public oanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.offers_and_nearby_attractions_details, parent, false);
        return new oanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull oanViewHolder holder, int position) {
        offersAndNearbyAttractionsJavaClass oanajc=oanList.get(position);
        holder.oanTopic.setText(oanajc.getTopic());
        holder.oanPrice.setText(oanajc.getPrice());
        holder.oanDescription.setText(oanajc.getDescription());

        Bitmap bitmap= BitmapFactory.decodeByteArray(oanajc.getImage(), 0, oanajc.getImage().length);
        holder.oanImage.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return oanList.size();
    }

    public static class oanViewHolder extends RecyclerView.ViewHolder{
        TextView oanTopic, oanPrice, oanDescription;

        ImageView oanImage;
        public oanViewHolder(@NonNull View itemView) {
            super(itemView);

            oanTopic=itemView.findViewById(R.id.oanTopic);
            oanPrice=itemView.findViewById(R.id.oanPrice);
            oanDescription=itemView.findViewById(R.id.oanDescription);
            oanImage=itemView.findViewById(R.id.oanImage);
        }
    }
}
