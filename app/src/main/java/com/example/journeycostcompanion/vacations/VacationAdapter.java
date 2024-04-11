package com.example.journeycostcompanion.vacations;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.R;

import java.util.ArrayList;

public class VacationAdapter extends RecyclerView.Adapter<VacationViewHolder> {

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
        holder.startDateTextView.setText("\uD83D\uDEEB " + vacation.getStartDate());
        holder.endDateTextView.setText("\uD83D\uDEEC " + vacation.getEndDate());

        holder.itemView.setOnClickListener(v -> openVacation(v, vacation));
        holder.itemView.setOnLongClickListener(v ->showActionDialog(v, vacation, position));
    }

    @Override
    public int getItemCount() {
        return vacations.size();
    }

    private void openVacation(View v, Vacation vacation) {
        animateView(v);

        //TODO: Implement the open vacation functionality
        Toast.makeText(v.getContext(), "Destination: " + vacation.getDestination(), Toast.LENGTH_SHORT).show();
    }

    private boolean showActionDialog(View v, Vacation vacation, int position) {
        new AlertDialog.Builder(v.getContext())
                .setTitle("Choose an action for " + vacation.getDestination())
                .setMessage("Would you like to edit or delete this vacation?")
                .setPositiveButton("Edit\uD83D\uDEE0️ ", (dialog, which) -> {
                    //TODO: Implement the edit functionality
                })
                .setNegativeButton("Delete\uD83D\uDDD1️", (dialog, which) -> {
                    // Call the confirmation dialog method
                    showDeleteConfirmationDialog(v, vacation, position);
                })
                .setNeutralButton("Cancel", null)
                .show();

        return true; // Return true to indicate the event is consumed
    }

    private void showDeleteConfirmationDialog(View v, Vacation vacation, int position) {
        new AlertDialog.Builder(v.getContext())
                .setTitle("Confirm deletion of " + vacation.getDestination() + "  |\uD83D\uDDD1️")
                .setMessage("Are you sure you want to delete this vacation? \n\nTHIS ACTION CANNOT BE UNDONE!")
                .setPositiveButton("Yes", (dialog1, which1) -> {
                    vacations.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void animateView(View v) {
        v.animate()
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(200)
                .withEndAction(() -> v.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(200)
                        .start())
                .start();
    }
}

