package com.example.journeycostcompanion;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.expenses.Expense;
import com.example.journeycostcompanion.expenses.ExpenseAdapter;
import com.example.journeycostcompanion.vacations.Vacation;
import com.example.journeycostcompanion.vacations.VacationController;

import java.util.List;
import java.util.UUID;

public class VacationExpensesActivity extends AppCompatActivity {

    private TextView totalCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_expenses);

        RecyclerView expensesRecyclerView = findViewById(R.id.expensesRecyclerView);
        expensesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextView vacationTitleTextView = findViewById(R.id.VacationTitleText);
        totalCostTextView = findViewById(R.id.totalCostText);
        String vacationId = getIntent().getStringExtra("id");
        Vacation vacation = VacationController.getVacationById(UUID.fromString(vacationId));
        List<Expense> expenses = vacation.getExpenses();

        vacationTitleTextView.setText(vacation.getDestination());
        updateTotalCost(vacation);




        ExpenseAdapter expenseAdapter = new ExpenseAdapter(expenses);
        expensesRecyclerView.setAdapter(expenseAdapter);
    }

    private void updateTotalCost(Vacation vacation) {
        double totalCost = vacation.getTotalCost();
        totalCostTextView.setText("\uD83D\uDCB0Total: €" + totalCost);
    }
}