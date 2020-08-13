package com.example.restfulwebservicereview.User;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static long usersCount = 3;

    static {
        users.add(new User(1L, "a", LocalDateTime.now(),  "1", "1"));
        users.add(new User(2L, "a", LocalDateTime.now(),  "1", "1"));
        users.add(new User(3L, "a", LocalDateTime.now(),  "1", "1"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Long id) {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if(user.getId() == 0L) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public boolean deleteById(Long id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
