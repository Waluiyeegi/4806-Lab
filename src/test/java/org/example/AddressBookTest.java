package org.example;

import jakarta.persistence.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    @Test
    public void addBuddy() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo Joe = new BuddyInfo("Joe", "101");
        addressBook.addBuddy(Joe);
        assertEquals(1, addressBook.getSize());
        assertEquals("Joe", addressBook.getBudd(0).getName());
        assertEquals("101", addressBook.getBudd(0).getPhoneNumber());
    }

    @Test
    public void testToString() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo Joe = new BuddyInfo("Joe", "101");
        addressBook.addBuddy(Joe);
        assertEquals("Name: JoePhone Number: 101\n", addressBook.toString());
    }

    @Test
    public void performAddressBook(){
        BuddyInfo buddyInfo1 = new BuddyInfo("Caleb", "123");
        //buddyInfo1.setId(1L);

        BuddyInfo buddyInfo2 = new BuddyInfo("Bob", "133");
        //buddyInfo2.setId(2L);

        AddressBook addressBook = new AddressBook();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        addressBook.addBuddy(buddyInfo1);
        addressBook.addBuddy(buddyInfo2);

        // Persisting the product entity objects
        em.persist(addressBook);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");
        //javax.persistence.Query q = (javax.persistence.Query) em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of Addressbooks\n----------------");

        for (AddressBook b : results) {
            System.out.println(b.toString());
        }

        // Closing connection
        em.close();

        emf.close();
    }



}