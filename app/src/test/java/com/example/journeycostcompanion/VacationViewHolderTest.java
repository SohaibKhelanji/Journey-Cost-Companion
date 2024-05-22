package com.example.journeycostcompanion;

import android.view.View;
import android.widget.TextView;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.journeycostcompanion.vacations.VacationViewHolder;


public class VacationViewHolderTest {

    @Mock
    private View mockView;

    @Mock
    private TextView mockDestinationTextView;

    @Mock
    private TextView mockStartDateTextView;

    @Mock
    private TextView mockEndDateTextView;

    private VacationViewHolder vacationViewHolder;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockView.findViewById(R.id.vacationDestinationTextView)).thenReturn(mockDestinationTextView);
        when(mockView.findViewById(R.id.vacationStartDateTextView)).thenReturn(mockStartDateTextView);
        when(mockView.findViewById(R.id.vacationEndDateTextView)).thenReturn(mockEndDateTextView);
        vacationViewHolder = new VacationViewHolder(mockView);
    }

    @Test
    public void testViewHolderNotNull() {
        assertNotNull(vacationViewHolder);
    }

    @Test
    public void testTextViewsNotNull() {
        assertNotNull(vacationViewHolder.destinationTextView);
        assertNotNull(vacationViewHolder.startDateTextView);
        assertNotNull(vacationViewHolder.endDateTextView);
    }

    @Test
    public void testTextViewsDisplayCorrectText() {
        String testDestinationText = "Test Destination";
        String testStartDateText = "Test Start Date";
        String testEndDateText = "Test End Date";

        when(mockDestinationTextView.getText()).thenReturn(testDestinationText);
        when(mockStartDateTextView.getText()).thenReturn(testStartDateText);
        when(mockEndDateTextView.getText()).thenReturn(testEndDateText);

        assertEquals(testDestinationText, vacationViewHolder.destinationTextView.getText());
        assertEquals(testStartDateText, vacationViewHolder.startDateTextView.getText());
        assertEquals(testEndDateText, vacationViewHolder.endDateTextView.getText());
    }
}