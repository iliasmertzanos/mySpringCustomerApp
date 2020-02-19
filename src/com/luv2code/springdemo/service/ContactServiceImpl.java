package com.luv2code.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ContactDAO;
import com.luv2code.springdemo.entity.ContactPerson;
import com.luv2code.springdemo.entity.Customer;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactDAO myContactDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(int contactId){
		List<Customer> myCustomers=myContactDAO.getCustomerList(contactId);
		
//		System.out.println(" Contact List obtained inside ContactServiceImpl: "+myCustomers);
		
		return myCustomers;
		
	}
	
	@Override
	@Transactional
	public ContactPerson saveCustomertToContact(Customer myCustomer, int contactId) {
		ContactPerson myContact=myContactDAO.getContact(contactId);
		List<Customer> customerList=myContactDAO.getCustomerList(contactId);
		
		if(customerList==null ) {
			customerList=new ArrayList<Customer>();
		}		
		
		//save customer into customerlist of contact		
		customerList.add(myCustomer);		
		myContact.setMyCustomerList(customerList);
		
		return myContactDAO.updateContact(myContact);		
	}

	@Override
	@Transactional
	public void saveContact(ContactPerson myNewContact) {
		myContactDAO.saveContact(myNewContact);
		
	}

}
