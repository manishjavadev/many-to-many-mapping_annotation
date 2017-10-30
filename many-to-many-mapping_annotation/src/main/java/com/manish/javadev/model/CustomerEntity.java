package com.manish.javadev.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUSTOMER")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "AGE")
	private int age;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="TBL_CUSTOMER_ACCOUNT",
	joinColumns=@JoinColumn(name="CUSTOMER_ID_FK",referencedColumnName="CUSTOMER_ID"),
	inverseJoinColumns=@JoinColumn(name="ACCOUNT_ID_FK",referencedColumnName="ACCOUNT_ID")
	)
	private Set<AccountEntity> accountEntity;

	public CustomerEntity() {
	}

	public CustomerEntity(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<AccountEntity> getAccountEntity() {
		if (accountEntity == null) {
			return accountEntity = new HashSet<AccountEntity>();
		}
		return accountEntity;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + "]";
	}

}
