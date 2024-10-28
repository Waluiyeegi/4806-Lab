package org.example;

import jakarta.persistence.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    @Test
    public void getName() {
        BuddyInfo Joe = new BuddyInfo("Joe", "101");
        assertEquals("Joe", Joe.getName());
    }

    @Test
    public void getPhoneNumber() {
        BuddyInfo Joe = new BuddyInfo("Joe", "101");
        assertEquals("101", Joe.getPhoneNumber());
    }

    @Test
    public void performBuddyInfo(){
        BuddyInfo buddyInfo1 = new BuddyInfo("Caleb", "123");
        //buddyInfo1.setId(1L);

        BuddyInfo buddyInfo2 = new BuddyInfo("Bob", "133");
        //buddyInfo2.setId(2L);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddyInfo1);
        em.persist(buddyInfo2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
        //javax.persistence.Query q = (javax.persistence.Query) em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of BuddyInfos\n----------------");

        for (BuddyInfo b : results) {
            System.out.println(" id is " + b.getId() + " Name is " + b.getName() + " Phone Number is " + b.getPhoneNumber());
        }

        // Closing connection
        em.close();

        emf.close();
    }
}