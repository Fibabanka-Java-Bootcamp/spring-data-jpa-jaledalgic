package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import org.springframework.data.repository.CrudRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface OrdersRepo extends CrudRepository<Orders,Integer> {
    List<Orders> findByUsers_Name(String name);
    List<Orders> findByBooks_Name(String name);
}
