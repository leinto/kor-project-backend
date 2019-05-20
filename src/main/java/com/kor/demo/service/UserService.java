package com.kor.demo.service;

import java.util.List;

import com.kor.demo.model.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    public List<User> getAllUsers();
    public UserDetails loadUserByUsername(String username);
}