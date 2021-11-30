package com.nathandbf.registrationDemo.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne(cascade = CascadeType.ALL)
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null && other.address == null) {
			return Objects.equals(cpf, other.cpf) && Objects.equals(name, other.name);
		} else if (address == null || other.address == null) {
			return false;
		}
		return Objects.equals(cpf, other.cpf) && Objects.equals(name, other.name)
				&& Objects.equals(address.toString(), other.address.toString());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [cpf=");
		builder.append(cpf);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address.toString());
		builder.append("]");
		return builder.toString();
	}

}
