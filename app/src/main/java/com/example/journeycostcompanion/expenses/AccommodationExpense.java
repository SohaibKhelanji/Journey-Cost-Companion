package com.example.journeycostcompanion.expenses;

import com.example.journeycostcompanion.interfaces.ExpenseInterface;

public class AccommodationExpense extends Expense implements ExpenseInterface {
    public AccommodationExpense(String name, double cost) {
        super(name, cost);
        this.type = "Accommodation \uD83D\uDECF";
    }

    public AccommodationExpense() {
        super();
    }

    @Override
    public String getCategory() {
        return "Accommodation \uD83D\uDECF️";
    }
}
