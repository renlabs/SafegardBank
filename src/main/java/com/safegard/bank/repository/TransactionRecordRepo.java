package com.safegard.bank.repository;

import com.safegard.bank.model.Account;
import com.safegard.bank.model.TransactionRecord;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
public interface TransactionRecordRepo extends CrudRepository<TransactionRecord, Long> {

	public List<TransactionRecord> findByAccount(Account account);
	
}
