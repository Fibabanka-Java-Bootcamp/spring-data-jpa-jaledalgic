package com.hkarabakla.services;

import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import com.hkarabakla.repositories.BooksRepo;
import com.hkarabakla.repositories.OrdersRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class OrdersService {
    private final BooksRepo booksRepo;
    private final UserRepo userRepo;
    private final OrdersRepo ordersRepo;

    public OrdersService(BooksRepo booksRepo, UserRepo userRepo, OrdersRepo ordersRepo) {
        this.booksRepo = booksRepo;
        this.userRepo = userRepo;
        this.ordersRepo = ordersRepo;
    }
    public void ordersOperation(){

        Orders o1=new Orders();
        o1.setUsers(userRepo.findByName("Jale"));
        o1.setBooks(Arrays.asList(booksRepo.findByName("Sefiller"), booksRepo.findByName("Kurtlar İmparatorluğu")));
        o1.setTotal(booksRepo.findByName("Sefiller").getPrice()+booksRepo.findByName("Kurtlar İmparatorluğu").getPrice());
        o1.setCreated_at(LocalDate.now());
        ordersRepo.save(o1);

        System.out.println("Jale adlı kullanıcının sipariş bilgileri");
        System.out.println(ordersRepo.findByUsers_Name("Jale"));

        System.out.println("Sefiller romanının bulunduğu sipariş bilgileri");
        System.out.println(ordersRepo.findByBooks_Name("Sefiller"));
    }
}
