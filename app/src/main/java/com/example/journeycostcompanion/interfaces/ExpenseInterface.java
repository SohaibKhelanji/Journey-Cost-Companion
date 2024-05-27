package com.example.journeycostcompanion.interfaces;

public interface ExpenseInterface {
        String getCategory();
        double getCost();
        String getName();
        void setCost(double cost);
        void setName(String name);
        void setType(String type);
        String getType();
    }

