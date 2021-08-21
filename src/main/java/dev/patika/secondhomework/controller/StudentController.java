package dev.patika.secondhomework.controller;

import dev.patika.secondhomework.model.Student;
import dev.patika.secondhomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id){
        return new ResponseEntity<>(studentService.findById(id),HttpStatus.OK);
    }
}
