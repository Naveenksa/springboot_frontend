package com.naveen.springboot_frontend.studentservice;

import com.naveen.springboot_frontend.entity.Student;
import com.naveen.springboot_frontend.studentRepository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentbyId(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student updatestudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStuden(long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getByFirstName(String firstName) {
        return studentRepo.findByFirstName(firstName);
    }
}