package com.safegard.bank.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.safegard.bank.model.BankUser;

@Component
@Path("bankUser.service")
public interface BankUserService {

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response save(BankUser bankUser);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") Long id);

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    BankUser find(@PathParam("id") Long id);

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<BankUser> findAll();

    @GET
    @Path("query")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    BankUser findByUsername(@QueryParam("username") String username);

    @POST
    @Path("create-test-data")
    public Response createTestData();

}
