package com.youngsil.cloneshop2.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * 여러 Entity에서 공유해서 사용할 경우 쓰지말자.
 * 값 타입은 기본적으로 내부 변경 불가.
 * 값타입 내부의 변경은 JPA가 인식할 수 없다.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
