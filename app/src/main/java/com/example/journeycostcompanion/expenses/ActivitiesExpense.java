package com.example.journeycostcompanion.expenses;

import com.example.journeycostcompanion.interfaces.ExpenseInterface;

public class ActivitiesExpense extends Expense implements ExpenseInterface {
    public ActivitiesExpense(String name, double cost) {
        super(name, cost);
        this.type = "Activities \uD83C\uDFA5";
    }

    public ActivitiesExpense() {
        super();
    }

    @Override
    public String getCategory() {
        return "Activities \uD83C\uDFA5";
    }
}
