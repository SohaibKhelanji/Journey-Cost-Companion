package com.example.journeycostcompanion.expenses;


public class Expense {
    private String name;
    private String category;
    private double cost;

    public Expense(String name, String category, double cost) {
        setName(name);
        setCategory(category);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    public String getCategory() { return category;}

    public double getCost() {
        return cost;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) { this.category = category; }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
