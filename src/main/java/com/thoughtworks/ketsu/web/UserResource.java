package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
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
    public Response postOrder(@Context Routes routes){
        return Response.created(routes.orderUri(new Order(1, user.getId()))).build();
    }
}
