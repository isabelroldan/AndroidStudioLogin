// Paquete org.example.test
package org.example.test;

import org.example.model.Author;
import org.example.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class testContact {
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();
        list();
        Author a1 = new Author(1L, "Marta Lopez", LocalDate.parse("1980-06-01"));
        Author a2 = new Author(2L, "Miguel de Cervantes", LocalDate.parse("1547-09-29"));
        a1.setContact(new Contact(1L,"pcmarta@iesfranciscodelosrios.es","444"));

        manager.getTransaction().begin();
        manager.persist(a1);
        manager.persist(a2);
        manager.getTransaction().commit();
        manager.close();
        list(); // Muestra la lista actualizada
    }

    public static void list() {
        List<Author> authors = manager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        System.out.println("Autores: " + authors.size());
        for (Author author : authors) {
            System.out.println(author);
        }
    }
}
