package com.example.journeycostcompanion.vacations;

import com.example.journeycostcompanion.expenses.Expense;

import java.util.ArrayList;

public class Vacation {
    private String destination;
    private String startDate;
    private String endDate;

    private ArrayList<Expense> expenses = new ArrayList<>();

    public Vacation(String destination, String startDate, String endDate) {
        setDestination(destination);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public String getDestination() {
        return destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
