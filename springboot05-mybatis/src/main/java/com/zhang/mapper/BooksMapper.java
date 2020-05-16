package com.zhang.mapper;

import com.zhang.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface BooksMapper {

    List<Books> queryForList();
    Books queryForId(int id);
    int addBook(Books books);
    int updateById(Books books);
    int deleteBook(int id);


}
