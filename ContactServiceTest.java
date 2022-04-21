/*
 * Name: Sam Brasher
 * Class: CS320-T4512
 * Assignment: Module 3 Milestone
 * 
 * The contact service test class implements JUnit testing to test
 * requirements of the contact service class including:
 * 		-proper adding, deleting, and storage of contacts
 * 		-proper enforcement of ID uniqueness
 * 		-proper ability to update contact fields
 */

package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	ContactService testContactService = new ContactService();
	
	/*
	 * Here we add a contact to the list, then test to see if a contact was added, 
	 * then ensure that the correct contact was added.
	 */
	
	@Test
	void testAddContact() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");		
		assertTrue(testContactService.contactList.size() == 1);
		assertTrue(testContactService.contactList.get(0).getID().equals("12345"));
	}
	
	/*
	 * Here we ensure that a new contact ID has a unique ID that is not shared by another contact.
	 */
	
	@Test
	void testIDUnique() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertThrows(IllegalArgumentException.class, () -> {testContactService.addNewContact("12345", "Second", "Pen", "123 Test Street", "5558675309");});
	}
	
	/*
	 * Here we add a contact, test that we cannot delete a non-existent contact, that we can
	 * delete the newly added contact, and finally that we successfully deleted the contact.
	 */
	
	@Test
	void testDeleteContact() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertFalse(testContactService.deleteContact("54321"));
		assertTrue(testContactService.deleteContact("12345"));
		assertTrue(testContactService.contactList.size() == 0);
	}
	
	//Here we ensure we cannot retrieve a contact that does not exist.
		
	@Test
	void testGetNonexistantContact() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertNull(testContactService.getContact("54321"));
	}
	
	/*
	 * The following tests ensure we can update a contact's information, and also tests to ensure that
	 * improper input is not allowed. The last line of the tests confirm the change was successful. 
	 */
	
	@Test
	void testUpdateContactFirstName() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactFirstName("12345", "First678901");});
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactFirstName("12345", null);});
		testContactService.updateContactFirstName("12345", "Second");
		assertEquals(testContactService.getContact("12345").getFirstName(), "Second");
	}
	
	@Test
	void testUpdateContactLastName() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactLastName("12345", "Last5678901");});
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactLastName("12345", null);});
		testContactService.updateContactLastName("12345", "Pen");
		assertEquals(testContactService.getContact("12345").getLastName(), "Pen");
	}
	
	@Test
	void testUpdateContactAddress() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactAddress("12345", "1234 Street Road789012345678901");});
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactAddress("12345", null);});
		testContactService.updateContactAddress("12345", "123 Test Street");
		assertEquals(testContactService.getContact("12345").getAddress(), "123 Test Street");
	}
	
	@Test
	void testUpdateContactPhone() {
		testContactService.addNewContact("12345", "First", "Last", "1234 Street Road", "1234567890");
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactPhone("12345", "12345678901");});
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactPhone("12345", "ottffssent");});
		assertThrows(IllegalArgumentException.class, () -> {testContactService.updateContactPhone("12345", null);});
		testContactService.updateContactPhone("12345", "5558675309");
		assertEquals(testContactService.getContact("12345").getPhone(), "5558675309");
	}

}
