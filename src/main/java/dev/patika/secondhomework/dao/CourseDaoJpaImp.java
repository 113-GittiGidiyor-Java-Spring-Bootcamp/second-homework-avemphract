package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Course;
import dev.patika.secondhomework.utils.EntityManagerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDaoJpaImp implements CourseDao{
    private EntityManager entityManager;

    @Autowired
    public CourseDaoJpaImp() {
        this.entityManager = EntityManagerSingleton.getInstance().getEntityManager();
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("SELECT c FROM Course AS c",Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.createQuery("SELECT c FROM Course AS c WHERE c.id=:id",Course.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public Course save(Course course) {
        entityManager.getTransaction().begin();
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        return course;
    }

    @Override
    public Course deleteById(int id) {
        Course course=findById(id);
        entityManager.remove(course);
        return course;
    }
}
