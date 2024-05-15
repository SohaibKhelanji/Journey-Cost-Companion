package com.example.journeycostcompanion.vacations;


import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VacationController extends Vacation {

    static ArrayList<Vacation> vacations = new ArrayList<>();
    private static DatabaseReference database;

    public VacationController(String destination, String startDate, String endDate) {
        super(destination, startDate, endDate);
        database = FirebaseDatabase.getInstance().getReference();
    }

    public static ArrayList<Vacation> getVacations() {
        return vacations;
    }

    public static void createVacation(String destination, String startDate, String endDate) {
        Vacation vacation = new Vacation(destination, startDate, endDate);
        addVacation(vacation);
    }

    public static void editVacation(Vacation vacation, String newDestination, String newStartDate, String newEndDate) {
        Log.e("VacationController", "Vacation button clicked" + vacation.getId());

        vacation.setDestination(newDestination);
        vacation.setStartDate(newStartDate);
        vacation.setEndDate(newEndDate);
        Log.d ("VacationController", "Vacation edited" + vacation.getId());
        database.child("vacations").child(vacation.getId()).setValue(vacation);
    }

    protected static void addVacation(Vacation vacation) {
        vacations.add(vacation);
        database.child("vacations").child(vacation.getId()).setValue(vacation);
    }

    public static void removeVacation(Vacation vacation) {
        vacations.remove(vacation);
        database.child("vacations").setValue(vacations);
    }

    public static Vacation getVacationById(String id) {
        for (Vacation vacation : vacations) {
            if (vacation.getId().equals(id)) {
                return vacation;
            }
        }
        return null;
    }

    public static void fetchVacations(VacationAdapter adapter) {
        database.child("vacations").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                vacations.clear();
                for (DataSnapshot vacationSnapshot : dataSnapshot.getChildren()) {
                    // Manually extract the data from the DataSnapshot
                    String destination = vacationSnapshot.child("destination").getValue(String.class);
                    String startDate = vacationSnapshot.child("startDate").getValue(String.class);
                    String endDate = vacationSnapshot.child("endDate").getValue(String.class);

                    // Get the key of the vacation from the database
                    String id = vacationSnapshot.getKey();


                    Vacation vacation = new Vacation(destination, startDate, endDate);
                    vacation.setId(id);


                    vacations.add(vacation);
                }
                adapter.notifyDataSetChanged(); // Notify the adapter about data changes
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("VacationController", "Failed to read value.", databaseError.toException());
            }
        });
    }
}