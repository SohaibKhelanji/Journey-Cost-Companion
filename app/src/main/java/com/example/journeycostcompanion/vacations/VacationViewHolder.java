package com.example.journeycostcompanion.vacations;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.R;

public class VacationViewHolder extends RecyclerView.ViewHolder {
    public TextView destinationTextView;
    public TextView startDateTextView;
    public TextView endDateTextView;

    public VacationViewHolder(@NonNull View itemView) {
        super(itemView);
        destinationTextView = itemView.findViewById(R.id.vacationDestinationTextView);
        startDateTextView = itemView.findViewById(R.id.vacationStartDateTextView);
        endDateTextView = itemView.findViewById(R.id.vacationEndDateTextView);
    }
}