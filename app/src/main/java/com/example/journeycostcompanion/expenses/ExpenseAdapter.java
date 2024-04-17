package com.example.journeycostcompanion.expenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.R;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

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
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    static class ExpenseViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView categoryTextView;
        private TextView costTextView;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.expenseNameTextView);
            categoryTextView = itemView.findViewById(R.id.expenseCategoryTextView);
            costTextView = itemView.findViewById(R.id.expenseCostTextView);
        }

        public void bind(Expense expense) {
            nameTextView.setText(expense.getName());
            categoryTextView.setText(expense.getCategory());
            costTextView.setText("€" + expense.getCost());
        }
    }
}
