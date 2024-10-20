package com.web.store_auth_api.store_auth_api.domain.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = null;


    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.description = requestProduct.description();
        this.price = requestProduct.price();
        this.active = true;
        this.createdAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}
