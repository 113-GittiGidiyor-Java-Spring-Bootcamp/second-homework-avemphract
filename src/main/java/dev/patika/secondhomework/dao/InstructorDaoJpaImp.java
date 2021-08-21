package dev.patika.secondhomework.dao;

import dev.patika.secondhomework.model.Instructor;
import dev.patika.secondhomework.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstructorDaoJpaImp implements InstructorDao{
    private EntityManager entityManager;

    public InstructorDaoJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("SELECT i FROM Instructor AS i",Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.createQuery("SELECT i FROM Instructor AS i WHERE i.id=:id", Instructor.class).setParameter("id",id).getSingleResult();
    }

    @Override @Transactional
    public Instructor save(Instructor instructor) {
        entityManager.merge(instructor);
        return instructor;
    }

    @Override
    public Instructor deleteById(int id) {
        Instructor instructor=findById(id);
        entityManager.remove(instructor);
        return instructor;
    }
}
