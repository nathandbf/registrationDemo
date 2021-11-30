package com.nathandbf.registrationDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathandbf.registrationDemo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCpf(String cpf);

}
