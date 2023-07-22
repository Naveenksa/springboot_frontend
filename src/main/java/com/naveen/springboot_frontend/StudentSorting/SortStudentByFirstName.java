package com.naveen.springboot_frontend.StudentSorting;

import com.naveen.springboot_frontend.entity.Student;

import java.util.Comparator;

public class SortStudentByFirstName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getFirstName().compareTo(s2.getFirstName());
    }
}
