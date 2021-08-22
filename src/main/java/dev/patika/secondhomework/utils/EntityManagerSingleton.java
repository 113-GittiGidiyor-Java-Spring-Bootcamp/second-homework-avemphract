package dev.patika.secondhomework.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
    private static EntityManagerSingleton entityManagerSingleton;
    private EntityManagerFactory entityManagerFactory;
    private static final String PERSISTENCE_NAME="mysqlPU";
    private EntityManagerSingleton(){
        entityManagerFactory= Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
    }

    public static EntityManagerSingleton getInstance(){
        if (entityManagerSingleton==null)
            entityManagerSingleton=new EntityManagerSingleton();
        return entityManagerSingleton;
    }

    public EntityManager getEntityManager(){return entityManagerFactory.createEntityManager();}
}
