package com.yougsil.demospringsecurityform.form;

import com.yougsil.demospringsecurityform.account.Account;
import com.yougsil.demospringsecurityform.account.AccountContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {
    public void dashboard() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getClass() + " " + authentication.getPrincipal().getClass());
    }
}
