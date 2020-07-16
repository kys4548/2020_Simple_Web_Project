package com.youngsil.springtest2;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserForm {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        final User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        return user;
    }
}
