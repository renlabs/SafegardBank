package com.safegard.bank.service.impl;

import com.safegard.bank.model.Account;
import com.safegard.bank.repository.AccountRepo;
import com.safegard.bank.service.AccountService;
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
public class DefaultAccountService implements AccountService{

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Response save(Account account) {
        accountRepo.save(account);
        return Response.ok().build();
    }

    @Override
    @Transactional(readOnly = true)
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

}
