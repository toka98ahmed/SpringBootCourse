package com.luv2code.springboot.cruddemo.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    // add support for JDBC

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP basic authentication

        http.httpBasic(Customizer.withDefaults());

        // disable CSRF
        // Not required for REST APIs

        http.csrf(csrf-> csrf.disable());

        return http.build();
    }

    /**
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

     } **/
}
