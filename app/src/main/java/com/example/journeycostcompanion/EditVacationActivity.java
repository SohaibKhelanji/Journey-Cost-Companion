package com.example.journeycostcompanion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.journeycostcompanion.vacations.Vacation;
import com.example.journeycostcompanion.vacations.VacationController;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class EditVacationActivity extends AppCompatActivity {

    private TextInputLayout destinationTextInputLayout;
    private TextInputLayout startDateTextInputLayout;
    private TextInputLayout endDateTextInputLayout;
    private UUID vacationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vacation);

        destinationTextInputLayout = findViewById(R.id.nameTextInputLayout);
        startDateTextInputLayout = findViewById(R.id.priceTextInputLayout);
        endDateTextInputLayout = findViewById(R.id.endDateTextInputLayout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            vacationId = UUID.fromString(extras.getString("id"));
            String destination = extras.getString("destination");
            String startDate = extras.getString("startDate");
            String endDate = extras.getString("endDate");

            Objects.requireNonNull(destinationTextInputLayout.getEditText()).setText(destination);
            Objects.requireNonNull(startDateTextInputLayout.getEditText()).setText(startDate);
            Objects.requireNonNull(endDateTextInputLayout.getEditText()).setText(endDate);
        }

        Button cancelButton = findViewById(R.id.cancelButton);
        Button editVacationButton = findViewById(R.id.editVacationButton);

        editVacationButton.setOnClickListener(this::editVacation);
        cancelButton.setOnClickListener(v -> finish());
    }

    public void editVacation(View view) {
        String newDestination = Objects.requireNonNull(destinationTextInputLayout.getEditText()).getText().toString();
        String newStartDate = Objects.requireNonNull(startDateTextInputLayout.getEditText()).getText().toString();
        String newEndDate = Objects.requireNonNull(endDateTextInputLayout.getEditText()).getText().toString();

        List<Integer> validationCodes = isValidInput(newDestination, newStartDate, newEndDate);

        for (int validationCode : validationCodes) {
            switch (validationCode) {
                case 1:
                    destinationTextInputLayout.setError("Invalid destination");
                    break;
                case 2:
                    startDateTextInputLayout.setError("Invalid date format. Required: dd/mm/yyyy");
                    break;
                case 3:
                    endDateTextInputLayout.setError("Invalid date format. Required: dd/mm/yyyy");
                    break;
            }
        }

        if (validationCodes.isEmpty()) {
            Vacation vacation = VacationController.getVacationById(vacationId);
            if (vacation != null) {
                VacationController.editVacation(vacation, newDestination, newStartDate, newEndDate);
            }
            finish();
        }
    }

    private List<Integer> isValidInput(String destination, String startDate, String endDate) {
        List<Integer> validationCodes = new ArrayList<>();

        // Check if destination is not empty
        if (destination.isEmpty()) {
            validationCodes.add(1);
        }

        // Regular expression for date format dd/mm/yyyy
        String datePattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$";

        // Check if startDate and endDate match the date pattern
        if (!startDate.matches(datePattern)) {
            validationCodes.add(2);
        }

        if (!endDate.matches(datePattern)) {
            validationCodes.add(3);
        }

        return validationCodes;
    }
}