package com.nathandbf.registrationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nathandbf.registrationDemo.entity.Response;
import com.nathandbf.registrationDemo.facade.FacadeApiCustomer;

@RestController
@RequestMapping
public class Api {
	@Autowired
	private FacadeApiCustomer facade;
	
	/**
	 * Simple test to check if the system is online. 
	 * @return
	 */
	@GetMapping("/isAlive")
	public String isOnline() {
		return "Yes :D";
	}
	

	/**
	 * Method responsible for receiving the parameters and starting the customer registration flow
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
	@PutMapping("/registerCustomer")
	@ResponseBody
	public Response registerCustomer(String cpf,String name,String country, String state, String city,String street,String zip ) {
		return facade.registerCustomer(cpf,name,country,state,city,street,zip);
	}
}
