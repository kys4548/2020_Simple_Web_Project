package com.youngsil.cloneshop2.api.memberdto;

import lombok.Data;

@Data
public class CreateMemberResponse {

    private Long id;

    public CreateMemberResponse(Long id) {
        this.id = id;
    }
}
