package org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.dto.BookDetails;

import util.JPAUtil;

public class BookDAO {
	
    public void save(BookDetails book) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
    }
    
    public BookDetails getBookById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(BookDetails.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<BookDetails> getAllBooks() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT b FROM BookDetails b";
            Query query = em.createQuery(jpql); 
            
            List<BookDetails> books = query.getResultList(); 
            return books;
        } finally {
            em.close();
        }
    }
    
    public boolean deleteBookById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            BookDetails book = em.find(BookDetails.class, id);
            if (book != null) {
                tx.begin();
                em.remove(book);
                tx.commit();
                return true;
            }
            return false;
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }
    
    public boolean updateBook(BookDetails updatedBook) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            BookDetails book = em.find(BookDetails.class, updatedBook.getId());
            if (book != null) {
                tx.begin();
                book.setName(updatedBook.getName());
                book.setAuthor_name(updatedBook.getAuthor_name());
                book.setAuthor_email(updatedBook.getAuthor_email());
                book.setPublished_date(updatedBook.getPublished_date());
                book.setGenre(updatedBook.getGenre());
                em.merge(book);
                tx.commit();
                return true;
            }
            return false;
        } finally {
            if (tx.isActive()) tx.rollback(); // optional if you want safe rollback
            em.close();
        }
    }
}

