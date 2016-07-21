package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class UserResourceTest extends ApiSupport{
    @Inject
    UserRepository userRepository;

    @Test
    public void should_return_200_when_find_user(){
        User user = userRepository.postUser(TestHelper.userMap("John")).get();
        Response get = get("users/" + user.getId());
        assertThat(get.getStatus(), is(200));
    }
}
