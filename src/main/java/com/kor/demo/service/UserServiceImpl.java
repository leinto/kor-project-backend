package com.kor.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kor.demo.dao.UserDao;
import com.kor.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
            User user = userDao.findByUsername(username)
                        .orElseThrow(() -> 
                            new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                            );
            return UserPrinciple.build(user);
        }
} 