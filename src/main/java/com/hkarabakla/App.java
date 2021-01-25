package com.hkarabakla;

import com.hkarabakla.services.BookService;
import com.hkarabakla.services.OrdersService;
import com.hkarabakla.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.hkarabakla");
        appContext.refresh();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();


        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.booksOperation();

        OrdersService ordersService = (OrdersService) appContext.getBean("ordersService");
        ordersService.ordersOperation();

        appContext.close();
    }
}
