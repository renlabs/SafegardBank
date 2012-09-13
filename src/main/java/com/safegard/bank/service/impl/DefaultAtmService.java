package com.safegard.bank.service.impl;

import com.safegard.bank.enums.TransactionType;
import com.safegard.bank.model.Account;
import com.safegard.bank.model.TransactionRecord;
import com.safegard.bank.repository.AccountRepo;
import com.safegard.bank.repository.TransactionRecordRepo;
import com.safegard.bank.service.AtmService;
import java.net.URI;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Service("atmService")
@Repository
@Transactional
public class DefaultAtmService implements AtmService {

	@Autowired
	private TransactionRecordRepo repo;
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public Response deposit(String accountNo, double amount) {
		Account currentAccount = accountRepo.findByAccountNo(accountNo);
		if (null == currentAccount) {
			throw new NullPointerException("Account[" + accountNo + "] does not exist.");
		}
		// TODO - Bank Rules(deposite must not exceed to the maximum amount.)
		TransactionRecord tr = new TransactionRecord();
		tr.setAccount(currentAccount);
		tr.setDebit(amount);
		tr.setType(TransactionType.DEPOSIT);

		repo.save(tr);

		return Response.created(URI.create(tr.getId().toString())).build();
	}

	@Override
	public Response withdraw(String accountNo, double amount) {
		Account currentAccount = accountRepo.findByAccountNo(accountNo);

		TransactionRecord tr = new TransactionRecord();
		tr.setAccount(currentAccount);
		tr.setDebit(amount);
		tr.setType(TransactionType.WITHDRAWAL);

		repo.save(tr);
		return Response.ok().build();
	}

	@Override	
	public Response transfer(String fromAccountNo, String toAccountNo, double amount) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public double balanceInquiry(Long id) {
		Account account = accountRepo.findOne(id);
		return account.getAvailableBalance();
	}
}
