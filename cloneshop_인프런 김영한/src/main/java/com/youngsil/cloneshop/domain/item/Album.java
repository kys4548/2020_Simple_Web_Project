package com.youngsil.cloneshop.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("a")
@Getter
public class Album extends Item {

    private String artist;
    private String etc;
}
