package com.zhang;

import com.zhang.pojo.Books;
import com.zhang.service.BooksService;
import com.zhang.service.BooksServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07ShiroApplicationTests {

    @Autowired
    private BooksServiceImpl booksService;
    @Test
    void contextLoads() {
        Books books = booksService.quertByNm("java书籍");
        System.out.println(books);
    }

}
