package com.nathandbf.registrationDemo.dao;

import java.sql.SQLException;

import com.nathandbf.registrationDemo.entity.Customer;

public interface CustomerDAO {
	
	/**
	 * Interface method responsible for saving the customer.
	 * @param customer
	 * @return The saved customer
	 */
	Customer saveCustomer(Customer customer);
	
	/**
	 * Interface method responsible for searching a customer using a CPF
	 * @param cpf
	 * @return The customer object found.
	 */
	Customer searchCustomer(String cpf);
}
