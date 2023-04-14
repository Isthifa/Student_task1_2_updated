package com.isthifa.Student.rest;

import com.isthifa.Student.Service.StudentService;
import com.isthifa.Student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentSer) {
        studentService = studentSer;
    }

    @GetMapping("/student/list")
    public List<Student> findall() {
        return studentService.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student findByid(@PathVariable int studentId) {
        List<Student> students = studentService.findAll();
        if (studentId < 0 || studentId > students.size()) {
            throw new RuntimeException("Student Id not found " + studentId);
        }
        return students.get(studentId);
    }

    @PostMapping("/student/add")
    public String save(@RequestBody Student student) {
        Student student1 = studentService.save(student);
        return "Student saved " + student1.getId();
    }

    @PutMapping("/student/update")
    public String update(@RequestBody Student student) {
        Student student1 = studentService.save(student);
        return "Student updated " + student1.getId();
    }

    @DeleteMapping("/student/{studentId}")
    public String Delete(@PathVariable int studentId) {
        List<Student> students = studentService.findAll();
        if (studentId <= 0 || studentId > students.size()) {
            throw new RuntimeException("Invalid id");
        } else {
            studentService.delete(studentId);
        }
        return "Student deleted" + studentId;
    }
}
