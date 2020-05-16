package com.zhang.service;

import com.zhang.mapper.BooksMapper;
import com.zhang.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class  BooksServiceImpl implements BooksService{

    @Autowired
    private BooksMapper booksMapper;

    @Override
    public Books quertByNm(String name) {
        return booksMapper.quertByNm(name);
    }
}
