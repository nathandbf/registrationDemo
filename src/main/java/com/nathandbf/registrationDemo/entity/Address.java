package com.nathandbf.registrationDemo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ADDRESSES")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
@SequenceGenerator(name="seqAdress", initialValue=1, allocationSize=100)
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAdress")
	@Column(name = "ID_ADDRESS", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "COUNTRY_ADDRESS", nullable = true)
	private String country;
	
	@Column(name = "STATE_ADDRESS", nullable = true)
	private String state;
	
	@Column(name = "CITY_ADDRESS", nullable = true)
	private String city;
	
	@Column(name = "STREET_ADDRESS", nullable = true)
	private String street;
	
	@Column(name = "ZIP_ADDRESS", nullable = true)
	private String zip;
	
	
	public Address() {
		super();
	}
	
	public Address(String country, String state, String city, String street, String zip) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zip = zip;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(id, other.id) && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street) && Objects.equals(zip, other.zip);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", country=");
		builder.append(country);
		builder.append(", state=");
		builder.append(state);
		builder.append(", city=");
		builder.append(city);
		builder.append(", street=");
		builder.append(street);
		builder.append(", zip=");
		builder.append(zip);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
