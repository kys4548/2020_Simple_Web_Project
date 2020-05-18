package me.youngsil.inflearnthejavatest;

import java.util.Optional;

public class Memberservice {

    public Optional<Member> findById(Long id) {
        return Optional.of(new Member());
    }

    public void validate(Long id) {
        System.out.println("\"g\" = " + "g");
    }
}
