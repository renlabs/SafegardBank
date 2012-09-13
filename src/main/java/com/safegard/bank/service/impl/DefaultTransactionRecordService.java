package com.safegard.bank.service.impl;

import com.safegard.bank.model.Account;
import com.safegard.bank.model.TransactionRecord;
import com.safegard.bank.repository.TransactionRecordRepo;
import com.safegard.bank.service.TransactionRecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Service("transactionRecordService")
@Repository
@Transactional
public class DefaultTransactionRecordService implements TransactionRecordService {

	@Autowired
	TransactionRecordRepo repo;

	@Override
//	@Transactional(readOnly=true)
	public List<TransactionRecord> findAll() {
		return (List<TransactionRecord>) repo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TransactionRecord> findByAccountId(Long id) {
		Account account = new Account();
		account.setId(id);
		return repo.findByAccount(account);
	}
}
