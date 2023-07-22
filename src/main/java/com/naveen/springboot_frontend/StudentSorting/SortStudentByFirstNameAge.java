package com.naveen.springboot_frontend.StudentSorting;

import com.naveen.springboot_frontend.entity.Student;

import java.util.Comparator;

public class SortStudentByFirstNameAge implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()- o2.getAge();
    }
}
