package com.hkarabakla.services;

import com.hkarabakla.entities.Authors;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.AuthorRepo;
import com.hkarabakla.repositories.BooksRepo;
import com.hkarabakla.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

@Component
public class BookService {
    private final BooksRepo booksRepo;
    private final AuthorRepo authorRepo;
    private final CategoryRepo categoryRepo;

    public BookService(BooksRepo booksRepo, AuthorRepo authorRepo, CategoryRepo categoryRepo) {
        this.booksRepo = booksRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
    }

    public void booksOperation(){
        Book b1=new Book();
        Book b2=new Book();
        Book b3=new Book();


        Authors a1=new Authors();
        a1.setName("Grange");
        Authors a2=new Authors();
        a2.setName("Victor Hugo");


        Category c1=new Category();
        Category c2= new Category();
        c1.setName("Polisiye");
        c2.setName("Dünya Klasikleri");
        categoryRepo.save(c1);
        categoryRepo.save(c2);
        b1.setName("Kurtlar İmparatorluğu");
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setCategory(c1);
        a1.setBooks(Collections.singletonList(b1));
        b1.setAuthors(Collections.singletonList(a1));
        b1.setPrice(35.90);
        b1.setAddedDate(LocalDate.now());
        b1.setPublishedDate(LocalDate.now());
        b1.setImageUrl("fileName//1");

        b2.setName("Sefiller");
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setCategory(c2);
        a2.setBooks(Arrays.asList(b3, b2));
        b2.setAuthors(Collections.singletonList(a2));
        b2.setPrice(45.99);
        b2.setAddedDate(LocalDate.now());
        b2.setPublishedDate(LocalDate.now());
        b2.setImageUrl("fileName//2");

        b3.setName("Notre Dame'ın Kamburu");
        b3.setAuthors(Collections.singletonList(a2));
        b3.setIsbn(UUID.randomUUID().toString());
        b3.setCategory(c2);
        b3.setPrice(46.0);
        b3.setAddedDate(LocalDate.now());
        b3.setPublishedDate(LocalDate.now());
        b3.setImageUrl("fileName//3");

        authorRepo.save(a1);
        authorRepo.save(a2);
        booksRepo.save(b1);
        booksRepo.save(b2);
        booksRepo.save(b3);

        //yazara göre kitapları getir.
        System.out.println("Victor Hugo kitap bilgileri");
        System.out.println(booksRepo.findByAuthors_Name("Victor Hugo"));

        //kategoriye göre kitapları getir.
        System.out.println("Dünya klasikleri kategorisindeki kitapl bilgileri");
        System.out.println(booksRepo.findByCategory_Name("Dünya Klasikleri"));

        //isme göre kitap bilgileri
        System.out.println("Kurtlar imparatorluğu isimli kitabın bilgileri");
        System.out.println(booksRepo.findByName("Kurtlar İmparatorluğu"));





    }
}
