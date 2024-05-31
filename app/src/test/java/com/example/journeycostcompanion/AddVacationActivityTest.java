package com.example.journeycostcompanion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddVacationActivityTest {

    @Mock
    AddVacationActivity addVacationActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidInput() {
        when(addVacationActivity.isValidInput("Destination", "01/01/2024", "02/01/2024")).thenReturn(new ArrayList<>());
        List<Integer> validationCodes = addVacationActivity.isValidInput("Destination", "01/01/2024", "02/01/2024");
        assertEquals(0, validationCodes.size());
    }

    @Test
    public void testEmptyDestination() {
        when(addVacationActivity.isValidInput("", "01/01/2024", "02/01/2024")).thenReturn(Collections.singletonList(1));
        List<Integer> validationCodes = addVacationActivity.isValidInput("", "01/01/2024", "02/01/2024");
        assertEquals(1, validationCodes.size());
        assertEquals(Integer.valueOf(1), validationCodes.get(0));
    }

    @Test
    public void testInvalidStartDate() {
        when(addVacationActivity.isValidInput("Destination", "32/01/2024", "02/01/2024")).thenReturn(Collections.singletonList(2));
        List<Integer> validationCodes = addVacationActivity.isValidInput("Destination", "32/01/2024", "02/01/2024");
        assertEquals(1, validationCodes.size());
        assertEquals(Integer.valueOf(2), validationCodes.get(0));
    }

    @Test
    public void testInvalidEndDate() {
        when(addVacationActivity.isValidInput("Destination", "01/01/2024", "02/29/2024")).thenReturn(Collections.singletonList(3));
        List<Integer> validationCodes = addVacationActivity.isValidInput("Destination", "01/01/2024", "02/29/2024");
        assertEquals(1, validationCodes.size());
        assertEquals(Integer.valueOf(3), validationCodes.get(0));
    }

    @Test
    public void testAllFieldsEmpty() {
        when(addVacationActivity.isValidInput("", "", "")).thenReturn(Arrays.asList(1, 2, 3));
        List<Integer> validationCodes = addVacationActivity.isValidInput("", "", "");
        assertEquals(3, validationCodes.size());
        assertEquals(Integer.valueOf(1), validationCodes.get(0));
        assertEquals(Integer.valueOf(2), validationCodes.get(1));
        assertEquals(Integer.valueOf(3), validationCodes.get(2));
    }
}
