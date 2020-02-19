package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.ContactPerson;
import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	Customer saveAddressToCustomer(Address myAddress, int customerId);

	public List<Address> getAllAddresses(int theId);

	Customer saveContactToCustomer(ContactPerson myContact, int customerId);

	List<ContactPerson> getContactList(int theId);
	
}
