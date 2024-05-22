package com.example.journeycostcompanion.vacations;

import com.example.journeycostcompanion.expenses.Expense;
import com.example.journeycostcompanion.interfaces.AbstractFactory;

public class VacationExpenseFactory implements AbstractFactory {

    @Override
    public Vacation createVacation(String destination, String startDate, String endDate) {
        return new Vacation(destination, startDate, endDate);
    }

    @Override
    public Expense createExpense(String name, String category, double cost) {
        return new Expense(name, category, cost);
    }
}
