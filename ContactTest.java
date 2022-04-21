/*
 * Name: Sam Brasher
 * Class: CS320-T4512
 * Assignment: Module 3 Milestone
 * 
 * The contact test class implements JUnit testing to test
 * requirements of the contact class including:
 * 		-proper limitations of size of input
 * 		-proper allowing of input type (char or digit)
 * 		-proper disallowing null inputs
 */

package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	
	//Here we test if a contact was successfully added to the list
	 
	@Test
	void testContactClass() {
		Contact testContact = new Contact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertTrue(testContact.getID().equals("12345"));
		assertTrue(testContact.getFirstName().equals("First"));
		assertTrue(testContact.getLastName().equals("Last"));
		assertTrue(testContact.getAddress().equals("1234 Street Road"));
		assertTrue(testContact.getPhone().equals("1234567890"));
	}
	
	//In the following tests, we ensure that the system only accepts valid input
	@Test
	void testContactIDInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345678901", "First", "Last", "1234 Street Road", "1234567890");} );
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "First", "Last", "1234 Street Road", "1234567890");} );
	}
	
	@Test
	void testContactFirstNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "First678901", "Last", "1234 Street Road", "1234567890");} );
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Last", "1234 Street Road", "1234567890");} );
	}
	
	@Test
	void testContactLastNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "First", "Last5678901", "1234 Street Road", "1234567890");} );
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "First", null, "1234 Street Road", "1234567890");} );
	}
	
	@Test
	void testContactAddressInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "First", "Last", "1234 Street Road789012345678901", "1234567890");} );
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "First", "Last", null, "1234567890");} );
	}
	
	@Test
	void testContactPhoneInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "First", "Last", "1234 Street Road", "12345678901");} );
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "First", "Last", "1234 Street Road", null);} );
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "First", "Last", "1234 Street Road", "ottffssent");} );
	}

}
