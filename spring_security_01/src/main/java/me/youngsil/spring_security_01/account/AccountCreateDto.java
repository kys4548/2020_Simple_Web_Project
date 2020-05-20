package me.youngsil.spring_security_01.account;

import lombok.Data;

@Data
public class AccountCreateDto {
    private String username;
    private String password;
    private AccountRole role;
}
