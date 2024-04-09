package com.example.journeycostcompanion;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeycostcompanion.vacations.Vacation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.journeycostcompanion.vacations.VacationAdapter;
import com.example.journeycostcompanion.vacations.VacationController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView vacationRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vacationRecyclerView = findViewById(R.id.vacationRecyclerView);
        FloatingActionButton addVacationButton = findViewById(R.id.addVacationButton);

        //Temporary data (will be replaced with user input)
        VacationController.createVacation("Paris \uD83C\uDDEB\uD83C\uDDF7", "01/06/2019", "01/07/2019");
        VacationController.createVacation("London \uD83C\uDDEC\uD83C\uDDE7", "01/07/2022", "10/07/2022");
        VacationController.createVacation("New York \uD83C\uDDFA\uD83C\uDDF8", "01/08/2024", "10/08/2024");

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
        ArrayList<Vacation> vacations = VacationController.getVacations();
        VacationAdapter vacationAdapter = new VacationAdapter(vacations);
        vacationRecyclerView.setAdapter(vacationAdapter);
    }
}