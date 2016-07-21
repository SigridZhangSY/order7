package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("users")
public class UsersRespurce {

    @POST
    public Response postUsers(Map<String, Object> info,
                              @Context Routes routes,
                              @Context UserRepository userRepository){
        User user = userRepository.postUser(info).get();
        return Response.created(routes.userUri(user)).build();
    }
}
