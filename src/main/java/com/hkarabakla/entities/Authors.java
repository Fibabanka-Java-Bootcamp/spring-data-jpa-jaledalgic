package com.hkarabakla.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Authors {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name="book_name"))
    private List<Book> books;

    private String name;

    public Authors() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", books=" + books +
                ", name='" + name + '\'' +
                '}';
    }
}
