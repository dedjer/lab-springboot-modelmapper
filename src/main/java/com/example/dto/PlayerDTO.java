package com.example.dto;

import javax.persistence.Column;

public class PlayerDTO {

    @Column(name="email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
