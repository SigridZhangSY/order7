package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.product.*;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {

    @Inject
    ProductRepository productRepository;

    @Test
    public void should_save_and_find_product(){
        Optional<Product> product = productRepository.createProduct(TestHelper.productMap("name"));
        assertThat(product.isPresent(), is(true));
    }

    @Test
    public void should_list_all_products(){
        Optional<Product> product = productRepository.createProduct(TestHelper.productMap("name"));
        List<Product> list = productRepository.listProduct();
        assertThat(list.size(), is(1));
    }
}
