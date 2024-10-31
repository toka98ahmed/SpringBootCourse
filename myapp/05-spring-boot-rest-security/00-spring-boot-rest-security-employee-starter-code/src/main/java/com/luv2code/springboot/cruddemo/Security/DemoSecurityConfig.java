package com.luv2code.springboot.cruddemo.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails John = User.builder()
                .username("john")
                .password("{noop}test123")  //no operation, stored as plain text
                .roles("EMPLOYEE")
                .build();


        UserDetails Mary = User.builder()
                .username("mary")
                .password("{noop}test123")  //no operation, stored as plain text
                .roles("EMPLOYEE", "MANAGER")
                .build();


        UserDetails Susan = User.builder()
                .username("susan")
                .password("{noop}test123")  //no operation, stored as plain text
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(John, Mary, Susan);

    }
}
