package com.example.journeycostcompanion.vacations;

import com.example.journeycostcompanion.expenses.AccommodationExpense;
import com.example.journeycostcompanion.expenses.ActivitiesExpense;
import com.example.journeycostcompanion.expenses.Expense;
import com.example.journeycostcompanion.expenses.FoodExpense;
import com.example.journeycostcompanion.expenses.TransportExpense;
import com.example.journeycostcompanion.interfaces.AbstractFactory;


public class VacationExpenseFactory implements AbstractFactory {

    @Override
    public Vacation createVacation(String destination, String startDate, String endDate) {
        return new Vacation(destination, startDate, endDate);
    }

    @Override
    public Expense createExpense(String name, String category, double cost) {
        switch (category) {
            case "Food 🍛":
                return new FoodExpense(name, cost);
            case "Transport \uD83D\uDE8E":
                return new TransportExpense(name, cost);
            case "Accommodation \uD83D\uDECF️":
                return new AccommodationExpense(name, cost);
            case "Activities \uD83C\uDFA5":
                return new ActivitiesExpense(name, cost);
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }
}