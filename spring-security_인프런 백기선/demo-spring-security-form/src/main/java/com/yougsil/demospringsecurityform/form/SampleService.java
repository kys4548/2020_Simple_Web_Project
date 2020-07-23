package com.yougsil.demospringsecurityform.form;

import com.yougsil.demospringsecurityform.account.Account;
import com.yougsil.demospringsecurityform.account.AccountContext;
import com.yougsil.demospringsecurityform.common.SecurityLogger;
import org.springframework.scheduling.annotation.Async;
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

    @Async //별도의 thread를 만들어서 비동기적으로 처리해줌
    public void asyncService() {
        SecurityLogger.log("Async Service Inner");
        System.out.println("Async Service is called");
    }
}
