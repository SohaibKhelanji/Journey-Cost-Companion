package com.example.journeycostcompanion.vacations;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.EditVacationActivity;
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
        holder.itemView.setOnLongClickListener(v ->showActionDialog(v, vacation));
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

    private boolean showActionDialog(View v, Vacation vacation) {
        new AlertDialog.Builder(v.getContext())
                .setTitle("Choose an action for " + vacation.getDestination())
                .setMessage("Would you like to edit or delete this vacation?")
                .setPositiveButton("Edit\uD83D\uDEE0️ ", (dialog, which) -> editVacation(v, vacation))
                .setNegativeButton("Delete\uD83D\uDDD1️", (dialog, which) -> showDeleteConfirmationDialog(v, vacation))
                .setNeutralButton("Cancel", null)
                .show();

        return true; // Needs to return true to indicate the event is consumed (done)
    }

    private void showDeleteConfirmationDialog(View v, Vacation vacation) {
        new AlertDialog.Builder(v.getContext())
                .setTitle("Confirm deletion of " + vacation.getDestination() + "  |\uD83D\uDDD1️")
                .setMessage("Are you sure you want to delete this vacation? \n\nTHIS ACTION CANNOT BE UNDONE!")
                .setPositiveButton("Yes", (dialog, which) -> {
                    int position = vacations.indexOf(vacation);
                    VacationController.removeVacation(vacation);
                    notifyItemRemoved(position);
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void editVacation(View v, Vacation vacation) {
        Intent intent = new Intent(v.getContext(), EditVacationActivity.class);
        intent.putExtra("id", vacation.getId().toString());
        intent.putExtra("destination", vacation.getDestination());
        intent.putExtra("startDate", vacation.getStartDate());
        intent.putExtra("endDate", vacation.getEndDate());
        v.getContext().startActivity(intent);
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