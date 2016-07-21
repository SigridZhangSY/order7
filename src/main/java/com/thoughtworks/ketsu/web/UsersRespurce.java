package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("users")
public class UsersRespurce {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUsers(Map<String, Object> info,
                              @Context Routes routes,
                              @Context UserRepository userRepository){
        List<String> fields = new ArrayList<>();
        if (info.getOrDefault("name", "").toString().trim().isEmpty())
            fields.add("name");
        if (fields.size() > 0)
            throw new InvalidParameterException(fields);
        User user = userRepository.postUser(info).get();
        return Response.created(routes.userUri(user)).build();
    }

    @Path("{userId}")
    public UserResource getUserResource(@PathParam("userId") long userId,
                                        @Context UserRepository userRepository){
        User user = userRepository.findById(userId).get();
        return new UserResource(user);
    }
}
