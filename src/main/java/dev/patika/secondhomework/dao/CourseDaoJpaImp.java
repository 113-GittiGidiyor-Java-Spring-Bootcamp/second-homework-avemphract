package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDaoJpaImp implements CourseDao{
    private EntityManager entityManager;

    @Autowired
    public CourseDaoJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("SELECT c FROM Course AS c",Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.createQuery("SELECT c FROM Course AS c WHERE c.id=:id",Course.class).setParameter("id",id).getSingleResult();
    }

    @Override @Transactional
    public Course save(Course course) {
        entityManager.merge(course);
        return course;
    }

    @Override
    public Course deleteById(int id) {
        Course course=findById(id);
        entityManager.remove(course);
        return course;
    }
}
