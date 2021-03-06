package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.ws.rs.*;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listProducts(@Context ProductRepository productRepository){
        return productRepository.listProduct();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") long id,
                              @Context ProductRepository productRepository){
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("product not fund"));
    }
}
