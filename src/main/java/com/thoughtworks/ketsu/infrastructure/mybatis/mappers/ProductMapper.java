package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.product.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ProductMapper {
    int save(@Param("info")Map<String, Object> info);

    Product findById(@Param("id")long id);
}
