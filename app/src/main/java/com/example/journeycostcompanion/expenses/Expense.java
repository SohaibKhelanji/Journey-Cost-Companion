package com.example.journeycostcompanion.expenses;


import java.util.UUID;

public class Expense {

    private String id;
    private String name;
    private String category;
    private double cost;

    public Expense(String name, String category, double cost) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setCategory(category);
        setCost(cost);
    }

    public Expense() {}

    public String getName() {
        return name;
    }

    public String getCategory() { return category;}

    public double getCost() {
        return cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) { this.category = category; }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
