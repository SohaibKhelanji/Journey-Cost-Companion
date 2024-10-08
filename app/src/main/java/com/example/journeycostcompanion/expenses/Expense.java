package com.example.journeycostcompanion.expenses;


import com.example.journeycostcompanion.interfaces.ExpenseInterface;

import java.util.UUID;

public abstract class Expense implements ExpenseInterface {

    private String id;
    private String name;
    private double cost;
    protected String type;

    protected Expense(String name, double cost) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setCost(cost);
    }

    protected Expense() {}

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

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

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setType(String type) {
        this.type = type;
    }

}
