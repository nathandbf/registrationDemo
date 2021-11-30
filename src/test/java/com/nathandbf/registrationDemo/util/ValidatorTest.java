package com.nathandbf.registrationDemo.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	void validCpfTest() {
		Validator validator = new Validator();
		assertTrue(validator.validateCpf("03086012030"));
	}
	
	@Test
	void validCpfWithCharacterTest() {
		Validator validator = new Validator();
		assertTrue(validator.validateCpf("030.860.120-30"));
	}
	@Test
	void invalidCpfWithCharacterTest() {
		Validator validator = new Validator();
		assertFalse(validator.validateCpf("111.111.111-11"));
	}
	
	@Test
	void invalidCpfWithCharacterTest02() {
		Validator validator = new Validator();
		assertFalse(validator.validateCpf("030.860.122-30"));
	}
	@Test
	void invalidCpfNullTest() {
		Validator validator = new Validator();
		assertFalse(validator.validateCpf(null));
	}
	
	@Test
	void invalidCpfBlankTest() {
		Validator validator = new Validator();
		assertFalse(validator.validateCpf("  "));
	}
	
	@Test
	void validNameTest() {
		Validator validator = new Validator();	
		assertTrue(validator.validateName("Name"));
	}
	
	@Test
	void invalidNameBlankTest() {
		Validator validator = new Validator();	
		assertFalse(validator.validateName("    "));
	}
	
	@Test
	void invalidNameEmptyTest() {
		Validator validator = new Validator();	
		assertFalse(validator.validateName(""));
	}
	
	@Test
	void invalidNameNullTest() {
		Validator validator = new Validator();	
		assertFalse(validator.validateName(null));
	}
	
	@Test
	void validNameNull() {
		Validator validator = new Validator();	
		assertFalse(validator.validateName(null));
	}
	
	

}
