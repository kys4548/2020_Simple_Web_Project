package tacos.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        final User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        return user;
    }
}
