package com.example.journeycostcompanion.vacations;

import com.example.journeycostcompanion.expenses.Expense;
import com.example.journeycostcompanion.interfaces.VacationInterface;
import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vacation implements VacationInterface {

    private String id;
    private String destination;
    private String startDate;
    private String endDate;
    private List<Expense> expenses = new ArrayList<>();

    public Vacation(String destination, String startDate, String endDate) {
        this.id = UUID.randomUUID().toString();

        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }

    @Exclude
    public String getTotalCost() {
        double totalCost = 0;
        for (Expense expense : getExpenses()) {
            totalCost += expense.getCost();
        }
        return String.format("%.2f", totalCost);
    }

}