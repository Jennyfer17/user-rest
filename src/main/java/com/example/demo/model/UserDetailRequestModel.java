package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailRequestModel {

    @NotNull(message="First name cannot be missing or empty")
    @Size(min=2, message="First name must be at least 2 characters long")
    private String firstName;

    @NotNull(message="Last name cannot be missing or empty")
    @Size(min=2, message="Last name must be at least 2 characters long")
    private String lastName;

    @NotNull(message="Email cannot be missing or empty")
    @Email
    private String email;

    @NotNull(message="Password cannot be missing or empty")
    @Size(min=8,max=16, message="Password must be between 8 and 16 characters long")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
