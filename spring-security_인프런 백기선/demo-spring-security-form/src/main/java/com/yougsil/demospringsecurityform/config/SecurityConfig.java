package com.yougsil.demospringsecurityform.config;

import com.yougsil.demospringsecurityform.account.AccountService;
import com.yougsil.demospringsecurityform.common.LoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountService accountService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/info", "/account/**", "/signup").access("permitAll")
                .mvcMatchers( "/user").access("hasRole('USER')")
                .mvcMatchers("/admin").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .expressionHandler(expressionHandler());

         http.formLogin().loginPage("/login").permitAll();

         http.httpBasic();

         //필터 추가
         http.addFilterBefore(new LoggingFilter(), WebAsyncManagerIntegrationFilter.class);

        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    //기본값 : 세션이 필요할때 만든다.
                .sessionFixation()
                    .changeSessionId()
                    //기본값 세션 id만 바꿔줌
                .maximumSessions(3)
                    .maxSessionsPreventsLogin(false);
                    // 기본값 : 제한된 세션 이상으로 로그인하면 기존 로그인을 만료시킨다.

        http.rememberMe()
                .rememberMeParameter("remember-me")
                .userDetailsService(accountService)
                .key("remember-me-sample");

        http.logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true); // 기본값 : 로그아웃시 session 초기화
                //deleteCookies("") -> 쿠키 기반일 때

        http.exceptionHandling()
                .accessDeniedPage("/access-denied");
                //.accessDeniedHandler(클래스 정의하여 하면 더욱 정교하게 가능)
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //resource에 filter를 모두 제거한다. 인증없이 접근 가능
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    //role 상속
    private SecurityExpressionHandler expressionHandler() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

        final DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy);

        return defaultWebSecurityExpressionHandler;
    }


//    public AccessDecisionManager accessDecisionManager() {
//
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
//
//        final DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
//
//        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy);
//
//        final WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
//        webExpressionVoter.setExpressionHandler(defaultWebSecurityExpressionHandler);
//
//        List<AccessDecisionVoter<? extends Object>> voters = Arrays.asList(webExpressionVoter);
//        return new AffirmativeBased(voters);
//    }

}
