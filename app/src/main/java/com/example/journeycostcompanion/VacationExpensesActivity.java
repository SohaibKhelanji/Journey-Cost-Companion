package com.example.journeycostcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.expenses.ExpenseAdapter;
import com.example.journeycostcompanion.vacations.Vacation;
import com.example.journeycostcompanion.vacations.VacationController;



public class VacationExpensesActivity extends AppCompatActivity {

    private TextView totalCostTextView;


    private String vacationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_expenses);

        RecyclerView expensesRecyclerView = findViewById(R.id.expensesRecyclerView);
        expensesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.addExpenseFAB).setOnClickListener(v -> addExpenseFAB());
        updateUI();

    }

    private void updateTotalCost(Vacation vacation) {
        String totalCost = vacation.getTotalCost();
        totalCostTextView.setText("Total expenses: \uD83D\uDCB0€" + totalCost);
    }

    private void addExpenseFAB() {
        Intent intent = new Intent(VacationExpensesActivity.this, AddExpenseActivity.class);
        intent.putExtra("id", vacationId);
        startActivity(intent);
    }

    private void updateUI() {
        vacationId = getIntent().getStringExtra("id");
        Vacation vacation = VacationController.getVacationById(vacationId);
        TextView vacationTitleTextView = findViewById(R.id.VacationTitleText);
        totalCostTextView = findViewById(R.id.totalCostText);
        String destination = vacation.getDestination();
        vacationTitleTextView.setText(destination);
        ExpenseAdapter expenseAdapter = new ExpenseAdapter(vacation.getExpenses());
        RecyclerView expensesRecyclerView = findViewById(R.id.expensesRecyclerView);
        expensesRecyclerView.setAdapter(expenseAdapter);
        updateTotalCost(vacation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateUI();
    }
}