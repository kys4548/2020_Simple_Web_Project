package com.youngsil.cloneshop2.api.memberdto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateMemberRequest {

    @NotEmpty
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
