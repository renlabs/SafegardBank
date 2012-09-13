
package com.safegard.bank.repository;

import com.safegard.bank.model.BankUser;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
public interface BankUserRepo extends CrudRepository<BankUser, Long> {
	
}
