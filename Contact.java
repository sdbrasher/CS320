/*
 * Name: Sam Brasher
 * Class: CS320-T4512
 * Assignment: Module 3 Milestone
 * 
 * The contact class has fields for a unique ID, first name, last name,
 * address, and phone number. All fields have limitations on size. All 
 * fields have appropriate accessor and mutator functions.
 */

package contact;

public class Contact {
	private String ID;
	private String firstName, lastName;
	private String address;
	private String phone;
	
	public Contact(String ID, String firstName, String lastName, String address, String phone) {
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		if(phone == null || phone.length() != 10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid phone");
		}
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
	
	public void setPhone(String phone) {
		if(phone == null || phone.length() != 10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid phone");
		}
		this.phone = phone;
	}
}
