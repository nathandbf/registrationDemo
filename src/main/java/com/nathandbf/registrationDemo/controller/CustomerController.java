package com.nathandbf.registrationDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.nathandbf.registrationDemo.dao.CustomerDAO;
import com.nathandbf.registrationDemo.entity.Address;
import com.nathandbf.registrationDemo.entity.Customer;
import com.nathandbf.registrationDemo.entity.Response;
import com.nathandbf.registrationDemo.messages.Message;
import com.nathandbf.registrationDemo.util.Validator;
@Controller
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	/**
	 * Method responsible for the logic of the customer registration flow with the following rules:
		R1 - Name must be different from null or empty;
		R2 - CPF must be valid;
		R3 - Address can be null;
		R4 - It is not possible to register a customer with an existing cpf;
	 * 
	 * @param cpf
	 * @param name
	 * @param country
	 * @param state
	 * @param city
	 * @param street
	 * @param zip
	 * @return Response object with the code and message of the operation.
	 */
	public Response registerCustomer(String cpf, String name, String country, String state, String city, String street,
			String zip) {
		
		Validator validator = new Validator();
		Response response = new Response();
		if (validator.validateName(name) && validator.validateCpf(cpf)) {
			try {
				Address adress = new Address(country, state, city, street, zip);
				Customer customer = new Customer(name, cpf, adress);
				if(customerDAO.searchCustomer(cpf)==null) {
					customerDAO.saveCustomer(customer);
					response.setCode(201);
					response.setMessage(Message.SUCESSFUL_CUSTOMER_REGISTRATION);
				}else {
					response.setCode(403);
					response.setMessage(Message.ERROR_403);
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.setCode(500);
				response.setMessage(Message.ERROR_500);
			}
		} else {
			response.setCode(400);
			response.setMessage(Message.ERROR_400);
		}
		return response;
	}

}
