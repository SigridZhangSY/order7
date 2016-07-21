package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("products")
public class ProductResource {

    @POST
    public Response postProduct(@Context Routes routes){
        return Response.created(routes.productUri(new Product(1))).build();
    }
}
