package dev.patika.secondhomework.service;

import dev.patika.secondhomework.dao.StudentDao;
import dev.patika.secondhomework.dao.StudentDaoJpaImp;
import dev.patika.secondhomework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements BaseService<Student> {
    private StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("studentDaoJpaImp") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student deleteById(int id) {
        return studentDao.deleteById(id);
    }
}
