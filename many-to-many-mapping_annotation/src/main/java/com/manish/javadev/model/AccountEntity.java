package com.manish.javadev.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ACCOUNT")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_ID")
	private long id;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "ACCOUNT_DATE")
	private Date accountOpenDate;

	/**
	 * With the mappedBy , you directly tell Hibernate/JPA that one table owns
	 * the relationship, and therefore it is stored as a column of that table.
	 * Without mappedBy the relationship is external, Hibernate/JPA need to
	 * create another table to store the relationship.
	 */

	@ManyToMany(mappedBy = "accountEntity", cascade = CascadeType.ALL)
	private Set<CustomerEntity> customerEntity;

	public AccountEntity() {
	}

	public AccountEntity(String accountType, Date accountOpenDate) {
		super();
		this.accountType = accountType;
		this.accountOpenDate = accountOpenDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public Set<CustomerEntity> getCustomerEntity() {
		if (customerEntity == null) {
			return customerEntity = new HashSet<CustomerEntity>();
		}
		return customerEntity;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", accountType=" + accountType
				+ ", accountOpenDate=" + accountOpenDate + "]";
	}

}
