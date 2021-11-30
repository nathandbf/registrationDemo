package com.nathandbf.registrationDemo.repository;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nathandbf.registrationDemo.entity.Address;
import com.nathandbf.registrationDemo.entity.Customer;
import com.nathandbf.registrationDemo.entity.Response;
import com.nathandbf.registrationDemo.messages.Message;
import com.nathandbf.registrationDemo.repository.CustomerRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Test
	void validRegistrationTest() {
		Address address = new Address( "USA", "Pennsylvania","Bensalem", "3126 Glen Falls Road", "19020");
		Customer customer = new Customer("John","754.594.040-70" ,address);
		Customer customerInsert = customerRepository.save(customer);
		customer.getAddress().setId(customerInsert.getAddress().getId()); // Test Order may change the value of the id
		assertTrue(customer.equals(customerInsert));
	}
	
	@Test
	void validRegistrationWithouAddressTest() {
		Address address = null;
		Customer customer = new Customer( "John", "754.594.040-70",address);
		Customer customerInsert = customerRepository.save(customer);	
		assertTrue(customer.equals(customerInsert));
	}
	
	@Test
	void searchCustomerValidCpfTest() {
		Address address = new Address( "USA", "Pennsylvania","Bensalem", "3126 Glen Falls Road", "19020");
		Customer customer = new Customer("John","754.594.040-70" ,address);
		customer  = customerRepository.save(customer);	
		Customer customerSearch = customerRepository.findByCpf(customer.getCpf());
		assertTrue(customer.equals(customerSearch));
	}
	
	@Test
	void searchCustomerWithCpfNotInsertedTest() {
		Address address = new Address( "USA", "Pennsylvania","Bensalem", "3126 Glen Falls Road", "19020");
		customerRepository.save( new Customer("John","754.594.040-70" ,address));	
		Customer customerSearch = customerRepository.findByCpf("03086012030");
		assertNull(customerSearch);
	}
}
