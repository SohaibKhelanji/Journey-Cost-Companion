package com.example.journeycostcompanion;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class AddExpenseActivity extends AppCompatActivity {

    private MaterialCardView selectedCardView = null;
    private String selectedCategory = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> finish());

        Button addExpenseButton = findViewById(R.id.addExpenseButton);
        addExpenseButton.setOnClickListener(v -> addExpense());

        MaterialCardView accommodationCard = findViewById(R.id.accommodationCardView);
        MaterialCardView foodCard = findViewById(R.id.foodCardView);
        MaterialCardView transportCard = findViewById(R.id.transportCardView);
        MaterialCardView activitiesCard = findViewById(R.id.activitiesCardView);

        accommodationCard.setTag("Accommodation");
        foodCard.setTag("Food");
        transportCard.setTag("Transport");
        activitiesCard.setTag("Activities");

        accommodationCard.setOnClickListener(v -> onCategoryCardClick(accommodationCard));
        foodCard.setOnClickListener(v -> onCategoryCardClick(foodCard));
        transportCard.setOnClickListener(v -> onCategoryCardClick(transportCard));
        activitiesCard.setOnClickListener(v -> onCategoryCardClick(activitiesCard));
    }


    public void onCategoryCardClick(MaterialCardView cardView) {
        if (selectedCardView != null) {
            selectedCardView.setStrokeWidth(0);
            selectedCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.background_color)); // Reset the background color of the previously selected card
        }
        selectedCardView = cardView;
        selectedCardView.setStrokeWidth(3);
        selectedCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.selected_color)); // Set the background color of the selected card to your primary color

        TextView categoryTextView = (TextView) selectedCardView.getChildAt(0);
        this.selectedCategory = categoryTextView.getText().toString();
    }

    private void addExpense() {
        TextInputLayout expenseNameTextInputLayout = findViewById(R.id.nameTextInputLayout);
        TextInputLayout expenseCostTextInputLayout = findViewById(R.id.costTextInputLayout);

        System.out.println("Expense Name: " + Objects.requireNonNull(expenseNameTextInputLayout.getEditText()).getText().toString());
        System.out.println("Expense Cost: " + Objects.requireNonNull(expenseCostTextInputLayout.getEditText()).getText().toString());
        System.out.println("Category: " + selectedCategory);
    }
}
