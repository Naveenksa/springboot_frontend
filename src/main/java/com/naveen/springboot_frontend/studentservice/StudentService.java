package com.naveen.springboot_frontend.studentservice;

import com.naveen.springboot_frontend.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudentbyId(Long id);

    Student updatestudent(Student student);
    void deleteStuden(long id);

    List<Student> getByFirstName(String firstName);
}
