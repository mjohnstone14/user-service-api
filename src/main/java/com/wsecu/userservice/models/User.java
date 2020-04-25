package com.wsecu.userservice.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@Data
@Entity
public class User {
    private @Id @GeneratedValue Long id;

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "User name cannot be empty")
    private String userName;

    @NotNull(message = "Email is required")
    private String email;

    public User(String name, String userName, String email) {
        this.name = name;
        this.userName = userName;
        this.email = email;
    }
}
