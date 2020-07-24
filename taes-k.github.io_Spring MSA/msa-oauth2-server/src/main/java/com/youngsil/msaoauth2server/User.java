package com.youngsil.msaoauth2server;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class User {
    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private int userType;

    private Date date;
}
