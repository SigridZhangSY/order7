package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class ProductResourceTest extends ApiSupport {

    @Test
    public void should_return_uri_when_post(){
        Response post = post("products", new HashMap<String, Object>());
        assertThat(post.getStatus(), is(201));
        assertThat(Pattern.matches(".*/products/[0-9-]*", post.getLocation().toASCIIString()), is(true));
    }
}
