package com.nathandbf.registrationDemo.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathandbf.registrationDemo.controller.ControllerCustomer;
import com.nathandbf.registrationDemo.entity.Response;

@Service
public class FacadeApiCustomer {
	@Autowired
	private ControllerCustomer controllerCustomer;
	/**
	 * Method responsible for 'unifying' all controllers method calls for the 
	 * customer register flow.
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
	public Response registerCustomer(String cpf, String name, String country, String state, String city, String street, String zip) {
		return controllerCustomer.registerCustomer(cpf,name,country,state,city,street,zip);
	}

}
