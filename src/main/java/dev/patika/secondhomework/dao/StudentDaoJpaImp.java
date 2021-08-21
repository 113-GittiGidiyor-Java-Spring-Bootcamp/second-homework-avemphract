package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDaoJpaImp implements StudentDao{
    private EntityManager entityManager;

    @Autowired
    public StudentDaoJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student AS s",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.createQuery("SELECT s FROM Student AS s WHERE s.id=:id",Student.class).setParameter("id",id).getSingleResult();
    }

    @Override @Transactional
    public Student save(Student student) {
        entityManager.merge(student);
        return student;
    }

    @Override
    public Student deleteById(int id) {
        Student student=findById(id);
        entityManager.remove(student);
        return student;
    }
}
