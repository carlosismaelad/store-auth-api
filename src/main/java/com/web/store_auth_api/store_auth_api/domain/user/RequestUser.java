package com.web.store_auth_api.store_auth_api.domain.user;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RequestUser(

        String id,

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password,

        boolean active,

        LocalDateTime createdAt,

        LocalDateTime updatedAt) {

}
