package com.kor.demo.message.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpForm {

        
    @NotBlank
    @Size(min = 3, max = 60)
    private String email;

    @NotBlank
    @Size(min = 3, max = 40)
    private String password;

    @NotBlank
    @Size(min = 6, max = 100)
    private String username;

    private Set<String> role;


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the role
     */
    public Set<String> getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Set<String> role) {
        this.role = role;
    }

    
    
}