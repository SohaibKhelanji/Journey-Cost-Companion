package com.example.journeycostcompanion.vacations;


import java.util.ArrayList;
import java.util.UUID;

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

    public static void editVacation(Vacation vacation, String newDestination, String newStartDate, String newEndDate) {
        vacation.setDestination(newDestination);
        vacation.setStartDate(newStartDate);
        vacation.setEndDate(newEndDate);
    }

    protected static void addVacation(Vacation vacation) {
        vacations.add(vacation);
    }

    public static void removeVacation(Vacation vacation) {
        vacations.remove(vacation);
    }

    public static Vacation getVacationById(UUID id) {
        for (Vacation vacation : vacations) {
            if (vacation.getId().equals(id)) {
                return vacation;
            }
        }
        return null;
    }
}