package com.naveen.springboot_frontend.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeCalculatorTest {


        @Test
        public void testCalculateAgeForValidDate() {
            String dob = "1990-01-01";
            int expectedAge = 33; // The age will depend on the current date
            int actualAge = AgeCalculator.calculateAge(dob);
            assertEquals(expectedAge, actualAge);
        }
    @Test
    public void testCalculateAgeForFutureDate() {
        // Using a future date as the date of birth
        String dob = "2040-05-15";
        int expectedAge = 0; // The age should be 0 for a future date of birth
        int actualAge = AgeCalculator.calculateAge(dob);
        assertEquals(expectedAge, actualAge);
    }
}