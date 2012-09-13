package com.safegard.bank.service.impl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safegard.bank.model.Account;
import com.safegard.bank.model.AccountHolder;
import com.safegard.bank.repository.AccountHolderRepo;
import com.safegard.bank.repository.AccountRepo;
import com.safegard.bank.service.AccountHolderService;

@Service("accountHolderService")
@Repository
@Transactional
public class DefaultAccountHolderService implements AccountHolderService {

    @Autowired
    private AccountHolderRepo accountHolderRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Response save(AccountHolder accountHolder) {
        accountHolderRepo.save(accountHolder);
        return Response.ok().build();
    }

    @Override
    public Response delete(Long id) {
        accountHolderRepo.delete(id);
        return Response.ok().build();
    }

    @Override
    @Transactional(readOnly = true)
    public AccountHolder find(Long id) {
        return accountHolderRepo.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountHolder> findAll() {
        return (List<AccountHolder>) accountHolderRepo.findAll();
    }

    @Override
    public Response createTestData() {
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
        ah1.setGender("Male");
        ah1.setLastName("Doe");
        ah1.setMiddleName("Tera");
        ah1.setPhone("123-123-1234");
        
        accountRepo.save(ac);
        ah1.setAccount(ac);
        accountHolderRepo.save(ah1);

        return Response.ok().build();
    }

    @Override
    public AccountHolder findByAccountId(String accountId) {
        return accountHolderRepo.findByAccountId(accountId);
    }

}
