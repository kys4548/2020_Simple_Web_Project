package com.youngsil.cloneshop2;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cloneshop2Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloneshop2Application.class, args);
    }

    @Bean
    public Hibernate5Module hibernate5Module() {
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        return hibernate5Module;
    }
}
