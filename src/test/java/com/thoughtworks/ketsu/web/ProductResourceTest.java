package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class ProductResourceTest extends ApiSupport {

    @Test
    public void should_return_201_when_post_with_specified_parameter(){
        Response post = post("products", TestHelper.productMap("apple"));
        assertThat(post.getStatus(), is(201));
        assertThat(Pattern.matches(".*/products/[0-9-]*", post.getLocation().toASCIIString()), is(true));
    }

    @Test
    public void should_return_400_when_post_with_name_is_empty(){
        Map<String, Object> map = TestHelper.productMap("apple");
        map.remove("name");
        Response post = post("products", map);
        assertThat(post.getStatus(), is(400));
        final List<Map<String, Object>> errorList = post.readEntity(List.class);
        assertThat(errorList.size(), is(1));
    }
}
