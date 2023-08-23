package com.livro.java.hibernate.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.livro.java.hibernate.entity.Livro;

import java.util.List;

public class LivroService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.livro.java.hibernate.samplehibernate");
    
    public void save(Livro livro) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();

        em.close();
    }
    
    public List<Livro> list() {
        EntityManager em = emf.createEntityManager();
        
        try {
            return em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
        } finally {
            em.close();
        }
    }
}
