package com.example.journeycostcompanion;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.journeycostcompanion.vacations.VacationAdapter;
import com.example.journeycostcompanion.vacations.VacationController;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private RecyclerView vacationRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("messages").push().setValue("Hello World");

        vacationRecyclerView = findViewById(R.id.vacationRecyclerView);
        FloatingActionButton addVacationButton = findViewById(R.id.editVacationButton);

        // Initialize VacationController
        new VacationController("destination", "startDate", "endDate");

        final int numberOfColumns = 2;
        vacationRecyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        updateRecyclerView();

        addVacationButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddVacationActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateRecyclerView();
    }

    private void updateRecyclerView() {
        VacationAdapter vacationAdapter = new VacationAdapter();
        vacationRecyclerView.setAdapter(vacationAdapter);
        VacationController.fetchVacations(vacationAdapter); // Fetch vacations and update the RecyclerView
    }
}