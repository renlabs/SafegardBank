package com.safegard.bank.service;

import com.safegard.bank.model.TransactionRecord;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Component
@Path("transaction.service")
public interface TransactionRecordService {

	@GET
	@Produces({MediaType.APPLICATION_XML})
	List<TransactionRecord> findAll();

	@GET
	@Path("query/{accountId}")
	List<TransactionRecord> findByAccountId(@PathParam("accountId") Long id);
	
}
