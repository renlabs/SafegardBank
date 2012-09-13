/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safegard.bank.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
public class AccountNotFoundException extends WebApplicationException {

	public AccountNotFoundException(String accountNo) {
		super(new Throwable("Account[" + accountNo + "] does not exist!"), 
			  Response.status(Status.BAD_REQUEST).build());
	}
}
