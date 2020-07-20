package com.youngsil.cloneshop2.api.memberdto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateMemberRequest {

    @NotEmpty
    String name;
}
