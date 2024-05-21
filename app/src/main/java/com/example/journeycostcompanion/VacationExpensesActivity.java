package com.example.journeycostcompanion;

import android.content.Intent;
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


public class VacationExpensesActivity extends AppCompatActivity {

    private TextView totalCostTextView;


    private String vacationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_expenses);

        RecyclerView expensesRecyclerView = findViewById(R.id.expensesRecyclerView);
        expensesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.addExpenseFAB).setOnClickListener(v -> addExpense());

        TextView vacationTitleTextView = findViewById(R.id.VacationTitleText);
        totalCostTextView = findViewById(R.id.totalCostText);
        vacationId = getIntent().getStringExtra("id");
        Vacation vacation = VacationController.getVacationById(vacationId);
        List<Expense> expenses = vacation.getExpenses();

        vacationTitleTextView.setText(vacation.getDestination());
        updateTotalCost(vacation);




        ExpenseAdapter expenseAdapter = new ExpenseAdapter(expenses);
        expensesRecyclerView.setAdapter(expenseAdapter);
    }

    private void updateTotalCost(Vacation vacation) {
        double totalCost = vacation.getTotalCost();
        totalCostTextView.setText("Total expenses: \n\uD83D\uDCB0€" + totalCost);
    }

    private void addExpense() {
        Intent intent = new Intent(VacationExpensesActivity.this, AddExpenseActivity.class);
        intent.putExtra("id", vacationId);
        startActivity(intent);
    }
}