package com.example.SpringSecurity.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    //Imagine you're building a system where people can log in with their usernames and passwords.
    // This code is like a blueprint that helps the system understand how to handle user information securely.
    //In this blueprint (the CustomUserDetailService class), there's a special method called loadUserByUsername.
    // This method is like a detective that looks up user information when someone tries to log in.
    //When someone enters their username, the detective (method) goes to check if that username exists in the system. If it finds the username,
    // it gathers some details about that user, like their password and other information that's needed for logging in.
    //If the detective can't find the username, it raises its hand and says, "Hey, I couldn't find this person!"
    // This is like the detective throwing an "UsernameNotFoundException."

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
