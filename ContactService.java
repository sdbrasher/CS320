/*
 * Name: Sam Brasher
 * Class: CS320-T4512
 * Assignment: Module 3 Milestone
 * 
 * The contact service class implements the List interface to manage an
 * in-memory storage of contacts. 
 */

package contact;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ContactService {
	List<Contact> contactList = new ArrayList<Contact>();
	
	public void addNewContact(String ID, String firstName, String lastName, String address, String phone) {
		ListIterator<Contact> contactIterator = contactList.listIterator();
		while(contactIterator.hasNext()) {
			if(contactIterator.next().getID().equals(ID)) {
				throw new IllegalArgumentException("ID already exists");
			}
		}
		contactList.add(new Contact(ID, firstName, lastName, address, phone));
		
	}
	
	public boolean deleteContact(String ID) {
		ListIterator<Contact> contactIterator = contactList.listIterator();
		while(contactIterator.hasNext()) {
			if(contactIterator.next().getID().equals(ID)) {
				contactList.remove(contactIterator.previousIndex());
				return true;
			}
		}
		
		return false;
	}
	
	public Contact getContact(String ID) {
		ListIterator<Contact> contactIterator = contactList.listIterator();
		while(contactIterator.hasNext()) {
			if(contactIterator.next().getID().equals(ID)) {
				return contactList.get(contactIterator.previousIndex());
			}
		}
				
		return null;
		
	}
	
	public void updateContactFirstName(String ID, String firstName) {
		ListIterator<Contact> contactIterator = contactList.listIterator();
		while(contactIterator.hasNext()) {
			if(contactIterator.next().getID().equals(ID)) {
				contactList.get(contactIterator.previousIndex()).setFirstName(firstName);
			}
		}
	}
	
	public void updateContactLastName(String ID, String lastName) {
		ListIterator<Contact> contactIterator = contactList.listIterator();
		while(contactIterator.hasNext()) {
			if(contactIterator.next().getID().equals(ID)) {
				contactList.get(contactIterator.previousIndex()).setLastName(lastName);
			}
		}
	}
	
	public void updateContactAddress(String ID, String address) {
		ListIterator<Contact> contactIterator = contactList.listIterator();
		while(contactIterator.hasNext()) {
			if(contactIterator.next().getID().equals(ID)) {
				contactList.get(contactIterator.previousIndex()).setAddress(address);
			}
		}
	}
	
	public void updateContactPhone(String ID, String phone) {
		ListIterator<Contact> contactIterator = contactList.listIterator();
		while(contactIterator.hasNext()) {
			if(contactIterator.next().getID().equals(ID)) {
				contactList.get(contactIterator.previousIndex()).setPhone(phone);
			}
		}
	}
}
