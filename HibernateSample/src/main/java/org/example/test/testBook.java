// Paquete org.example.test
package org.example.test;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class testBook {
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();
        list();
        Author a1 = new Author(1L, "Marta Lopez", LocalDate.parse("1980-06-01"));
        Author a2 = new Author(2L, "Miguel de Cervantes", LocalDate.parse("1547-09-29"));
        List<Book> books=new ArrayList<>();
        books.add(new Book("1234","El quijote",a2));
        a2.setBooks(books);

        manager.getTransaction().begin();
        manager.persist(a1);
        manager.persist(a2);
        a2.setName("Miguel de Cervantes 2");
        manager.getTransaction().commit();
        manager.close();
        a2.setName("Miguel de Cervantes ");
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
