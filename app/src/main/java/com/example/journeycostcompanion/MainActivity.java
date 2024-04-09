package com.example.journeycostcompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.journeycostcompanion.vacations.VacationAdapter;
import com.example.journeycostcompanion.vacations.VacationController;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Temporary data (will be replaced with user input)
        VacationController.createVacation("Paris", "2021-06-01", "2021-06-10");
        VacationController.createVacation("London", "2021-07-01", "2021-07-10");

        RecyclerView vacationRecyclerView = findViewById(R.id.vacationRecyclerView);
        vacationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        VacationAdapter vacationAdapter = new VacationAdapter(VacationController.getVacations());
        vacationRecyclerView.setAdapter(vacationAdapter);
    }
}