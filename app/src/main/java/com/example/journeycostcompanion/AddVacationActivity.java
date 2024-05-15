package com.example.journeycostcompanion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.journeycostcompanion.vacations.VacationController;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddVacationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacation);

        Button cancelButton = findViewById(R.id.cancelButton);
        Button addVacationButton = findViewById(R.id.editVacationButton);

        addVacationButton.setOnClickListener(this::addVacation);
        cancelButton.setOnClickListener(v -> finish());
    }

    public void addVacation(View view) {
        Log.d("AddVacationActivity", "Add Vacation Button Clicked");
        TextInputLayout destinationTextInputLayout = findViewById(R.id.nameTextInputLayout);
        TextInputLayout startDateTextInputLayout = findViewById(R.id.priceTextInputLayout);
        TextInputLayout endDateTextInputLayout = findViewById(R.id.endDateTextInputLayout);

        ArrayList<TextInputLayout> textInputLayouts = new ArrayList<>();
        textInputLayouts.add(destinationTextInputLayout);
        textInputLayouts.add(startDateTextInputLayout);
        textInputLayouts.add(endDateTextInputLayout);

        if (!validateFields(textInputLayouts)) {
            return;
        }

        String destination = Objects.requireNonNull(destinationTextInputLayout.getEditText()).getText().toString();
        String startDate = Objects.requireNonNull(startDateTextInputLayout.getEditText()).getText().toString();
        String endDate = Objects.requireNonNull(endDateTextInputLayout.getEditText()).getText().toString();

        List<Integer> validationCodes = isValidInput(destination, startDate, endDate);

        for (int validationCode : validationCodes) {
            switch (validationCode) {
                case 1:
                    destinationTextInputLayout.setError("Invalid destination");
                    break;
                case 2:
                    startDateTextInputLayout.setError("Invalid date or format. (Required format: dd/mm/yyyy)");
                    break;
                case 3:
                    endDateTextInputLayout.setError("Invalid date or format. (Required format: dd/mm/yyyy)");
                    break;
            }
        }

        if (validationCodes.isEmpty()) {
            Log.d("AddVacationActivity", "Destination: " + destination);
            Log.d("AddVacationActivity", "Start Date: " + startDate);
            Log.d("AddVacationActivity", "End Date: " + endDate);

            VacationController.createVacation(destination, startDate, endDate);
            Toast.makeText(this, "Vacation added successfully", Toast.LENGTH_SHORT).show();
            finish();

        }
    }

    private boolean validateFields(ArrayList<TextInputLayout> textInputLayouts) {
        boolean isValid = true;
        for (TextInputLayout textInputLayout : textInputLayouts) {
            if (Objects.requireNonNull(textInputLayout.getEditText()).getText().toString().isEmpty()) {
                textInputLayout.setError("Field cannot be empty");
                isValid = false;
            } else {
                textInputLayout.setError(null);
            }
        }
        return isValid;
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