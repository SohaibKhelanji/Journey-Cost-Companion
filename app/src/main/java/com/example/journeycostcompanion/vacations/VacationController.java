package com.example.journeycostcompanion.vacations;

import java.util.ArrayList;

public class VacationController extends Vacation {

    static ArrayList<Vacation> vacations = new ArrayList<>();

    public VacationController(String destination, String startDate, String endDate) {
        super(destination, startDate, endDate);
    }

    public static ArrayList<Vacation> getVacations() {
        return vacations;
    }

    public static void createVacation(String destination, String startDate, String endDate) {
        Vacation vacation = new Vacation(destination, startDate, endDate);
        addVacation(vacation);
    }

    protected static void addVacation(Vacation vacation) {
        vacations.add(vacation);
    }

    public static void removeVacation(Vacation vacation) {
        vacations.remove(vacation);
    }
}
