package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.ContactPerson;
import com.luv2code.springdemo.entity.Customer;

public interface ContactDAO {
	
	public List<Customer> getCustomerList(int contactId);

	ContactPerson getContact(int contactId);

	public ContactPerson updateContact(ContactPerson myContact);

	public void saveContact(ContactPerson myNewContact);

}
