package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Course;
import dev.patika.secondhomework.model.Student;
import dev.patika.secondhomework.utils.EntityManagerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDaoJpaImp implements StudentDao{
    private EntityManager entityManager;

    @Autowired
    public StudentDaoJpaImp() {
        this.entityManager = EntityManagerSingleton.getInstance().getEntityManager();
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student AS s",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.createQuery("SELECT s FROM Student AS s WHERE s.id=:id",Student.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public Student save(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public Student deleteById(int id) {
        Student student=findById(id);
        entityManager.remove(student);
        return student;
    }

    @Override
    public Student enrollCourse(int studentId, List<Integer> coursesId) {
        Student student=findById(studentId);
        List<Course> courses=entityManager.createQuery("SELECT c FROM Course As c",Course.class).getResultList();
        for (Course course:courses){
            if (coursesId.contains(course.getId()))
                student.getCourses().add(course);
        }
        save(student);
        return student;
    }
}
