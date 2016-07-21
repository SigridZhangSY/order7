package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("users")
public class UsersRespurce {

    @POST
    public Response postUsers(@Context Routes routes){
        return Response.created(routes.userUri(new User(1))).build();
    }
}
