package com.example.journeycostcompanion.interfaces;

import com.example.journeycostcompanion.expenses.Expense;
import com.example.journeycostcompanion.vacations.Vacation;

public interface AbstractFactory {
    Vacation createVacation(String destination, String startDate, String endDate);
    Expense createExpense(String name, String category, double cost);
}
