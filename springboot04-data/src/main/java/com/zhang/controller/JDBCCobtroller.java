package com.zhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCCobtroller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/que")
    public String test(){
        return "ok";
    }
    @RequestMapping("/query")
    //查询数据库所有信息
    public List<Map<String,Object>> queryList(){
        String sql = "select * from books";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }

    @RequestMapping("/add")
    //查询数据库所有信息
    public String add(){
        String sql = "insert into books(bookId,bookName) values(12,'小黄书')";
        int update = jdbcTemplate.update(sql);
        return "update-ok";
    }

    @RequestMapping("/update/{id}")
    //查询数据库所有信息
    public String update(@PathVariable("id") int id){
        String sql = "update books set bookName=? where bookId=" + id;
        Object[] objects = new Object[1];
        objects[0] = "小明";
        int update = jdbcTemplate.update(sql,objects);
        return "update-ok";
    }

}
