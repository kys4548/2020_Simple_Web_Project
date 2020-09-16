package com.example.restfulwebservicereview.User;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonFilter("User")
public class User {

    private Long id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요:")
    private String name;

    @Past(message = "미래의 입력이 불가능 합니다.")
    private LocalDateTime joinDate;

    private String password;
    private String ssn;
}