package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class UsersResourceTest extends ApiSupport{

    @Test
    public void should_return_201_when_post_uses_with_specified_parameter(){
        Response post = post("users", TestHelper.userMap("name"));
        assertThat(post.getStatus(), is(201));
        assertThat(Pattern.matches(".*/users/[0-9-]*",post.getLocation().toString()), is(true));
    }
}
