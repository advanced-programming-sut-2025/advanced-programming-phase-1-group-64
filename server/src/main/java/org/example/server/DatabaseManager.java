package org.example.server;

import com.game.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DatabaseManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("stardew-valley-pu");

    public static void saveUser(User user) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public static List<String> getAllUsernames() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<String> query = em.createQuery("SELECT u.username FROM User u", String.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
