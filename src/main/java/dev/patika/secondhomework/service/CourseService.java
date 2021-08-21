package dev.patika.secondhomework.service;

import dev.patika.secondhomework.dao.BaseDao;
import dev.patika.secondhomework.dao.CourseDao;
import dev.patika.secondhomework.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements BaseDao<Course> {
    private CourseDao courseDao;

    @Autowired
    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseDao.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public Course deleteById(int id) {
        return courseDao.deleteById(id);
    }
}
