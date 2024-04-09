package com.example.journeycostcompanion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.journeycostcompanion.vacations.VacationController;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Objects;

public class AddVacationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacation);

        Button cancelButton = findViewById(R.id.cancelButton);
        Button addVacationButton = findViewById(R.id.addVacationButton);

        addVacationButton.setOnClickListener(this::addVacation);
        cancelButton.setOnClickListener(v -> finish());
    }

    public void addVacation(View view) {
        Log.d("AddVacationActivity", "Add Vacation Button Clicked");
        TextInputLayout destinationTextInputLayout = findViewById(R.id.destinationTextInputLayout);
        TextInputLayout startDateTextInputLayout = findViewById(R.id.startDateTextInputLayout);
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

        Log.d("AddVacationActivity", "Destination: " + destination);
        Log.d("AddVacationActivity", "Start Date: " + startDate);
        Log.d("AddVacationActivity", "End Date: " + endDate);

        VacationController.createVacation(destination, startDate, endDate);

        finish();
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


}
