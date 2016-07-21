package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
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
public class UsersResourceTest extends ApiSupport{

    @Test
    public void should_return_201_when_post_uses_with_specified_parameter(){
        Response post = post("users", TestHelper.userMap("name"));
        assertThat(post.getStatus(), is(201));
        assertThat(Pattern.matches(".*/users/[0-9-]*",post.getLocation().toString()), is(true));
    }

    @Test
    public void should_return_400_when_name_is_empty(){
        Response post = post("users", new HashMap<>());
        assertThat(post.getStatus(), is(400));
        final List<Map<String, Object>> map = post.readEntity(List.class);
        assertThat(map.size(), is(1));

    }

}
