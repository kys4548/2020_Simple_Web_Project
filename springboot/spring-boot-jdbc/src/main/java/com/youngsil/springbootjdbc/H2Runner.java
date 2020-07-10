package com.youngsil.springbootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

//@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getMetaData().getURL());
        System.out.println(connection.getMetaData().getUserName());

        Statement statement = connection.createStatement();
        String sql1 = "create table user(id integer not null, name varchar(255), primary key(id))";
        statement.execute(sql1);

        String sql2 = "insert into user values (1, 'youngsil')";

        jdbcTemplate.execute(sql2);
    }
}
