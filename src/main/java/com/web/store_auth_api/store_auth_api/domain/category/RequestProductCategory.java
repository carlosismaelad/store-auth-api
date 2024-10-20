package com.web.store_auth_api.store_auth_api.domain.category;

import jakarta.validation.constraints.NotBlank;

public record RequestProductCategory(
        String id,

        @NotBlank
        String name
) {
}
