package com.safegard.bank.service.impl;

import com.safegard.bank.model.Account;
import com.safegard.bank.service.AccountService;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Service("accountService")
@Repository
@Transactional
public class DefaultAccountService implements AccountService{

	@Override
	public Response save(Account account) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<Account> findAll() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Account findOne(Long id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Account findByAccountNo(String accountNo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
