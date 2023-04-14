package com.isthifa.Student.Service;

import com.isthifa.Student.dao.StudentRepo;
import com.isthifa.Student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepo studentRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRep)
    {
        studentRepo=studentRep;
    }
    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Optional<Student> findByid(int id) {
        Optional<Student> student=studentRepo.findById(id);
        return student;
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);

    }
}
