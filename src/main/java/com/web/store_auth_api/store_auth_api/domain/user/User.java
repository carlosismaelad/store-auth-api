package com.web.store_auth_api.store_auth_api.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = null;

    public User(RequestUser requestUser){
        this.username = requestUser.username();
        this.password = requestUser.password();
        this.createdAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.active = true;
    }
}
