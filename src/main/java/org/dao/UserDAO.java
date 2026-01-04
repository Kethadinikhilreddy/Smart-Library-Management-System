package org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.dto.UserDetails;

import util.JPAUtil;

public class UserDAO {

    public void saveUser(UserDetails user) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public UserDetails getUserByEmail(String email) throws NoResultException {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT u FROM UserDetails u WHERE u.email = :email";
            Query query=em.createQuery(jpql);
            query.setParameter("email", email);
            
            return (UserDetails) query.getSingleResult(); 
        } finally {
            em.close();
        }
    }
    
    public boolean isEmailExists(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT u FROM UserDetails u WHERE u.email = :email";
            Query query = em.createQuery(jpql);
            query.setParameter("email", email);

            try {
                query.getSingleResult(); // If a user is found, email exists
                return true;
            } catch (javax.persistence.NoResultException e) {
                return false; // No user found, email does not exist
            }
        } finally {
            em.close();
        }
    }
    
    public boolean deleteUserById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            UserDetails user = em.find(UserDetails.class, id);
            if (user != null) {
                tx.begin();
                em.remove(user);
                tx.commit();
                return true;
            }
            return false;
        } finally {
        		if (tx.isActive()) tx.rollback();
            em.close();
        }
    }
    
    public boolean updateUser(UserDetails updatedUser) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            UserDetails user = em.find(UserDetails.class, updatedUser.getId());
            if (user != null) {
                tx.begin();
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setMobilenumber(updatedUser.getMobilenumber());
                em.merge(user);
                tx.commit();
                return true;
            }
            return false;
        } finally {
            if (tx.isActive()) tx.rollback(); // optional for learning projects
            em.close();
        }
    }

}
