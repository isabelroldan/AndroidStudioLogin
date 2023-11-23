package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CONTACT")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    private Long id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PHONE")
    private String phone;
     public Contact(){
     }

    @OneToOne(mappedBy = "contact",fetch =FetchType.LAZY)
     private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Contact(Long id, String email, String phone,Author author) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.author=author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
