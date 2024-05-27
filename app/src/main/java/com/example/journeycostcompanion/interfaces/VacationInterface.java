package com.example.journeycostcompanion.interfaces;

import com.example.journeycostcompanion.expenses.Expense;

import java.util.List;

public interface VacationInterface {
    List<Expense> getExpenses();
    void addExpense(Expense expense);
    void removeExpense(Expense expense);
    String getTotalCost();
}
