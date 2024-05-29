package com.example.journeycostcompanion.expenses;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.R;

public class ExpenseViewHolder extends RecyclerView.ViewHolder {

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
        double cost = expense.getCost();
        String costText = cost % 1 == 0 ? String.valueOf((int) cost) : String.valueOf(cost);
        costTextView.setText("€" + costText);
    }
}