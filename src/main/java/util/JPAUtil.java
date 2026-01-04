package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("library_management_system_using_hibernate_jsp");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}

