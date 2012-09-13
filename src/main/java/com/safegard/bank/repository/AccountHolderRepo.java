
package com.safegard.bank.repository;

import com.safegard.bank.model.AccountHolder;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
public interface AccountHolderRepo extends CrudRepository<AccountHolder, Long> {

    AccountHolder findByAccountId(Long accountID);

}
