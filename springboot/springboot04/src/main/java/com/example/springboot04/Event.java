package com.example.springboot04;

import javax.validation.constraints.*;

public class Event {

    Integer id;

    @NotEmpty
    String title;

    @NotNull @Min(0)
    Integer limit;


    @Email
    String email;

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getLimit() {
        return limit;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
