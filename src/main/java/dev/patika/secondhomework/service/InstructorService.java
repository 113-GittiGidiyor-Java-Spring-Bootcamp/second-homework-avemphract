package dev.patika.secondhomework.service;

import dev.patika.secondhomework.dao.BaseDao;
import dev.patika.secondhomework.dao.InstructorDao;
import dev.patika.secondhomework.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements BaseDao<Instructor> {
    private InstructorDao instructorDao;

    @Autowired
    public InstructorService(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDao.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return instructorDao.findById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorDao.save(instructor);
    }

    @Override
    public Instructor deleteById(int id) {
        return instructorDao.deleteById(id);
    }

    public Instructor enrollCourse(int instructorId, List<Integer> courseList){
        return instructorDao.enrollCourse(instructorId,courseList);
    }
}
