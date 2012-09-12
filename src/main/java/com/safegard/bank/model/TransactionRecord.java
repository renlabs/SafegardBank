package com.safegard.bank.model;

import com.safegard.bank.enums.TransactionType;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.joda.time.DateTime;

/**
 *
 * @author Monte Cillo Co<mco@exist.com>
 */
@Entity
@Table(name = "TRANS_RECORD")
@XmlRootElement
public class TransactionRecord implements Serializable {

	@Id
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", length = 20)
	private TransactionType type;
	@Column(name = "DATE_TIME")
	private DateTime dateTime;
	@Column(name = "CREDIT")
	private double credit;
	@Column(name = "DEBIT")
	private double debit;
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}
}
