package com.example.uts_mcs_2540120345;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.viewHolder> {
    private Context context;
    private ArrayList email_id, quantity_id;

    public AdapterHistory(Context context, ArrayList email_id, ArrayList quantity_id) {
        this.context = context;
        this.email_id = email_id;
        this.quantity_id = quantity_id;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);

        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.quantity_id.setText(String.valueOf(quantity_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return email_id.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView email_id, quantity_id;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            email_id = itemView.findViewById(R.id.EmailOutput);
            quantity_id = itemView.findViewById(R.id.QuantityOutput);
        }
    }
}
