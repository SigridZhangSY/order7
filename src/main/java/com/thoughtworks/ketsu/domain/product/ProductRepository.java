package com.thoughtworks.ketsu.domain.product;

import java.util.Map;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> createProduct(Map<String, Object> info);
}
