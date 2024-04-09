package com.example.journeycostcompanion.vacations;

public class vacation {
    private String destination;
    private String startDate;
    private String endDate;

    public vacation(String destination, String startDate, String endDate) {
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

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }



}
