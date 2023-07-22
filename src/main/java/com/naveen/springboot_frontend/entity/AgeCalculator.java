package com.naveen.springboot_frontend.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class AgeCalculator {

    public static  int calculateAge(String dob) {
        // Define the date format used in the "dob" string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the "dob" string into a LocalDate object
        LocalDate dateOfBirth = LocalDate.parse(dob, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the age
        Period age = Period.between(dateOfBirth, currentDate);


        // Return the years from the age calculation
        return age.getYears()<=0?0:age.getYears();
    }
}
