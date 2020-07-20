package com.youngsil.cloneshop2.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("a")
@Getter
public class Album extends Item {
    private String artist;
    private String etc;
}
