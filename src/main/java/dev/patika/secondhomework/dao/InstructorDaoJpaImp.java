package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Course;
import dev.patika.secondhomework.model.Instructor;
import dev.patika.secondhomework.model.Student;
import dev.patika.secondhomework.utils.EntityManagerSingleton;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDaoJpaImp implements InstructorDao{
    private EntityManager entityManager;

    public InstructorDaoJpaImp() {
        this.entityManager = EntityManagerSingleton.getInstance().getEntityManager();
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("SELECT i FROM Instructor AS i",Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.createQuery("SELECT i FROM Instructor AS i WHERE i.id=:id", Instructor.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public Instructor save(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.merge(instructor);
        entityManager.getTransaction().commit();
        return instructor;
    }

    @Override
    public Instructor deleteById(int id) {
        Instructor instructor=findById(id);
        entityManager.remove(instructor);
        return instructor;
    }

    @Override
    public Instructor enrollCourse(int instructorId, List<Integer> courseList) {
        Instructor instructor=findById(instructorId);
        List<Course> courses=entityManager.createQuery("SELECT c FROM Course As c",Course.class).getResultList();
        for (Course course:courses){
            if (courseList.contains(course.getId())) {
                instructor.getCourses().add(course);
                course.setInstructor(instructor);

                entityManager.getTransaction().begin();
                entityManager.merge(course);
                entityManager.getTransaction().commit();
            }
        }
        save(instructor);
        return null;
    }
}
