package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class UserResourceTest extends ApiSupport{
    @Inject
    UserRepository userRepository;
    @Inject
    ProductRepository productRepository;

    @Test
    public void should_return_detail_when_find_user(){
        User user = userRepository.postUser(TestHelper.userMap("John")).get();
        Response get = get("users/" + user.getId());
        assertThat(get.getStatus(), is(200));
        final Map<String, Object> map = get.readEntity(Map.class);
        assertThat(String.valueOf(map.get("uri")), is("/users/" + user.getId()));
    }

    @Test
    public void should_return_404_when_user_not_exists(){
        User user = userRepository.postUser(TestHelper.userMap("John")).get();
        Response get = get("users/" + (user.getId()+1));
        assertThat(get.getStatus(), is(404));
    }

    @Test
    public void should_return_201_when_post_order(){
        User user = userRepository.postUser(TestHelper.userMap("John")).get();
        Product product = productRepository.createProduct(TestHelper.productMap("apple")).get();

        Response post = post("users/" + user.getId() + "/orders", new HashMap<>());
        assertThat(post.getStatus(), is(201));
    }
}
