package com.zhang.mapper;

import com.zhang.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface BooksMapper {

    public Books quertByNm(String name);

}
