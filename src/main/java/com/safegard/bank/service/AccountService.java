package com.safegard.bank.service;

import com.safegard.bank.model.Account;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Component
@Path("account.service")
public interface AccountService {

	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	Response save(Account account);

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<Account> findAll();

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	Account findOne(@PathParam("id") Long id);

	@GET
	@Path("query")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	Account findByAccountNo(@QueryParam("accountNo") String accountNo);
}