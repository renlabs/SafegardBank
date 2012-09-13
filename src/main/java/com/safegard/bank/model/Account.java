package com.safegard.bank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Version
	private int version;
	@Column(name = "ACCNT_NO")
	private String accountNo;
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="ACCOUNT_HOLDER_ID")
	private AccountHolder accountHolder;
	@Column(name = "PIN")
	private String pin;
	@Column(name = "REG_DATE")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date reg_date;
	@Column(name = "AVAILABLE_BAL")
	private double availableBalance;
	@Column(name = "TOTAL_BAL")
	private double totalBalance;
	@OneToMany(
            mappedBy = "account",
			   cascade = CascadeType.ALL)
	private Set<TransactionRecord> transactionRecords;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public Set<TransactionRecord> getTransactionRecords() {
		return transactionRecords;
	}

	public void setTransactionRecords(Set<TransactionRecord> transactionRecords) {
		this.transactionRecords = transactionRecords;
	}
}
