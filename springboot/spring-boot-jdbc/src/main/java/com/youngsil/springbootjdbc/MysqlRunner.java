package com.youngsil.springbootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MysqlRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String sql = "create table account(id integer not null, name varchar(255), primary key(id))";
        String sql2 = "insert into account values (1, 'youngsil')";

        jdbcTemplate.execute(sql);
        jdbcTemplate.execute(sql2);
    }
}
