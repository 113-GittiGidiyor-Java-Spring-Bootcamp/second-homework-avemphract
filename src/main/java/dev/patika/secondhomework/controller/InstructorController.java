package dev.patika.secondhomework.controller;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.patika.secondhomework.model.GuestInstructor;
import dev.patika.secondhomework.model.Instructor;
import dev.patika.secondhomework.model.RegularInstructor;
import dev.patika.secondhomework.model.Student;
import dev.patika.secondhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {
    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new  ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/instructors")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor){
        return new ResponseEntity<>(instructorService.save(instructor),HttpStatus.OK);
    }

    @PostMapping("/instructors/{id}")
    public ResponseEntity<Instructor> enrollCourse(@PathVariable int id, @RequestBody List<Integer> list){
        return new ResponseEntity<>(instructorService.enrollCourse(id,list),HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<Instructor> deleteById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id),HttpStatus.OK);
    }
}
