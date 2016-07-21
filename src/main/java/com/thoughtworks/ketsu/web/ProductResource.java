package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("products")
public class ProductResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postProduct(Map<String, Object> info,
                                @Context Routes routes,
                                @Context ProductRepository productRepository){
        List<String> fields = new ArrayList<>();
        if(info.getOrDefault("name", "").toString().trim().isEmpty())
            fields.add("name");
        if(info.getOrDefault("description", "").toString().trim().isEmpty())
            fields.add("description");
        if (info.getOrDefault("price", "").toString().trim().isEmpty())
            fields.add("price");
        if(fields.size() > 0)
            throw new InvalidParameterException(fields);
        return Response.created(routes.productUri(productRepository.createProduct(info).get())).build();
    }

    @GET
    public String listProducts(){
        return "OK";
    }
}
