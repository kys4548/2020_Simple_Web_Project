package com.example.springaopproxy;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface LogExecutionTime {
}
