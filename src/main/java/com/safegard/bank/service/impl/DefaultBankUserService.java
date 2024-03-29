package com.safegard.bank.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safegard.bank.model.BankUser;
import com.safegard.bank.repository.BankUserRepo;
import com.safegard.bank.service.BankUserService;

@Service("bankUserService")
@Repository
@Transactional
public class DefaultBankUserService implements BankUserService {

    @Autowired
    private BankUserRepo bankUserRepo;

    @Override
    public Response createTestData() {
        BankUser bankUser = new BankUser();
        bankUser.setEmail("test@test.com");
        bankUser.setFirstName("William");
        bankUser.setLastName("Shakespear");
        bankUser.setMiddleName("Idontknow");
        bankUser.setPassword("Test123");
        bankUser.setUsername("wSpear");
        bankUser.setVersion(0);
        bankUserRepo.save(bankUser);

        return Response.ok().build();
    }

    @Override
    public Response delete(Long id) {
        bankUserRepo.delete(id);
        return Response.ok().build();
    }

    @Override
    public BankUser find(Long id) {
        return bankUserRepo.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankUser> findAll() {
        return (List<BankUser>) bankUserRepo.findAll();
    }

    @Override
    public Response save(BankUser bankUser) {
        bankUserRepo.save(bankUser);
        return Response.ok().build();
    }

    @Override
    public BankUser findByUsername(String username) {
        return bankUserRepo.findByUsername(username);
    }

}
