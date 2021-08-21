package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class StudentDaoHibernateImp implements StudentDao{
    private EntityManager entityManager;

    @Autowired
    public StudentDaoHibernateImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student object) {
        return null;
    }

    @Override
    public Student deleteById(int id) {
        return null;
    }
}
