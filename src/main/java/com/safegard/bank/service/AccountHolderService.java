package com.safegard.bank.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.safegard.bank.model.AccountHolder;

@Component
@Path("accountHolder.service")
public interface AccountHolderService {

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response save(AccountHolder accountHolder);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") Long id);

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    AccountHolder find(@PathParam("id") Long id);

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<AccountHolder> findAll();

    @GET
    @Path("query")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    AccountHolder findByAccountId(@PathParam("accountId") String accountId);

    @POST
    @Path("create-test-data")
    public Response createTestData();

}