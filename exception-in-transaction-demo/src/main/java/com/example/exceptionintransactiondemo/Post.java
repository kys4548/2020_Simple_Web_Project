package com.example.exceptionintransactiondemo;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String text;

    public Post(String text) {
        this.text = text;
    }
}
