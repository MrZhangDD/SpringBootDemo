package com.zhang;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource.getClass());
    }

    /**
     * 测试自动生成sql文件
     */
     @Test
    public void testSql(){
        List<String> list = new ArrayList<String>();
        boolean overWrite = true;
        //加文件
         String file = "generatorConfig.xml";
         File configFile = new File(file);
         //配置解析类
         ConfigurationClassParser cp = new ConfigurationClassParser(list);
     }
}
