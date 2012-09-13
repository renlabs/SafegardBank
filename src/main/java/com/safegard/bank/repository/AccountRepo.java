package com.safegard.bank.repository;

import com.safegard.bank.model.Account;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
public interface AccountRepo extends CrudRepository<Account, Long> {

    Account findByAccountNo(String accountNo);

}
