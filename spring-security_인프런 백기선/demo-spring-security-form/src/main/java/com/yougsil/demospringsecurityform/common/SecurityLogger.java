package com.yougsil.demospringsecurityform.common;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityLogger {

    public static void log(String message) {
        System.out.println(message);
        final Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("principal = " + principal);
    }
}
