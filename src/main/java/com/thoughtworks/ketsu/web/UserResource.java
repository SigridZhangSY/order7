package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.user.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserResource {
    private User user;

    public UserResource(User user) {
        this.user = user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User findUser(){
        return user;
    }

    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postOrder(){
        return Response.status(201).build();
    }
}
