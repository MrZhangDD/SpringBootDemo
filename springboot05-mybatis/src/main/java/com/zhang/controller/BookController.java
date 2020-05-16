package com.zhang.controller;

import com.zhang.mapper.BooksMapper;
import com.zhang.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BooksMapper booksMapper;

    @RequestMapping("/query")
    public List<Books> queryForList(){
        List<Books> books = booksMapper.queryForList();
        return books;
    }
}
