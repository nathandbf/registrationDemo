package com.nathandbf.registrationDemo.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathandbf.registrationDemo.dao.CustomerDAO;
import com.nathandbf.registrationDemo.entity.Customer;
import com.nathandbf.registrationDemo.repository.CustomerRepository;


@Service
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	/**
	 * Method responsible for saving the customer on the database.
	 * @param customer
	 * @return The saved customer
	 */
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	/**
	 * Method responsible for searching on the database a customer using a CPF
	 * @param cpf
	 * @return The customer object found.
	 */
	@Override
	public Customer searchCustomer(String cpf)  {
		return customerRepository.findByCpf(cpf);
	}

}
