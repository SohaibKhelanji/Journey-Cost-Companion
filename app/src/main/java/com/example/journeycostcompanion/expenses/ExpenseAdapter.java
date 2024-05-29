package com.example.journeycostcompanion.expenses;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.R;
import com.example.journeycostcompanion.vacations.Vacation;
import com.example.journeycostcompanion.vacations.VacationController;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseViewHolder> {

    private List<Expense> expenses;

    public ExpenseAdapter(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_item, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenses.get(position);
        holder.bind(expense);

        holder.itemView.setOnLongClickListener(v -> {
            showActionDialog(v, expense);
            return true;
        });


    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    private void showActionDialog(View v, Expense expense) {
        animateView(v);
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Delete expense");
        builder.setMessage("Are you sure you want to delete this expense?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Vacation vacation = VacationController.getVacationFromExpense(expense);
            VacationController.removeExpenseFromVacation(vacation, expense);
            notifyDataSetChanged();
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.show();
    }


    private void animateView(View v) {
        v.animate()
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(100)
                .withEndAction(() -> v.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .start())
                .start();
    }
}
