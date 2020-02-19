package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.ContactPerson;
import com.luv2code.springdemo.entity.Customer;

public interface ContactService {

	public List<Customer> getCustomers(int contactId);

	public ContactPerson saveCustomertToContact(Customer myCustomer, int contactId);

	public void saveContact(ContactPerson myNewContact);

}
