package com.example.journeycostcompanion.vacations;

import java.util.UUID;

public class Vacation {

    private UUID id;
    private String destination;
    private String startDate;
    private String endDate;

    public Vacation(String destination, String startDate, String endDate) {
        this.id = UUID.randomUUID();
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
}