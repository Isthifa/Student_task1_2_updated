package com.isthifa.Student.Service;

import com.isthifa.Student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService{
    List<Student> findAll();
    Student save(Student student);
    Optional<Student> findByid(int id);
    void delete(int id);
}
