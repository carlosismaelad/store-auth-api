package com.web.store_auth_api.store_auth_api.domain.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity(name = "categories")
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ProductCategory(RequestProductCategory requestProductCategory){
        this.name = requestProductCategory.name();
        this.createdAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}
