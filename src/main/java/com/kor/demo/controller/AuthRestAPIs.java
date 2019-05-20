package com.kor.demo.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.kor.demo.dao.RoleDao;
import com.kor.demo.dao.UserDao;
import com.kor.demo.message.request.LoginForm;
import com.kor.demo.message.request.SignUpForm;
import com.kor.demo.message.response.JwtResponse;
import com.kor.demo.message.response.LoginResponse;
import com.kor.demo.model.Role;
import com.kor.demo.model.RoleName;
import com.kor.demo.model.User;
import com.kor.demo.security.jwt.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired 
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired 
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (userDao.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("略略略这个名字已经有人用了哟!",
            HttpStatus.BAD_REQUEST);
        }

        if (userDao.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("略略略这个邮箱已经有人用了哟!", 
            HttpStatus.BAD_REQUEST);
        }
        // 创建一个新的用户DAZE
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), new Date());
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleDao.findByName(RoleName.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("admin什么的当然是不存在的"));
                    roles.add(adminRole);    
                    break;
                case "pm":
                    Role pmRole = roleDao.findByName(RoleName.ROLE_PM)
                        .orElseThrow(() -> new RuntimeException("pm是project manager并不是pocket monster"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleDao.findByName(RoleName.ROLE_USER)
                        .orElseThrow(()-> new RuntimeException("这是一个用户DAZA"));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userDao.save(user);
        
        return ResponseEntity.ok().body("注册成功啦 (゜-゜)つロ ");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        JwtResponse jwtResponse = new JwtResponse(jwt);
        Optional<User> user = userDao.findByUsername(loginRequest.getUsername());
        return ResponseEntity.ok(new LoginResponse(jwtResponse, user));
 
    }
}