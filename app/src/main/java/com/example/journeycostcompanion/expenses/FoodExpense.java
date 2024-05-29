package com.example.journeycostcompanion.expenses;

import com.example.journeycostcompanion.interfaces.ExpenseInterface;

public class FoodExpense extends Expense implements ExpenseInterface {
    public FoodExpense(String name, double cost) {
        super(name, cost);
        this.type = "Food \uD83C\uDF5B";
    }

    public FoodExpense() {
        super();
    }

    @Override
    public String getCategory() {
        return "Food \uD83C\uDF5B";
    }
}