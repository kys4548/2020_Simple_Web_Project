package com.youngsil.cloneshop2.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("m")
@Getter
public class Movie extends Item {

    private String director;
    private String actor;
}
