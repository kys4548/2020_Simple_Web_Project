package me.youngsil;

import javax.persistence.Embeddable;

//Account Entity에 종속적임
@Embeddable
public class Address {

    private String street;

    private String city;

    private String state;

    private String zipCode;
}
