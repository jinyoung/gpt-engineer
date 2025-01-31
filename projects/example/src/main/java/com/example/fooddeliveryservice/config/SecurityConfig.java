package com.example.fooddeliveryservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/orders/**").authenticated()
            .and()
            .httpBasic();
        // Configure other security features as needed
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure in-memory, JDBC, or LDAP authentication
    }
}