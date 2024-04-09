package com.example.journeycostcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.AddVacationActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.journeycostcompanion.vacations.VacationAdapter;
import com.example.journeycostcompanion.vacations.VacationController;

public class MainActivity extends AppCompatActivity {

    private RecyclerView vacationRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Temporary data (will be replaced with user input)
        VacationController.createVacation("Paris", "01/06/2024", "01/07/2024");
        VacationController.createVacation("London", "2021-07-01", "2021-07-10");

        vacationRecyclerView = findViewById(R.id.vacationRecyclerView);
        int numberOfColumns = 2;
        vacationRecyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        VacationAdapter vacationAdapter = new VacationAdapter(VacationController.getVacations());
        vacationRecyclerView.setAdapter(vacationAdapter);

        FloatingActionButton addVacationButton = findViewById(R.id.addVacationButton);
        addVacationButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddVacationActivity.class);
            startActivity(intent);
        });
    }
}