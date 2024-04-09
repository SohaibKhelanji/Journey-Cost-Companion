package com.example.journeycostcompanion.vacations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.R;

import java.util.ArrayList;

public class VacationAdapter extends RecyclerView.Adapter<VacationAdapter.VacationViewHolder> {

    private ArrayList<Vacation> vacations;

    public VacationAdapter(ArrayList<Vacation> vacations) {
        this.vacations = vacations;
    }

    @NonNull
    @Override
    public VacationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vacation_item, parent, false);
        return new VacationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VacationViewHolder holder, int position) {
        Vacation vacation = vacations.get(position);
        holder.destinationTextView.setText(vacation.getDestination());
        holder.datesTextView.setText(vacation.getStartDate() + " - " + vacation.getEndDate());
    }

    @Override
    public int getItemCount() {
        return vacations.size();
    }

    public static class VacationViewHolder extends RecyclerView.ViewHolder {
        TextView destinationTextView;
        TextView datesTextView;

        public VacationViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationTextView = itemView.findViewById(R.id.vacationDestinationTextView);
            datesTextView = itemView.findViewById(R.id.vacationDatesTextView);
        }
    }
}
