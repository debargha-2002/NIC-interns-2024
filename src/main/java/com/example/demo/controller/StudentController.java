package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Get all Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentRepository.getAllStudents();
        return ResponseEntity.ok(student);
    }

    // /students/453845808
    // Get student by ID
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentRepository.getStudenyById(id);
        return ResponseEntity.ok(student);
    }

    // Create Student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student student1 = studentRepository.saveStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    // Update Student
    @PutMapping
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,
                                                 @RequestBody Student student) {
        Student student1 = studentRepository.updateStudent(id, student);
        return ResponseEntity.ok(student1);
    }

    // Delete student
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentRepository.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
