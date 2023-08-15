package com.example.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // getpasswordEncoder encodes/hashes the the password so it will not get stored in original format. It gets stored in hash format
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        return new CustomUserDetailService();
    }

    // This method is just to create some kind of user Object as we dont have database right now. ALl these things
    // are inbuilt eg(userDetails, etc). I can create any number of objects by declaring @Bean. They are stored in heap
    // or called inMemory. We created inbuilt two objects below student and admin.

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails student = User.withUsername("student1")
//                .password(getPasswordEncoder().encode("12345")) // getpasswordEncoder encodes/hashes the the password so it will not get stored in original format
//                .roles("STUDENT")
//                .build();
//
//        UserDetails admin = User.withUsername("Khala")
//                .password(getPasswordEncoder().encode("admin12345"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(student, admin); // They are stored in heap/ inmemory. InmemoryUserDetailsManager is its child class so returning it.
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/public/**")
//                .permitAll()
//                .requestMatchers("/student/***")
//                .permitAll()
//                .and()
//                .formLogin();
//
//        return httpSecurity.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/public/**")
                .permitAll()
                .requestMatchers("/student/**")
                .hasRole("STUDENT")
                .requestMatchers("/admin/**") //This means that if the person has role admin, he can than only access requestmatcher(admin) api and similarly others.
                .hasRole("ADMIN")
                .and()
                .formLogin();

        return httpSecurity.build();
    }
}
