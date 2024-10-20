package com.web.store_auth_api.store_auth_api.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
    List<ProductCategory> findAllByActiveTrue();
}
