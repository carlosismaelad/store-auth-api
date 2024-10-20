package com.web.store_auth_api.store_auth_api.domain.product;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RequestProduct(
        String id,

        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        @Positive(message = "Price must be a positive value.")
        BigDecimal price,

        @NotNull
        boolean active,

        LocalDateTime createdAt,

        LocalDateTime updatedAt

) {
    public RequestProduct{
        price = price.setScale(2);
    }
}
