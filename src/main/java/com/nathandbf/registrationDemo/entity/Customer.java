package com.nathandbf.registrationDemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "CUSTOMERS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Customer {
	@Id
	@Column(name = "CPF_CUSTOMER", nullable = false)
	private String cpf;
	
	@Column(name = "NAME_CUSTOMER", nullable = false)
	private String name;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_CUSTOMER")
	private Address address;
	
	
	public Customer() {
		super();
	}
	public Customer(String name, String cpf, Address address) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
