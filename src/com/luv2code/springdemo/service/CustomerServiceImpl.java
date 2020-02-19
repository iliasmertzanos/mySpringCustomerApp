package com.luv2code.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Address;
import com.luv2code.springdemo.entity.ContactPerson;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}
	
	@Override
	@Transactional
	public Customer saveAddressToCustomer(Address myAddress, int customerId) {
		Customer myCustomer=customerDAO.getCustomer(customerId);
		List<Address> customerAddresses=myCustomer.getMyAddressesList();
		
		if(customerAddresses==null || customerAddresses.isEmpty() ) {
			customerAddresses=new ArrayList<Address>();
						
		}		
		myAddress.setCustomer(myCustomer);
		customerAddresses.add(myAddress);		
		myCustomer.setMyAddressesList(customerAddresses);
		
		return customerDAO.updateCustomer(myCustomer);		
	}

	@Override
	@Transactional
	public List<Address> getAllAddresses(int theId) {
		return this.customerDAO.getCustomer(theId).getMyAddressesList();
	}	
	
	@Override
	@Transactional
	public Customer saveContactToCustomer(ContactPerson myContact, int customerId) {
		Customer myCustomer=customerDAO.getCustomer(customerId);
		List<ContactPerson> contactList=customerDAO.getContactList(customerId);
		
		if(contactList==null ) {
			contactList=new ArrayList<ContactPerson>();
		}		
		
		//save customer into customerlist of contact		
		contactList.add(myContact);		
		myCustomer.setMyContactList(contactList);
		
		return customerDAO.updateCustomer(myCustomer);		
	}
	
	@Override
	@Transactional
	public List<ContactPerson> getContactList(int theId){
		List<ContactPerson> contactList=customerDAO.getContactList(theId);
		System.out.println(" Contact list was obtained inside CustomerService .... "+contactList);
		return contactList;
	}
	
}





