package dev.patika.secondhomework;

import dev.patika.secondhomework.model.Student;
import dev.patika.secondhomework.service.CourseService;
import dev.patika.secondhomework.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecondHomeworkAvemphractApplicationTests {


    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;


    @Test
    void contextLoads() {
        Student student =studentService.findById(1);
        student.setCourses(courseService.findAll());
        studentService.save(student);
    }

}
