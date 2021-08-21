package dev.patika.secondhomework.controller;

import dev.patika.secondhomework.model.Course;
import dev.patika.secondhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course),HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }

}
