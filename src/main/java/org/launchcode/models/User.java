package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message= "Username is required.")
    @Size(min = 5, max = 15, message= "Username must be between 5 & 15 characters.")
    private String username;

    @Email(message = "Must be a valid email.")
    private String email;

    @NotBlank (message = "Password is required.")
    @Size(min = 6, message= "Username must be between 5 & 15 characters.")
    private String password;

    public User(){}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
