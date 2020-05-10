package com.youngsil.cloneshop2.api.memberdto;

import com.youngsil.cloneshop2.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LookupMember {

    private String name;
    private Address address;
}
