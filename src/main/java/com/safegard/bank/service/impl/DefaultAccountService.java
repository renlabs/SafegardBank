package com.safegard.bank.service.impl;

import com.safegard.bank.enums.Gender;
import com.safegard.bank.model.Account;
import com.safegard.bank.model.AccountHolder;
import com.safegard.bank.repository.AccountRepo;
import com.safegard.bank.service.AccountService;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
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
public class DefaultAccountService implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Override
	public Response save(Account account) {
		accountRepo.save(account);
		return Response.ok().build();
	}

	@Override
	public List<Account> findAll() {
		return (List<Account>) accountRepo.findAll();
	}

	@Override
	public Account findOne(Long id) {
		return accountRepo.findOne(id);
	}

	@Override
	public Account findByAccountNo(String accountNo) {
		return accountRepo.findByAccountNo(accountNo);
	}

	@Override
	public void createTestData() {
		Account ac = new Account();
		ac.setAccountNo("12345");
		ac.setAvailableBalance(1000.00);
		ac.setPin("1234");
		ac.setReg_date(new Date());
		ac.setTotalBalance(1000.00);
		ac.setVersion(0);
		AccountHolder ah1 = new AccountHolder();
		ah1.setAddress("Manila");
		ah1.setBirthdate(new Date());
		ah1.setFirstName("John");
		ah1.setGender(Gender.MALE);
		ah1.setLastName("Doe");
		ah1.setMiddleName("Tera");
		ah1.setPhone("123-123-1234");

		accountRepo.save(ac);
		ah1.setAccount(ac);
	}
}
