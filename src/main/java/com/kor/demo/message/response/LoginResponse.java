package com.kor.demo.message.response;

import java.util.Optional;

import com.kor.demo.model.User;

public class LoginResponse {

    private JwtResponse jwtResponse;
    private Optional<User> user;

    public LoginResponse(JwtResponse jwtResponse, Optional<User> user) {
        this.jwtResponse = jwtResponse;
        this.user = user;
    }

    /**
     * @return the jwtResponse
     */
    public JwtResponse getJwtResponse() {
        return jwtResponse;
    }

    /**
     * @param jwtResponse the jwtResponse to set
     */
    public void setJwtResponse(JwtResponse jwtResponse) {
        this.jwtResponse = jwtResponse;
    }

    /**
     * @return the user
     */
    public Optional<User> getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Optional<User> user) {
        this.user = user;
    }



}