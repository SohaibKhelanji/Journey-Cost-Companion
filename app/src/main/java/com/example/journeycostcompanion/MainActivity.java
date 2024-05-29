package com.example.journeycostcompanion;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.journeycostcompanion.vacations.VacationAdapter;
import com.example.journeycostcompanion.vacations.VacationController;



public class MainActivity extends AppCompatActivity {

    private RecyclerView vacationRecyclerView;
    final int numberOfColumns = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vacationRecyclerView = findViewById(R.id.vacationRecyclerView);
        FloatingActionButton addVacationButton = findViewById(R.id.editVacationButton);

        new VacationController("destination", "startDate", "endDate");
        vacationRecyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        updateRecyclerView();

        addVacationButton.setOnClickListener(v -> startAddVacationActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateRecyclerView();
    }

    private void updateRecyclerView() {
        VacationAdapter vacationAdapter = new VacationAdapter();
        vacationRecyclerView.setAdapter(vacationAdapter);
        VacationController.fetchVacations(vacationAdapter);
    }

    private void startAddVacationActivity() {
        Intent intent = new Intent(MainActivity.this, AddVacationActivity.class);
        startActivity(intent);
    }
}