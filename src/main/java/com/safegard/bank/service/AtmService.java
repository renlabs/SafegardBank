package com.safegard.bank.service;

import com.safegard.bank.model.Account;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Component
@Path("atm.service")
public interface AtmService {

	@POST
	@Path("deposit")
	Response deposit(@FormParam("account_no") String accountNo,
					 @FormParam("amount") double amount);

	@POST
	@Path("withdraw")
	Response withdraw(@FormParam("account") String accountNo,
					  @FormParam("amount") double amount);

	@POST
	@Path("transfer")
	Response transfer(@FormParam("fromAccount") String fromAccountNo,
					  @FormParam("toAccount") String toAccountNo,
					  @FormParam("amount") double amount);

	@GET
	@Path("balance-inquiry/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	double balanceInquiry(@PathParam("id") Long id);
}
