package com.naveen.springboot_frontend.studentRepository;

import com.naveen.springboot_frontend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
public List<Student> findByFirstName(String firstName);
}
