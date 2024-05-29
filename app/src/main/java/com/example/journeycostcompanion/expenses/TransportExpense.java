package com.example.journeycostcompanion.expenses;

import com.example.journeycostcompanion.interfaces.ExpenseInterface;

public class TransportExpense extends Expense implements ExpenseInterface {
    public TransportExpense(String name, double cost) {
        super(name, cost);
        this.type = "Transport \uD83D\uDE8E";
    }

    public TransportExpense() {
        super();

    }

    @Override
    public String getCategory() {
        return "Transport \uD83D\uDE8E";
    }
}
