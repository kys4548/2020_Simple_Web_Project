package com.youngsil.cloneshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * 객체의 경우 값의 복사가 이루어지는것이 아니라 값의 참조가 이루어진다.
 * 만약 여러 객체에서 하나의 Address를 공유한다면 Side Effect가 발생할 수 있다.
 * 그것을 방지하기 위해 값타입을 객체에 추가할 때에는 항상 새로 만들어서 넣는다.
 * Set메소드 절대 사용 하지말것. 따라서 생성자도 해당 모습만 가능.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
