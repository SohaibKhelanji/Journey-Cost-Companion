package com.example.journeycostcompanion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;

public class AddExpenseActivity extends AppCompatActivity {

    private MaterialCardView selectedCardView = null;
    private String selectedCategory = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

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

        selectedCategory = (String) selectedCardView.getTag();
    }
}
